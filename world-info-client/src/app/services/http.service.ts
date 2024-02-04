import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, Observer } from 'rxjs';
import {
  IAction,
  IApiDiscovery,
  IApiVersion,
  IMainMenuResponse,
} from '../interfaces/interfaces';
import { Action } from 'rxjs/internal/scheduler/Action';

@Injectable({
  providedIn: 'root',
})
export class HttpService {
  private apiURL = environment.apiURL;
  private apiVersion: string = '';
  private actions: IAction[] = [];

  constructor(private http: HttpClient, private router: Router) {}

  makeRequest(
    action: IAction,
    params: HttpParams | undefined
  ): Observable<any> {
    const url = `${this.apiURL}${action.uri}`;
    return new Observable((observer: Observer<any>) => {
      this.http.request(action.method, url, { params }).subscribe({
        next: (response) => {
          observer.next(response);
          observer.complete();
        },
        error: (error) => {
          observer.error(error);
        },
      });
    });
  }

  getCountrySpokenLanguages(id: number) {
    const url = `${this.apiURL}/countries/${id}/languages`;
    return new Observable((observer: Observer<any>) => {
      this.http.get(url).subscribe({
        next: (response) => {
          observer.next(response);
          observer.complete();
        },
        error: (error) => {
          observer.error(error);
        },
      });
    });
  }

  getMainMenu(): Observable<IMainMenuResponse> {
    this.apiURL = environment.apiURL;
    const url = `${this.apiURL}/versions`;

    return new Observable((observer: Observer<IMainMenuResponse>) => {
      this.http.get<IApiDiscovery>(url).subscribe({
        next: (response: IApiDiscovery) => {
          this.apiVersion = response.apiVersions[0].version;
          this.apiURL = `${this.apiURL}/${this.apiVersion}`;
          // The menuAction contains the URI to get the main menu.
          const menuAction = response.menuAction.uri;
          console.log('API: ', this.apiURL);
          // Use switchMap to switch to the new observable
          this.http
            .get<IMainMenuResponse>(`${this.apiURL}${menuAction}`)
            .subscribe({
              next: (menuResponse: IMainMenuResponse) => {
                observer.next(menuResponse);
                observer.complete();
              },
              error: (error) => {
                observer.error(error);
              },
            });
        },
        error: (error) => {
          console.error('Error getting API version: ', error);
          observer.error(error);
        },
      });
    });
  }
}

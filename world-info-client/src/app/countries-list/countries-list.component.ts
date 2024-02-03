import { Component } from '@angular/core';
import { HttpService } from '../services/http.service';
import { ActionService } from '../services/action.service';
import { IAction, ICountry, IPagination } from '../interfaces/interfaces';
import { Router } from '@angular/router';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-countries-list',
  templateUrl: './countries-list.component.html',
  styleUrls: ['./countries-list.component.scss'],
})
export class CountriesListComponent {
  title = 'Countries List';
  private limit: number = 10;
  private offset: number = 0;
  private orderBy: string = 'name';
  private orderAsc: boolean = true;
  private countries: ICountry[] = [];
  private nextPage: string = '';
  private previousPage: string = '';
  private lastPage: string = '';
  private firstPage: string = '';

  constructor(
    private httpService: HttpService,
    private actionService: ActionService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getCountries();
  }

  getCountries(): void {
    const action: IAction = this.actionService
      .getActions()
      .get('ShowCountries') as IAction;
    const params = new HttpParams()
      .set('limit', this.limit)
      .set('offset', this.offset)
      .set('property', this.orderBy);
    this.httpService.makeRequest(action, params).subscribe({
      next: (response: IPagination) => {
        console.log(response);
        this.setCountries(response.data as ICountry[]);
      },
      error: (error) => {
        console.error(error);
      },
    });
  }

  setCountries(countries: ICountry[]): void {
    this.countries = countries;
  }

  setLimit(limit: number): void {
    this.limit = limit;
  }

  setOffset(offset: number): void {
    this.offset = offset;
  }

  setOrderBy(orderBy: string): void {
    this.orderBy = orderBy;
  }

  setOrderAsc(orderAsc: boolean): void {
    this.orderAsc = orderAsc;
  }
}

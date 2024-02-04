import { ChangeDetectorRef, Component } from '@angular/core';
import { HttpService } from '../services/http.service';
import { ActionService } from '../services/action.service';
import {
  IAction,
  ICountry,
  ICountryPagination,
  IPagination,
} from '../interfaces/interfaces';
import { Router } from '@angular/router';
import { HttpParams } from '@angular/common/http';
import { Pagination } from '../models/pagination';
import { CountryPagination } from '../models/countryPagination';

@Component({
  selector: 'app-countries-list',
  templateUrl: './countries-list.component.html',
  styleUrls: ['./countries-list.component.scss'],
})
export class CountriesListComponent {
  title = 'Countries List';
  private pagination: CountryPagination = new CountryPagination();

  constructor(
    private httpService: HttpService,
    private actionService: ActionService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.getCountriesRequest();
  }

  getCountriesRequest(): void {
    const action: IAction = this.actionService
      .getActions()
      .get('ShowCountries') as IAction;
    this.httpService
      .makeRequest(action, this.pagination.getHttpParams())
      .subscribe({
        next: (response: ICountryPagination) => {
          console.log(response);
          this.pagination = new CountryPagination(response);
          this.cdr.detectChanges();
          console.log(this.getPagination().getCountries());
        },
        error: (error) => {
          console.error(error);
        },
      });
  }

  getPagination(): CountryPagination {
    return this.pagination;
  }
}

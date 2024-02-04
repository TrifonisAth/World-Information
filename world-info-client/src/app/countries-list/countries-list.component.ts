import { Component } from '@angular/core';
import { HttpService } from '../services/http.service';
import { ActionService } from '../services/action.service';
import {
  IAction,
  ICountry,
  ICountryPagination,
} from '../interfaces/interfaces';
import { Router } from '@angular/router';
import { CountryPagination } from '../models/countryPagination';

@Component({
  selector: 'app-countries-list',
  templateUrl: './countries-list.component.html',
  styleUrls: ['./countries-list.component.scss'],
})
export class CountriesListComponent {
  title = 'Countries List';
  private pagination: CountryPagination = new CountryPagination();
  displayedColumns: string[] = ['name', 'area', 'countryCodeTwoLetters'];

  constructor(
    private httpService: HttpService,
    private actionService: ActionService,
    private router: Router
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

  handlePageEvent(event: any): void {
    this.pagination.setOffset(event.pageIndex * event.pageSize);
    this.pagination.setLimit(event.pageSize);
    this.getCountriesRequest();
  }

  onCountryClick(country: ICountry): void {
    console.log('Country Clicked', country);
    this.router.navigate(['countries', country.countryId, 'languages']);
  }
}

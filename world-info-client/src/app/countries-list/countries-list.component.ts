import { Component } from '@angular/core';
import { HttpService } from '../services/http.service';
import { ActionService } from '../services/action.service';
import {
  IAction,
  ICountry,
  ICountryPagination,
} from '../interfaces/interfaces';
import { ActivatedRoute, Router } from '@angular/router';
import { CountryPagination } from '../models/countryPagination';

@Component({
  selector: 'app-countries-list',
  templateUrl: './countries-list.component.html',
  styleUrls: ['./countries-list.component.scss'],
})
export class CountriesListComponent {
  title = 'Countries List';
  private pagination: CountryPagination = new CountryPagination();
  private mode: string = 'ShowCountries';
  displayedColumns: string[] | undefined = [];

  constructor(
    private httpService: HttpService,
    private actionService: ActionService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // Check if the user is in the countries/stats route.
    if (this.router.url.includes('stats')) {
      this.mode = 'ShowCountriesStats';
    }
    if (this.router.url.includes('complete')) {
      this.mode = 'ShowAll';
    }
    this.getCountriesRequest();
  }

  getCountriesRequest(): void {
    const action: IAction = this.actionService
      .getActions()
      .get(this.mode) as IAction;
    this.httpService
      .makeRequest(action, this.pagination.getHttpParams())
      .subscribe({
        next: (response: ICountryPagination) => {
          this.pagination = new CountryPagination(response);
          this.displayedColumns = this.httpService
            .getOrderParams()
            .get(this.mode);
          console.log(response);
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
    if (this.mode !== 'ShowCountries') return;
    this.router.navigate(['countries', country.countryId, 'languages']);
  }

  onPropertyClick(property: string): void {
    this.pagination.setOrderBy(property);
    this.pagination.setOrder(this.isAscending() ? 'DESC' : 'ASC');
    this.getCountriesRequest();
  }

  isSelectedProperty(property: string): boolean {
    return this.pagination.getOrderBy() === property;
  }

  isAscending(): boolean {
    return (
      this.pagination.getOrder() === 'ASC' ||
      this.pagination.getOrder() === 'asc'
    );
  }

  getMode(): string {
    return this.mode;
  }
}

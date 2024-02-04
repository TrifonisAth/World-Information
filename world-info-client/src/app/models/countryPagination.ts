import { ICountry, ICountryPagination } from '../interfaces/interfaces';
import { Pagination } from './pagination';

export class CountryPagination
  extends Pagination
  implements ICountryPagination
{
  countries: ICountry[];

  constructor(response?: ICountryPagination) {
    super();
    this.countries = [];

    if (response) {
      this.setPagination(response);
      this.countries = response.countries;
    }
  }

  setCountries(data: ICountry[]): void {
    this.countries = data;
  }

  getCountries(): ICountry[] {
    return this.countries;
  }
}

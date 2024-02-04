import { HttpParams } from '@angular/common/http';

export interface IApiDiscovery {
  apiVersions: IApiVersion[];
  menuAction: IAction;
}

export interface IApiVersion {
  version: string;
  url: string;
}

export interface IMainMenuResponse {
  title: string;
  menuItems: IMenuItem[];
}

export interface IMenuItem {
  name: string;
  description: string;
  action: IAction;
}

// Used as endpoints for the API.
export interface IAction {
  name: string;
  uri: string;
  method: string;
  params: IActionParam[];
}

export interface IActionParam {
  options: string[];
  name: string;
  type: string;
  description: string;
}

// export interface ISelectActionParam extends IActionParam {
//   options: string[];
// }

export interface IRangeActionParam extends IActionParam {
  min: number;
  max: number;
  step: number;
}

export interface ICountry {
  countryId: number;
  regionId: number;
  name: string;
  area: number;
  nationalDay: Date;
  countryCodeTwoLetters: string;
  countryCodeThreeLetters: string;
  population: number;
  gdp: number;
  gdpPerCapita: number;
  year: number;
  continent: string;
  region: string;
}

export interface ILanguage {
  languageId: number;
  name: string;
  isOfficial: boolean;
}

export interface IPagination {
  pageNumber: number;
  limit: number;
  total: number;
  offset: number;
  orderBy: string;
  order: string;
  links: IPaginationLink[];

  setPagination(pagination: IPagination): void;
  setLimit(limit: number): void;
  setOffset(offset: number): void;
  setOrderBy(orderBy: string): void;
  setOrder(order: string): void;
  setLinks(links: IPaginationLink[]): void;
  setTotal(total: number): void;

  getLimit(): number;
  getOffset(): number;
  getOrderBy(): string;
  getOrder(): string;
  getPageNumber(): number;
  getTotal(): number;
  getLinks(): IPaginationLink[];
  getHttpParams(): HttpParams;

  getPreviousLink(): string;
  getNextLink(): string;
  getFirstLink(): string;
  getLastLink(): string;
}

export interface ICountryPagination extends IPagination {
  countries: ICountry[];

  setCountries(data: ICountry[]): void;
  getCountries(): ICountry[];
}

export interface IPaginationLink {
  name: string;
  uri: string;
}

export interface ISlider {
  min: number;
  max: number;
  step: number;
  from: number;
  to: number;
}

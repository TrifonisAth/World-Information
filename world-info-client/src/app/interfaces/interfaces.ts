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
  name: string;
  type: string;
  description: string;
}

export interface ISelectActionParam extends IActionParam {
  options: string[];
}

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
  data: any[];
}

export interface IPaginationLink {
  name: string;
  uri: string;
}

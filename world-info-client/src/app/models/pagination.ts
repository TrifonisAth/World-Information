import { HttpParams } from '@angular/common/http';
import {
  ICountry,
  ICountryPagination,
  IPagination,
  IPaginationLink,
} from '../interfaces/interfaces';

export abstract class Pagination implements IPagination {
  pageNumber: number;
  limit: number;
  total: number;
  offset: number;
  orderBy: string;
  order: string;
  links: IPaginationLink[];

  constructor() {
    this.pageNumber = 0;
    this.limit = 10;
    this.total = 0;
    this.offset = 0;
    this.orderBy = 'name';
    this.order = 'DESC';
    this.links = [];
  }

  setPagination(pagination: ICountryPagination): void {
    this.pageNumber = pagination.pageNumber;
    this.limit = pagination.limit;
    this.total = pagination.total;
    this.offset = pagination.offset;
    this.orderBy = pagination.orderBy;
    this.order = pagination.order;
    this.links = pagination.links;
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

  setOrder(order: string): void {
    this.order = order;
  }

  setLinks(links: IPaginationLink[]): void {
    this.links = links;
  }

  setTotal(total: number): void {
    this.total = total;
  }

  setPageNumber(pageNumber: number): void {
    this.pageNumber = pageNumber;
  }

  getLimit(): number {
    return this.limit;
  }

  getOffset(): number {
    return this.offset;
  }

  getOrderBy(): string {
    return this.orderBy;
  }

  getOrder(): string {
    return this.order;
  }

  getLinks(): IPaginationLink[] {
    return this.links;
  }

  getTotal(): number {
    return this.total;
  }

  getPageNumber(): number {
    return this.pageNumber;
  }

  getPreviousLink(): string {
    for (const link of this.links) {
      if (link.name === 'prev') {
        return link.uri;
      }
    }
    return '';
  }

  getNextLink(): string {
    for (const link of this.links) {
      if (link.name === 'next') {
        return link.uri;
      }
    }
    return '';
  }

  getLastLink(): string {
    for (const link of this.links) {
      if (link.name === 'last') {
        return link.uri;
      }
    }
    return '';
  }

  getFirstLink(): string {
    for (const link of this.links) {
      if (link.name === 'first') {
        return link.uri;
      }
    }
    return '';
  }

  getHttpParams(): HttpParams {
    return new HttpParams()
      .set('limit', this.limit)
      .set('offset', this.offset)
      .set('property', this.orderBy)
      .set('order', this.order);
  }
}

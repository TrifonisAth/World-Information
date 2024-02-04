import { Component, EventEmitter, Input, Output } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-paginator',
  templateUrl: './paginator.component.html',
  styleUrls: ['./paginator.component.scss'],
})
export class PaginatorComponent {
  // Total number of items.
  @Input() length: number = 100;
  @Input() pageSize: number = 10;
  @Input() pageIndex: number = 0;
  pageSizeOptions = [10, 25, 50, 100];
  hidePageSize = false;
  showPageSizeOptions = true;
  showFirstLastButtons = true;
  disabled = false;
  @Output() pageEventEmitter: EventEmitter<PageEvent> =
    new EventEmitter<PageEvent>();

  handlePageEvent(e: PageEvent) {
    console.log('Paginator Event', e);
    this.pageEventEmitter.emit(e);
    this.length = e.length;
    this.pageSize = e.pageSize;
    this.pageIndex = e.pageIndex;
  }

  setPageSizeOptions(setPageSizeOptionsInput: string) {
    if (setPageSizeOptionsInput) {
      this.pageSizeOptions = setPageSizeOptionsInput
        .split(',')
        .map((str) => +str);
    }
  }
}

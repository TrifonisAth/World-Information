// shared.module.ts
import { NgModule } from '@angular/core';
import { PaginatorComponent } from './paginator.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [PaginatorComponent],
  imports: [
    MatPaginatorModule,
    MatTableModule,
    MatSlideToggleModule,
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
  ],
  exports: [PaginatorComponent],
})
export class SharedModule {}

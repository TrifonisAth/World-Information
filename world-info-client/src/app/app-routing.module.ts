import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CountriesListComponent } from './countries-list/countries-list.component';
import { SpokenLanguagesListComponent } from './spoken-languages-list/spoken-languages-list.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'countries',
    component: CountriesListComponent,
  },
  {
    path: 'countries/:id/languages',
    component: SpokenLanguagesListComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

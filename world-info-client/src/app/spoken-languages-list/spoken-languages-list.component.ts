import { Component } from '@angular/core';
import { HttpService } from '../services/http.service';
import { ActivatedRoute } from '@angular/router';
import { ILanguage } from '../interfaces/interfaces';

@Component({
  selector: 'app-spoken-languages-list',
  templateUrl: './spoken-languages-list.component.html',
  styleUrls: ['./spoken-languages-list.component.scss'],
})
export class SpokenLanguagesListComponent {
  title = 'Spoken Languages List';
  dataSource: ILanguage[] = [];
  displayedColumns: string[] = ['language', 'official'];

  constructor(
    private httpService: HttpService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.getLanguages();
  }

  getLanguages(): void {
    let id = this.route.snapshot.paramMap.get('id');
    if (id === null) return;
    this.httpService.getCountrySpokenLanguages(+id).subscribe({
      next: (response: ILanguage[]) => {
        console.log(response);
        this.dataSource = response;
      },
      error: (error) => {
        console.error(error);
      },
    });
  }
}

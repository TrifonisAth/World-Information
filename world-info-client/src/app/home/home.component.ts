import { Component } from '@angular/core';
import { HttpService } from '../services/http.service';
import { IMainMenuResponse } from '../interfaces/interfaces';
import { ActionService } from '../services/action.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent {
  mainMenu: IMainMenuResponse | undefined;

  constructor(
    private httpService: HttpService,
    private actionService: ActionService
  ) {}

  ngOnInit(): void {
    this.httpService.getMainMenu().subscribe((response: IMainMenuResponse) => {
      this.mainMenu = response;
      this.actionService.clearActions();
      for (let item of this.mainMenu.menuItems) {
        this.actionService.addAction(item.action);
      }
    });
  }
}

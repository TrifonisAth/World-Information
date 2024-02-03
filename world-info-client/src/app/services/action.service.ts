import { Injectable } from '@angular/core';
import { IAction } from '../interfaces/interfaces';

@Injectable({
  providedIn: 'root',
})
export class ActionService {
  private actions: Map<string, IAction> = new Map<string, IAction>();
  constructor() {}

  addAction(action: IAction): void {
    this.actions.set(action.name, action);
  }

  getActions(): Map<string, IAction> {
    return this.actions;
  }

  clearActions(): void {
    this.actions.clear();
  }
}

import { Component, HostListener } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'world-info-client';

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.router.navigate(['']);
  }

  @HostListener('window:beforeunload', ['$event'])
  unloadNotification($event: any): void {
    // Display a confirmation message when the user tries to refresh or close the page
    $event.returnValue = true;
  }
}

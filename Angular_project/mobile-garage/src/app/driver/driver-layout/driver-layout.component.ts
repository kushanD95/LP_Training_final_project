import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-driver-layout',
  templateUrl: './driver-layout.component.html',
  styleUrls: ['./driver-layout.component.scss'],
})
export class DriverLayoutComponent {

  public selectTitle: string;

  public appPages = [
    { title: 'Dashboard', url: '/driver/dashboard', icon: 'mail' },
    { title: 'Add Task', url: '/driver/addtask', icon: 'clipboard' },
    { title: 'My Task', url: '/driver/mytask', icon: 'list' },
    { title: 'Profile', url: '/driver/profile', icon: 'person' },
    { title: 'Report', url: '/driver/report', icon: 'warning' },
    // { title: 'Spam', url: '/folder/Spam', icon: 'warning' },
  ];
  public labels = ['logout'];
  constructor() { }

  selectedTitle(title: string) {
    this.selectTitle = title;
  }

}

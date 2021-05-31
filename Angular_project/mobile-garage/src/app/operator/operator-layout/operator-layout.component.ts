import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-operator-layout',
  templateUrl: './operator-layout.component.html',
  styleUrls: ['./operator-layout.component.scss'],
})
export class OperatorLayoutComponent {

  public appPages = [
    { title: 'Dashboard', url: '/operator/dashboard', icon: 'mail' },
    { title: 'Tasks', url: '/operator/find_task', icon: 'person-add' },
    { title: 'Profile', url: '/operator/profile', icon: 'heart' },
    { title: 'Todo Tasks', url: '/operator/assigned_taska', icon: 'archive' },
    { title: 'Trash', url: '/folder/Trash', icon: 'trash' },
    { title: 'Spam', url: '/folder/Spam', icon: 'warning' },
  ];
  public labels = ['Log out'];
  constructor() { }

}

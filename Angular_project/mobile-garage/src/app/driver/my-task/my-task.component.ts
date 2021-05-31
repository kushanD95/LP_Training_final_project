import { Component, OnInit, ViewChild } from '@angular/core';
import { AgmMap, MapsAPILoader } from '@agm/core';

export interface Location {
  lng: number;
  lat: number;
  icon: any;
}

@Component({
  selector: 'app-my-task',
  templateUrl: './my-task.component.html',
  styleUrls: ['./my-task.component.scss'],
})
export class MyTaskComponent implements OnInit {
  @ViewChild(AgmMap, { static: true }) public agmMap: AgmMap;
  public driverLocations: Location;
  public oparatorLocations: Location;

  public zoom: number = 16;

  constructor(private apiloader: MapsAPILoader) { }

  ngOnInit() {
    this.agmMap.triggerResize(true);
    this.zoom = 16;
    this.driverLocations = { lng: 0, lat: 0, icon: '{ URL: "assets/icon/car-wash.svg" }' };
    this.oparatorLocations = { lng: 10, lat: 10, icon: 'assets/icon/car-repair.svg' };
    console.log(this.driverLocations.icon)
  }


}

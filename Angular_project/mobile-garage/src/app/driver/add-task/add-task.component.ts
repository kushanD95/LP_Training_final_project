import { Component, OnInit, ViewChild } from '@angular/core';
import { AgmMap, MapsAPILoader } from '@agm/core';
import { BackendService } from 'src/app/backend/backend.service';
import { AddTask } from 'src/app/backend/requests/AddTask';
import { Vehicle } from '../driver-profile/driver-profile.component';
import { Location } from '../my-task/my-task.component'

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.scss'],
})
export class AddTaskComponent implements OnInit {

  @ViewChild(AgmMap, { static: true }) public agmMap: AgmMap;
  public lat: any;
  public lng: any;
  public getAddress: any;
  public zoom: number;

  public taskname = '';
  public vehicle: Vehicle;
  public vehicleTypes: Vehicle[] = [];
  public reason = '';
  public images: string[] = [];

  constructor(private apiloader: MapsAPILoader, private backendService: BackendService) { }

  ngOnInit() {
    this.get()
    this.agmMap.triggerResize(true);
    this.zoom = 16;
  }

  get() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position: any) => {
        if (position) {
          this.lat = position.coords.latitude;
          this.lng = position.coords.longitude;
          this.getAddress = (this.lat, this.lng)
          console.log(position)
          this.apiloader.load().then(() => {
            let geocoder = new google.maps.Geocoder;
            let latlng = {
              lat: this.lat,
              lng: this.lng
            };
            geocoder.geocode({
              'location': latlng
            }, function (results) {
              if (results[0]) {
                this.currentLocation = results[0].formatted_address;
                console.log(this.assgin);
              } else {
                console.log('Not found');
              }
            });
          });
        }
      })
    }
  }


  mapClicked($event: any) {

    this.lat = this.agmMap.latitude;
    this.lng = this.agmMap.longitude;
  }

  onSubmit() {
    let location: Location;
    location.lat = this.lat;
    location.lng = this.lng;
    this.backendService.addTask(
      new AddTask(
        this.taskname,
        this.vehicle.id,
        location,
        this.reason,
        this.images
      )
    )
  }

}

import { Component, OnInit, ViewChild } from '@angular/core';
import { Vehicle } from 'src/app/driver/driver-profile/driver-profile.component';
import { User } from 'src/app/enums/user.enum';
import { AgmMap, MapsAPILoader } from '@agm/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss'],
})
export class RegistrationComponent implements OnInit {
  @ViewChild(AgmMap, { static: true }) public agmMap: AgmMap;
  public lat: any;
  public lng: any;
  public getAddress: any;
  public zoom: number;

  public roles = [];
  public role: User;
  public username: string;
  public passowrd: string;
  public fname: string;
  public lname: string;
  public nic: string;
  public tp: number;
  public lisenceNo: string;
  public homeTown: string;
  public vehicles: Vehicle[] = [];

  constructor(private apiloader: MapsAPILoader) { }

  ngOnInit() {
    this.get()
    //this.agmMap.triggerResize(true);
    this.zoom = 16;
    for (const [value, key] of Object.entries(User)) {
      if (!Number.isNaN(Number(key))) {
        continue;
      }
      if (value == User.ADMIN.toString()) {
        continue;
      }
      this.roles.push({ id: key, value: value });
    }

    console.log(this.roles);
    //this.roles = this.roles.slice(this.roles.length / 2);
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

  onSubmit() {
    if (this.role == User.DRIVER) {

    } else if (this.role == User.OPERATOR) {

    }
    console.log(this.role);
  }

  mapClicked($event: any) {

    this.lat = this.agmMap.latitude;
    this.lng = this.agmMap.longitude;
  }

}

import { Component, OnInit } from '@angular/core';
import { Ng2ImgMaxService } from 'ng2-img-max';
import { DomSanitizer } from '@angular/platform-browser';

export const profileDetailsTypes = {
  fname: 'fname',
  lname: 'lname',
  nic: 'nic',
  email: 'email',
  tp: 'tp'
}

export interface Vehicle {
  id: number;
  vehicleNo: string;
  registeredDistrict: string;
  type: string;
  model: string;
}

export const DriverDetails = {
  licenceNo: 'licenceNo',
  homeTown: 'homeTown'

}

export interface userDetailsTypes {
  fname: string;
  lname: string;
  nic: string;
  email: string;
  tp: number;
}

@Component({
  selector: 'app-driver-profile',
  templateUrl: './driver-profile.component.html',
  styleUrls: ['./driver-profile.component.scss'],
})
export class DriverProfileComponent implements OnInit {

  public userDetails: userDetailsTypes;
  public name: string;
  public email = 'sdfghjk';
  public fname = 'sgdajh';
  public lname = 'sdads';
  public nic = 'saasd';
  public tp = 12345678;
  public licenceNo = 'yeibwf';
  public homeTown = 'fsb';
  public vehicles: Vehicle[] = [{ id: 1, vehicleNo: 'wertyui', registeredDistrict: 'xdcfgh', type: 'xcvbnm', model: 'xcvbhnjm' }, { id: 2, vehicleNo: 'kjhgfd', registeredDistrict: 'xcvbn', type: 'crtvybui', model: 'hbh' }];

  public isDisableFname = true;
  public isDisableLname = true;
  public isDisableEmail = true;
  public isDisableNic = true;
  public isDisableTp = true;
  public isDisableLicenceNo = true;
  public isDisableHomeTown = true;
  private isNotChangeData = true

  uploadedImage: Blob;
  imagePreview: string;

  constructor(private ng2ImgMax: Ng2ImgMaxService, public sanitizer: DomSanitizer) { }

  ngOnInit() {
  }

  onImageChange(event) {
    let image = event.target.files[0];

    this.ng2ImgMax.resizeImage(image, 300, 300).subscribe(
      result => {
        this.uploadedImage = new File([result], result.name);
        '<span class="code-annotation">this.getImagePreview(this.uploadedImage);</span>'
      },
      error => {
        console.log(error);
      }
    );
  }

  changeDetails(type: string) {
    this.isNotChangeData = false;
    if (type) {
      if (type == profileDetailsTypes.fname) {

        this.isDisableFname = !this.isDisableFname;

      } else if (type == profileDetailsTypes.lname) {

        this.isDisableLname = !this.isDisableLname;

      } else if (type == profileDetailsTypes.nic) {

        this.isDisableNic = !this.isDisableNic;

      } else if (type == profileDetailsTypes.email) {

        this.isDisableEmail = !this.isDisableEmail;

      } else if (type == profileDetailsTypes.tp) {

        this.isDisableTp = !this.isDisableTp;

      } else if (type == DriverDetails.licenceNo) {

        this.isDisableLicenceNo = !this.isDisableLicenceNo;

      } else if (type == DriverDetails.homeTown) {

        this.isDisableHomeTown = !this.isDisableHomeTown;

      }
    }
  }

}

import { Component, OnInit, ViewChild } from '@angular/core';
import { AgmMap, MapsAPILoader } from '@agm/core';
// import { ModalController } from '@ionic/angular/providers/modal-controller';

export interface Location {
  lng: number;
  lat: number;
  icon: any;
}

@Component({
  selector: 'app-find-task',
  templateUrl: './find-task.component.html',
  styleUrls: ['./find-task.component.scss'],
})
export class FindTaskComponent implements OnInit {

  @ViewChild(AgmMap, { static: true }) public agmMap: AgmMap;
  public zoom: number = 16;

  public images: any[] = [];

  public driverLocations: Location;

  constructor(private apiloader: MapsAPILoader,
    //private modelCtrl: ModalController
  ) { }

  ngOnInit() {
    this.driverLocations = { lng: 10, lat: 10, icon: 'assets/icon/car-repair.svg' };
  }

  openGallery() {
    // let model = this.modelCtrl.create(GalleryModal, {
    //   photos: this.images
    // });

    // model.pr
  }

}

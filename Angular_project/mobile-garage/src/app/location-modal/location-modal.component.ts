import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MyTaskComponent } from '../driver/my-task/my-task.component';


@Component({
  selector: 'app-location-modal',
  templateUrl: './location-modal.component.html',
  styleUrls: ['./location-modal.component.scss'],
})
export class LocationModalComponent implements OnInit {

  private popupMode: boolean;

  constructor(public dialogRef: MatDialogRef<LocationModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { popupMode: boolean }) {

    if (data) {
      this.popupMode = data.popupMode;
    }
  }

  ngOnInit() { }

  public closeMe() {
    this.dialogRef.close();
  }

}

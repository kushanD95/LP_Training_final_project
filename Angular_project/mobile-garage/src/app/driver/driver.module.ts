import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouteReuseStrategy } from '@angular/router';
import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { DriverRoutingModule } from './driver-routing.module';
import { Ng2ImgMaxModule } from 'ng2-img-max';
import { DriverLayoutComponent } from './driver-layout/driver-layout.component';
import { DriverDashboardComponent } from './driver-dashboard/driver-dashboard.component';
import { AddTaskComponent } from './add-task/add-task.component';
import { DriverProfileComponent } from './driver-profile/driver-profile.component';
import { MyTaskComponent } from './my-task/my-task.component';
import { AgmCoreModule } from '@agm/core';
import { LocationModalComponent } from '../location-modal/location-modal.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { ReportOparatorComponent } from './report-oparator/report-oparator.component';



@NgModule({
  declarations: [
    DriverLayoutComponent,
    DriverDashboardComponent,
    AddTaskComponent,
    MyTaskComponent,
    DriverProfileComponent,
    LocationModalComponent,
    ReportOparatorComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    DriverRoutingModule,
    IonicModule.forRoot(),
    MatDialogModule,
    MatButtonModule,
    MatCardModule,
    Ng2ImgMaxModule,
    AgmCoreModule.forRoot({
      apiKey:
    }),
  ],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }],
  entryComponents: [LocationModalComponent]
})
export class DriverModule { }

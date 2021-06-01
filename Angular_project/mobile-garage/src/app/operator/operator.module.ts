import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouteReuseStrategy } from '@angular/router';
import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { OperatorRoutingModule } from './operator-routing.module';
import { OperatorLayoutComponent } from './operator-layout/operator-layout.component';
import { OperatorDashboardComponent } from './operator-dashboard/operator-dashboard.component';
import { FindTaskComponent } from './find-task/find-task.component';
import { AgmCoreModule } from '@agm/core';
import { OperatorProfileComponent } from './operator-profile/operator-profile.component';
import { AssignedTaskComponent } from './assigned-task/assigned-task.component';



@NgModule({
  declarations: [
    OperatorLayoutComponent,
    OperatorDashboardComponent,
    FindTaskComponent,
    OperatorProfileComponent,
    AssignedTaskComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    OperatorRoutingModule,
    IonicModule.forRoot(),
    AgmCoreModule.forRoot({
      apiKey:
    }),
  ],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }],
})
export class OperatorModule { }

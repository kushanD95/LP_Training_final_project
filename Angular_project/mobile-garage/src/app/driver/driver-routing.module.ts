import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AddTaskComponent } from "./add-task/add-task.component";
import { DriverDashboardComponent } from "./driver-dashboard/driver-dashboard.component";
import { DriverLayoutComponent } from "./driver-layout/driver-layout.component";
import { DriverProfileComponent } from "./driver-profile/driver-profile.component";
import { MyTaskComponent } from "./my-task/my-task.component";
import { ReportOparatorComponent } from "./report-oparator/report-oparator.component";

const routes: Routes = [
    {
        path: '', component: DriverLayoutComponent,
        children: [
            {
                path: '', pathMatch: 'full', redirectTo: 'dashboard'
            },
            {
                path: 'dashboard', component: DriverDashboardComponent,
            },
            {
                path: 'addtask', component: AddTaskComponent,
            },
            {
                path: 'mytask', component: MyTaskComponent,
            },
            {
                path: 'profile', component: DriverProfileComponent,
            },
            {
                path: 'report', component: ReportOparatorComponent,
            }
        ]
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class DriverRoutingModule { }
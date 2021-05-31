import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AssignedTaskComponent } from "./assigned-task/assigned-task.component";
import { FindTaskComponent } from "./find-task/find-task.component";
import { OperatorDashboardComponent } from "./operator-dashboard/operator-dashboard.component";
import { OperatorLayoutComponent } from "./operator-layout/operator-layout.component";
import { OperatorProfileComponent } from "./operator-profile/operator-profile.component";

const routes: Routes = [
    {
        path: '', component: OperatorLayoutComponent,
        children: [
            {
                path: '', pathMatch: 'full', redirectTo: 'dashboard'
            },
            {
                path: 'dashboard', component: OperatorDashboardComponent,
            },
            {
                path: 'find_task', component: FindTaskComponent,
            },
            {
                path: 'profile', component: OperatorProfileComponent,
            },
            {
                path: 'assigned_taska', component: AssignedTaskComponent,
            }
        ]
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class OperatorRoutingModule { }
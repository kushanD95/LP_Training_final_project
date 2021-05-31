import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { AdminUnapprovedComponent } from './admin-unapproved/admin-unapproved.component';

const routes: Routes = [
    {
        path: '', component: AdminLayoutComponent,
        children: [
            {
                path: '', pathMatch: 'full', redirectTo: 'dashboard'
            },
            {
                path: 'dashboard', component: AdminDashboardComponent
            },
            {
                path: 'unapprovedOperators', component: AdminUnapprovedComponent
            }
        ]
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class AdminRoutingModule { }

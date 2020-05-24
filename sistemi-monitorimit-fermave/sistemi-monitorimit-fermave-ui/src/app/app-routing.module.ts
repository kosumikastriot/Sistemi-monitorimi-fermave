import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AdminComponent} from './layout/admin/admin.component';

const routes: Routes = [
  {
    path: '',
    component: AdminComponent,
    children: [
      {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full'
      },
      {
        path: 'dashboard',
        loadChildren: './sistemi-monitorimit-fermave/dashboard/dashboard.module#DashboardModule'
      },
      {
        path: 'pajisjet',
        loadChildren: './sistemi-monitorimit-fermave/pajisjet/pajisjet.module#PajisjetModule'
      },
      {
        path: 'senzoret',
        loadChildren: './sistemi-monitorimit-fermave/senzoret/senzoret.module#SenzoretModule'
      },
      {
        path: 'konfigurimet',
        loadChildren: './sistemi-monitorimit-fermave/konfigurimet/konfigurimet.module#KonfigurimetModule'
      },
      {
        path: 'simulimi',
        loadChildren: './sistemi-monitorimit-fermave/simulimi/simulimi.module#SimulimiModule'
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

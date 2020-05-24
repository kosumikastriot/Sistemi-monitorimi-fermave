import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SenzoretComponent} from './senzoret.component';

const routes: Routes = [
  {
    path: '',
    component: SenzoretComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SenzoretRoutingModule { }

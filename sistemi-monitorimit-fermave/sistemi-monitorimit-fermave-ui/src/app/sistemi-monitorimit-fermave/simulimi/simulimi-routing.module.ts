import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SimulimiComponent} from './simulimi.component';

const routes: Routes = [
  {
    path: '',
    component: SimulimiComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SimulimiRoutingModule { }

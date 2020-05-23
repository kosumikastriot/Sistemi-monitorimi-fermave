import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PajisjetComponent} from './pajisjet.component';

const routes: Routes = [
  {
    path: '',
    component: PajisjetComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PajisjetRoutingModule { }

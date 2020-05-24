import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {KonfigurimetComponent} from './konfigurimet.component';

const routes: Routes = [
  {
    path: '',
    component: KonfigurimetComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class KonfigurimetRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { KonfigurimetComponent } from './konfigurimet.component';
import {KonfigurimetRoutingModule} from './konfigurimet-routing.module';
import {SharedModule} from '../../shared/shared.module';
import {ChartModule} from 'angular2-chartjs';
import {FormsModule} from '@angular/forms';
import {ToastyModule} from 'ng2-toasty';

@NgModule({
  imports: [
    CommonModule,
    KonfigurimetRoutingModule,
    SharedModule,
    ChartModule,
    FormsModule,
    ToastyModule
  ],
  declarations: [KonfigurimetComponent]
})
export class KonfigurimetModule { }

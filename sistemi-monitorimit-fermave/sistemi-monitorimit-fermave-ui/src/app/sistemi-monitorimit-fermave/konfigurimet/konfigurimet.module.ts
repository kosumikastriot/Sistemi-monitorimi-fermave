import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { KonfigurimetComponent } from './konfigurimet.component';
import {KonfigurimetRoutingModule} from './konfigurimet-routing.module';
import {SharedModule} from '../../shared/shared.module';
import {ChartModule} from 'angular2-chartjs';

@NgModule({
  imports: [
    CommonModule,
    KonfigurimetRoutingModule,
    SharedModule,
    ChartModule
  ],
  declarations: [KonfigurimetComponent]
})
export class KonfigurimetModule { }

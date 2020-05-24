import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SimulimiComponent } from './simulimi.component';
import {SimulimiRoutingModule} from './simulimi-routing.module';
import {SharedModule} from '../../shared/shared.module';
import {ChartModule} from 'angular2-chartjs';

@NgModule({
  imports: [
    CommonModule,
    SimulimiRoutingModule,
    SharedModule,
    ChartModule
  ],
  declarations: [SimulimiComponent]
})
export class SimulimiModule { }

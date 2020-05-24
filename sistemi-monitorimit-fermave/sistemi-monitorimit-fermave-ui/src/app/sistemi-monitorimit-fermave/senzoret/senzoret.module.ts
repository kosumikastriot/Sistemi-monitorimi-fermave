import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SenzoretComponent } from './senzoret.component';
import {SenzoretRoutingModule} from './senzoret-routing.module';
import {SharedModule} from '../../shared/shared.module';
import {ChartModule} from 'angular2-chartjs';

@NgModule({
  imports: [
    CommonModule,
    SenzoretRoutingModule,
    SharedModule,
    ChartModule
  ],
  declarations: [SenzoretComponent]
})
export class SenzoretModule { }

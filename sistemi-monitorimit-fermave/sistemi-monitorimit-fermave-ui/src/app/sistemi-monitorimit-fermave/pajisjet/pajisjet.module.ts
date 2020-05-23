import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PajisjetComponent } from './pajisjet.component';
import {PajisjetRoutingModule} from './pajisjet-routing.module';
import {SharedModule} from '../../shared/shared.module';
import {ChartModule} from 'angular2-chartjs';

@NgModule({
  imports: [
    CommonModule,
    PajisjetRoutingModule,
    SharedModule,
    ChartModule
  ],
  declarations: [PajisjetComponent]
})
export class PajisjetModule { }

import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {KonfigurimiService} from '../../services/konfigurimi-service';
import {KonfigurimiAll} from '../../classes/konfigurimi/konfigurimi-all';
import {KonfigurimiUpdate} from '../../classes/konfigurimi/konfigurimi-update';
import {animate, style, transition, trigger} from '@angular/animations';
import {ToastOptions, ToastyService} from 'ng2-toasty';
// @ts-ignore
import {FieldError} from '../../classes/common/field-error';

@Component({
  selector: 'app-simple-page',
  templateUrl: './konfigurimet.component.html',
  styleUrls: ['./konfigurimet.component.scss',
    '../../../assets/icon/icofont/css/icofont.scss',
    '../../../../node_modules/ng2-toasty/style-material.css'],
  encapsulation: ViewEncapsulation.None,
  animations: [
    trigger('fadeInOutTranslate', [
      transition(':enter', [
        style({opacity: 0}),
        animate('400ms ease-in-out', style({opacity: 1}))
      ]),
      transition(':leave', [
        style({transform: 'translate(0)'}),
        animate('400ms ease-in-out', style({opacity: 0}))
      ])
    ])
  ]
})

export class KonfigurimetComponent implements OnInit {
  msg = '';
  position = 'bottom-right';

  vleraMinClass: String;
  vleraMaxClass: String;

  konfigurimet: Array<KonfigurimiAll>;

  constructor(private konfigurimiService: KonfigurimiService,
              private toastyService: ToastyService) { }

  ngOnInit() {
    this.setDefaultClasses();
    this.getAll();
  }

  getAll() {
    this.konfigurimiService.getAll().subscribe(
      success => {
        this.konfigurimet = success;
      }
    );
  }

  update(id, min, max) {
    if (min > max){
      this.msg = 'Vlera minimale nuk mund te jete me e madhe se ajo maksimale!'
      this.toastError();
    }else if (min == null || max == null){
      this.msg = 'Vlerat nuk mund te jene te zbrazta!'
      this.toastError();
    }else{
      this.konfigurimiService.update(new KonfigurimiUpdate(id,min,max)).subscribe(
        success => {
          this.msg = 'Nryshimet jane ruajtur.';
          this.toast();
          this.getAll();
        }, error => {
          let errors: Array<FieldError> = error.error;
          console.log(errors);
        }
      );
    }
  }

  setDefaultClasses(){
    this.vleraMaxClass = "form-control form-control-primary";
    this.vleraMinClass = "form-control form-control-primary";
  }

  toast() {
    this.toastyService.clearAll();
    const toastOptions: ToastOptions = {
      title: 'SUKSES',
      msg: this.msg,
      showClose: true,
      timeout: 6000,
      theme: 'material'
    };
    this.toastyService.success(toastOptions);
  }

  toastError() {
    this.toastyService.clearAll();
    const toastOptions: ToastOptions = {
      title: 'GABIM',
      msg: this.msg,
      showClose: true,
      timeout: 8000,
      theme: 'material'
    };
    this.toastyService.error(toastOptions);
  }

}

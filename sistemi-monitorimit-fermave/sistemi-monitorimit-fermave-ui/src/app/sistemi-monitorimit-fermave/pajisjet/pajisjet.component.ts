import {Component, OnInit} from '@angular/core';
// @ts-ignore
import {PajisjaDto} from '../../classes/pajisja/pajisja-dto';

import * as SockJS from 'sockjs-client';
import * as Stomp from 'stompjs';

@Component({
  selector: 'app-simple-page',
  templateUrl: './pajisjet.component.html',
  styleUrls: ['./pajisjet.component.scss',
    '../../../assets/icon/icofont/css/icofont.scss']
})
export class PajisjetComponent implements OnInit {

  //Websocket
  url = 'http://localhost:8080/monitorimi-fermave-ws'
  client: any;
  pajisjet: Array<PajisjaDto>;

  constructor() { }

  ngOnInit() {

    this.connection();

  }

  connection(){
    let ws = new SockJS (this.url);
    this.client = Stomp.over(ws);
    let that = this;

    this.client.connect({}, function(frame) {
      that.client.subscribe('/topic/pajisjet', (message) => {

        if(message.body) {
          let json = JSON.parse(message.body);
          that.pajisjet = json;
        }
      });
    });
  }



}

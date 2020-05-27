import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {KonfigurimiAll} from '../classes/konfigurimi/konfigurimi-all';
import {KonfigurimiUpdate} from '../classes/konfigurimi/konfigurimi-update';

@Injectable({
  providedIn: 'root'
})
export class KonfigurimiService{

  public options = {
    headers: new HttpHeaders().set('Content-Type', 'application/json')
  };

  constructor(private http: HttpClient) { }

  getAll(){
    return this.http.get<Array<KonfigurimiAll>>(`${environment.domain}/konfigurimi`);
  }

  update(konfigurimi) {
    return this.http.put<KonfigurimiUpdate>(`${environment.domain}/konfigurimi`, konfigurimi, this.options);
  }

}

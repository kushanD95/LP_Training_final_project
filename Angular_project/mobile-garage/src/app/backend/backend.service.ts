import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { stringify } from '@angular/compiler/src/util';
import { Injectable } from '@angular/core';
import { Form } from '@angular/forms';
import { Router } from '@angular/router';
import { BehaviorSubject, Subject } from 'rxjs';
import { DataStore } from '../data-store/data-store';
import { User } from '../enums/user.enum';
import { AddTask } from './requests/AddTask';
import { Url } from './url';

export enum RequestTypes {
  GET,
  POST,
  UPDATE,
  DELETE
}

@Injectable({
  providedIn: 'root'
})
export class BackendService {
  private readonly authStatus$: BehaviorSubject<any>;
  private readonly responseStatus$: BehaviorSubject<any>;

  constructor(private dataStore: DataStore, private http: HttpClient, private router: Router) {
    this.authStatus$ = new BehaviorSubject({
      status: 200
    })
  }

  sendToAuth(form: any): any {
    const HTTP_OPTIONS = {
      headers: new HttpHeaders({
        'Content-Type': 'application/x-www-form-urlencoded',
        Authorization: 'Basic ' + btoa('mobile' + ':' + 'pin')
      })
    };

    this.http.post(Url.AUTH_URL_PREFIX + "oauth/token", form, HTTP_OPTIONS).toPromise().then((data) => {
      this.dataStore.authData = data;

      this.verifyToken(this.dataStore.accessToken);

    }, (error) => {
      this.authStatus$.next(error.status);
    });

  }

  public get authStatus(): Subject<any> {
    return this.authStatus$;
  }

  async verifyToken(token: string) {

    const HTTP_OPTIONS = {
      headers: new HttpHeaders({
        Authorization: 'Basic ' + btoa('mobile' + ':' + 'pin')
      })
    };

    this.http.get(Url.AUTH_URL_PREFIX + "oauth/check_token?token=" + token, HTTP_OPTIONS).toPromise().then((data) => {
      this.dataStore.checkToken = data;

      this.dataStore.checkToken.authorities.forEach(authority => {
        if (authority == 'ROLE_admin') {
          this.router.navigateByUrl('/admin');
        } else if (authority == 'ROLE_driver') {
          this.router.navigateByUrl('/driver');;
        } else if (authority == 'ROLE_operator') {
          this.router.navigateByUrl('/operator')
        }
      });
    });
  }


  async addTask(task: AddTask): Promise<any> {
    task.isDone = false;
    const response = await this.sendToTaskService(Url.GARAGE_URL_PREFIX + "task", RequestTypes.POST, task, this.createHeaders());
    this.dataStore.setTaskData(response);

  }

  sendToTaskService(url: string, method: RequestTypes, headers: any, data?: any,): any {

    if (method == RequestTypes.GET) {

    } else if (method == RequestTypes.POST) {

      this.http.post(url, data, headers).toPromise().then(data => {
        return data;
      }, (error) => {
        this.responseStatus$.next(error.status);
      });

    } else if (method == RequestTypes.UPDATE) {

    } else if (method == RequestTypes.DELETE) {

    }
  }

  private createHeaders() {
    const HTTP_OPTIONS = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'bearer ' + this.dataStore.accessToken
      })
    }
    return HTTP_OPTIONS;
  }


}

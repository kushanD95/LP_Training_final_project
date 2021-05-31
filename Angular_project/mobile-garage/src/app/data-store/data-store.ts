import { Injectable } from '@angular/core';
import { AddTask } from '../backend/requests/AddTask';

export class AuthData {
  access_token: string;
  token_type: string;
  refresh_token: string;
  expires_in: number;
  scope: string;
}

export class ResponseLocation {
  id: string;
  logtitute: number;
  latitude: number;
}

export class Check_token {
  aud: string[];
  user_name: string;
  scope: string;
  active: boolean;
  exp: number;
  authorities: string[];

  constructor(checkToken: Check_token) {
    this.active = checkToken.active;
    this.aud = checkToken.aud;
    this.authorities = checkToken.authorities;
    this.exp = checkToken.exp;
    this.scope = checkToken.scope;
    this.user_name = checkToken.user_name;
  }
}

export class TaskData {
  id: string;
  driver_id: number;
  operatorId: number;
  location: ResponseLocation;
  is_done: boolean;
  reason: string;
  images: string[];

  constructor(task: TaskData) {
    this.id = task.id;
    this.driver_id = task.driver_id;
    this.operatorId = task.operatorId;
    this.is_done = task.is_done;
    this.location.id = task.location.id;
    this.location.latitude = task.location.latitude;
    this.location.logtitute = task.location.logtitute;
    this.reason = task.reason;

  }
}

@Injectable({
  providedIn: 'root'
})
export class DataStore {

  constructor() { }

  private _authData: AuthData = new AuthData();
  private _checkToken: Check_token;
  private _taskData: AddTask[] = [];


  public set authData(data: any) {


    this._authData.access_token = data.access_token;
    this._authData.expires_in = data.expires_in;
    this._authData.refresh_token = data.refresh_token;
    this._authData.scope = data.scope;
    this._authData.token_type = data.token_type;


    console.log(this._authData)


  }

  public get authData(): any {
    return this._authData;
  }

  public get accessToken(): string {
    return this._authData.access_token;
  }

  public get checkToken(): any {
    return this._checkToken;
  }

  public set checkToken(check_token: any) {
    this._checkToken = new Check_token(check_token);
  }

  public setTaskData(taskData: AddTask) {
    const addTask = new AddTask(taskData.name, taskData.vehicleId, taskData.location, taskData.reason, taskData.images);
    addTask.driverId = taskData.driverId;
    addTask.isDone = taskData.isDone;
    this._taskData.push(addTask);
  }

  public getTaskData(): AddTask[] {
    return this._taskData;
  }



}

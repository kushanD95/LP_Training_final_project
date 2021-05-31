import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BackendService } from './backend.service';
import { DataStore } from '../data-store/data-store';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
  ],
  providers: [
    BackendService,
    DataStore,
  ],
  exports: [
    BackendService,
    DataStore,
  ]
})
export class BackendModule { }

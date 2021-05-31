import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginModule } from './login/login.module';
import { HttpClientModule } from '@angular/common/http';
import { AdminModule } from './admin/admin.module';
import { DriverModule } from './driver/driver.module';
import { OperatorModule } from './operator/operator.module';
import { AgmCoreModule, MarkerManager, AgmMap, MapsAPILoader } from '@agm/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { HAMMER_GESTURE_CONFIG } from '@angular/platform-browser';
@NgModule({
  declarations: [AppComponent],
  entryComponents: [],
  imports: [
    FormsModule,
    BrowserModule,
    IonicModule.forRoot(),
    AppRoutingModule,
    LoginModule,
    AdminModule,
    DriverModule,
    OperatorModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyA-FJ-a9wWCzDlX9K7HXqR9KGObaU0fYGA'
    }),
  ],
  exports: [
    IonicModule,
    BrowserModule,
    AgmCoreModule,
    BrowserAnimationsModule,
  ],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy },

    // { provide: HAMMER_GESTURE_CONFIG, useClass: ionicGalleryModal.GalleryModalHammerConfig }
  ],
  bootstrap: [AppComponent],
})
export class AppModule { }

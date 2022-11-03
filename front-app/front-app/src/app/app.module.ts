import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RegistrationComponent } from './registration/registration.component';
import { HomepageComponent } from './homepage/homepage.component';

import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { ActivationAccountComponent } from './activation-account/activation-account.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    HomepageComponent,
    LoginComponent,
    ActivationAccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    NoopAnimationsModule,
    MatSnackBarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

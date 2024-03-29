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
import { BloodTransfusionCenterComponent } from './blood-transfusion-center/blood-transfusion-center.component';
import {MatSelectModule} from '@angular/material/select';
import {MatRadioModule} from '@angular/material/radio';
import {MatIconModule} from '@angular/material/icon';
import { QuestionnaireComponent } from './questionnaire/questionnaire.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { CenterInfoComponent } from './center-info/center-info.component';
import {MatListModule} from '@angular/material/list';
import { NotPassedAppointmentsComponent } from './not-passed-appointments/not-passed-appointments.component';
import { VisitingCentersHistoryComponent } from './visiting-centers-history/visiting-centers-history.component';
import { QrCodesComponent } from './qr-codes/qr-codes.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    HomepageComponent,
    LoginComponent,
    ActivationAccountComponent,
    BloodTransfusionCenterComponent,
    QuestionnaireComponent,
    UserProfileComponent,
    CenterInfoComponent,
    NotPassedAppointmentsComponent,
    VisitingCentersHistoryComponent,
    QrCodesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    NoopAnimationsModule,
    MatSnackBarModule,
    MatSelectModule,
    MatRadioModule,
    MatIconModule,
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

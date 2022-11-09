import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActivationAccountComponent } from './activation-account/activation-account.component';
import { BloodTransfusionCenterComponent } from './blood-transfusion-center/blood-transfusion-center.component';
import { CenterInfoComponent } from './center-info/center-info.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { NotPassedAppointmentsComponent } from './not-passed-appointments/not-passed-appointments.component';
import { QuestionnaireComponent } from './questionnaire/questionnaire.component';
import { RegistrationComponent } from './registration/registration.component';
import { AthguardGuard } from './shared/athguard.guard';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [
  {path: 'registration', component: RegistrationComponent},
  {path: '', component: HomepageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'accountActivation', component: ActivationAccountComponent},
  {path: 'centers', component: BloodTransfusionCenterComponent},
  {path: 'questionnaire', component: QuestionnaireComponent , canActivate: [AthguardGuard], data:{role: 'ROLE_REGISTEREDUSER'}},
  {path: 'profile', component: UserProfileComponent , canActivate: [AthguardGuard], data:{role: 'ROLE_REGISTEREDUSER'}},
  {path: 'center/:id', component: CenterInfoComponent , canActivate: [AthguardGuard], data:{role: 'ROLE_REGISTEREDUSER'}},
  {path: 'notPassedAppointments', component: NotPassedAppointmentsComponent , canActivate: [AthguardGuard], data:{role: 'ROLE_REGISTEREDUSER'}},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

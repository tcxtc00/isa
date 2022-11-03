import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActivationAccountComponent } from './activation-account/activation-account.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  {path: 'registration', component: RegistrationComponent},
  {path: '', component: HomepageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'accountActivation', component: ActivationAccountComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

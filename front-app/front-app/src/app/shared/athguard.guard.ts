import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AthguardGuard implements CanActivate {

  userType: any;
 
  canActivate(route: ActivatedRouteSnapshot){
    if(route.data['role'] != this.getRole()) {     
      return false;
    }
    return true;
  }

  getRole() {

    let userStrng = localStorage.getItem('user');
    this.userType = '';

    if(userStrng) {
      let user = JSON.parse(userStrng);
      this.userType = user.userType;
      return this.userType;
    }
    return this.userType;
  }
  
}

import { CDK_CONNECTED_OVERLAY_SCROLL_STRATEGY } from '@angular/cdk/overlay/overlay-directives';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';

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
    this.userType = ' ';

    if(userStrng) {
      let user = JSON.parse(userStrng);
      this.userType = user.userType;
      return this.userType;
    }
    return this.userType;
  }
  
}

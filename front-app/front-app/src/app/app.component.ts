import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front-app';

 user: any
 role: any

  ngOnInit(): void {
    let userStrng = localStorage.getItem('user');
    if(userStrng) {
      this.user = JSON.parse(userStrng);
      this.role = this.user.userType

    }
  }

  logout(){
    localStorage.clear();
    location.replace('/');
  }
}

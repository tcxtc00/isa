import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email = ''
  password = ''
  emptyEmail = false
  emptyPassword = false
  user: any

  constructor(private matSnackBar: MatSnackBar, private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  checkEmail(){
    console.log(this.email)
    if(this.email == ''){
      this.emptyEmail = true;
    }else{
      this.emptyEmail = false;
    }
  }

  checkPassword(){
    console.log(this.password)
    if(this.password == ''){
      this.emptyPassword = true;
    }else{
      this.emptyPassword = false;
    }
  }

  login(){

    if(this.email == ''){
      this.emptyEmail = true;
    }else if(this.password == ''){
      this.emptyPassword = true;
    }else{
      let data = {
        username: this.email,
        password: this.password
      }
      this.userService.login(data).subscribe((response: any) => {
        localStorage.setItem('token', response.accessToken);
        localStorage.setItem('expiresIn', response.expiresIn);
        this.userService.current().subscribe((response: any) => {
          this.user = response;
          localStorage.setItem('user', JSON.stringify(this.user));
          console.log(this.user);
          location.replace('/')
          
        })
        
      }, error => {
        this.matSnackBar.open('Email i lozinka nisu ispravni ili niste aktivirali nalog.', 'Close', {duration: 3500})
      })
    }
    
  }

}

import { Component, OnInit } from '@angular/core';

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

  constructor() { }

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
      console.log(this.email)
    }
    
    
  }

}

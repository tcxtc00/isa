import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  name = ''
  surname = ''
  email = ''
  gender = ''
  jmbg = ''
  address = ''
  city = ''
  country = ''
  profession = ''
  info = ''
  phoneNumber = ''
  password = ''
  confirmPassword = ''

  emptyName = false
  emptyEmail = false
  emptySurname = false
  emptyGender = false
  emptyJmbg = false
  emptyAddress = false
  emptyCity = false
  emptyCountry = false
  emptyProfession = false
  emptyInfo = false
  emptyPhone = false
  emptyPassword = false
  emptyConfirmPassword = false

  constructor() { }

  ngOnInit(): void {
  }

  register(){

    if(this.email == ''){
      this.emptyEmail = true;
    }else if(this.name == ''){
      this.emptyName = true;
    }else if(this.surname == ''){
      this.emptySurname = true;
    }else if(this.address == ''){
      this.emptyAddress = true;
    }else if(this.city == ''){
      this.emptyCity = true;
    }else if(this.country == ''){
      this.emptyCountry = true;
    }else if(this.phoneNumber == ''){
      this.emptyPhone = true;
    }else if(this.jmbg == ''){
      this.emptyJmbg = true;
    }else if(this.gender == ''){
      this.emptyGender = true;
    }else if(this.profession == ''){
      this.emptyProfession = true;
    }else if(this.info == ''){
      this.emptyInfo = true;
    }else if(this.password == ''){
      this.emptyPassword = true;
    }else if(this.confirmPassword == ''){
      this.emptyConfirmPassword = true;
    }else{
      console.log(this.name)
    }
    
    
  }

  checkName(){
    console.log(this.name)
    if(this.name == ''){
      this.emptyName = true;
    }else{
      this.emptyName = false;
    }
  }

  checkEmail(){
    console.log(this.email)
    if(this.email == ''){
      this.emptyEmail = true;
    }else{
      this.emptyEmail = false;
    }
  }

  checkSurname(){
    console.log(this.surname)
    if(this.surname == ''){
      this.emptySurname = true;
    }else{
      this.emptySurname = false;
    }
  }

  checkGender(){
    console.log(this.gender)
    if(this.gender == ''){
      this.emptyGender = true;
    }else{
      this.emptyGender = false;
    }
  }

  checkAddress(){
    console.log(this.address)
    if(this.address == ''){
      this.emptyAddress = true;
    }else{
      this.emptyAddress = false;
    }
  }

  checkCity(){
    console.log(this.city)
    if(this.city == ''){
      this.emptyCity = true;
    }else{
      this.emptyCity = false;
    }
  }

  checkCountry(){
    console.log(this.country)
    if(this.country == ''){
      this.emptyCountry = true;
    }else{
      this.emptyCountry = false;
    }
  }

  checkPhone(){
    console.log(this.phoneNumber)
    if(this.phoneNumber == ''){
      this.emptyPhone = true;
    }else{
      this.emptyPhone = false;
    }
  }


  checkProfession(){
    console.log(this.profession)
    if(this.profession == ''){
      this.emptyProfession = true;
    }else{
      this.emptyProfession = false;
    }
  }

  checkInfo(){
    console.log(this.info)
    if(this.info == ''){
      this.emptyInfo = true;
    }else{
      this.emptyInfo = false;
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

  checkConfirmPassword(){
    console.log(this.confirmPassword)
    if(this.confirmPassword == ''){
      this.emptyConfirmPassword = true;
    }else{
      this.emptyConfirmPassword = false;
    }
  }

  checkJmbg(){
    console.log(this.jmbg)
    if(this.jmbg == ''){
      this.emptyJmbg = true;
    }else{
      this.emptyJmbg = false;
    }
  }

  

  

}

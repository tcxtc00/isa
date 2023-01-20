import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

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
  passwordsNotMatches = false;

  constructor(private matSnackBar: MatSnackBar, private userService: UserService, private router: Router) { }

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
    }else if(!(this.password == this.confirmPassword)){
      this.passwordsNotMatches = true;
    }else{

      let data = {
        username: this.email,
        name: this.name,
        surname: this.surname,
        password: this.password,
        address: this.address,
        city: this.city,
        country: this.country,
        phoneNumber: this.phoneNumber,
        jmbg: this.jmbg,
        gender: this.gender,
        profession: this.profession,
        professionInfo: this.info
      }
      this.userService.register(data).subscribe((response: any) => {
        console.log(response);
        this.matSnackBar.open('Uspešno ste se registrovali. Poslali smo Vam aktivacioni link na e-mail.', 'Close', {duration: 4500})
        this.router.navigate(['/'])
      }, error => {
        this.matSnackBar.open('Registracija nije uspela! Pokušajte sa drugim e-mail-om.', 'Close', {duration: 5000})
      }
      )

    }
    
    
  }

  checkName(){
    if(this.name == ''){
      this.emptyName = true;
    }else{
      this.emptyName = false;
    }
  }

  checkEmail(){
    if(this.email == ''){
      this.emptyEmail = true;
    }else{
      this.emptyEmail = false;
    }
  }

  checkSurname(){
    if(this.surname == ''){
      this.emptySurname = true;
    }else{
      this.emptySurname = false;
    }
  }

  checkGender(){
    if(this.gender == ''){
      this.emptyGender = true;
    }else{
      this.emptyGender = false;
    }
  }

  checkAddress(){
    if(this.address == ''){
      this.emptyAddress = true;
    }else{
      this.emptyAddress = false;
    }
  }

  checkCity(){
    if(this.city == ''){
      this.emptyCity = true;
    }else{
      this.emptyCity = false;
    }
  }

  checkCountry(){
    if(this.country == ''){
      this.emptyCountry = true;
    }else{
      this.emptyCountry = false;
    }
  }

  checkPhone(){
    if(this.phoneNumber == ''){
      this.emptyPhone = true;
    }else{
      this.emptyPhone = false;
    }
  }


  checkProfession(){
    if(this.profession == ''){
      this.emptyProfession = true;
    }else{
      this.emptyProfession = false;
    }
  }

  checkInfo(){
    if(this.info == ''){
      this.emptyInfo = true;
    }else{
      this.emptyInfo = false;
    }
  }

  checkPassword(){
    if(this.password == ''){
      this.emptyPassword = true;
      if(this.password != this.confirmPassword){
        this.passwordsNotMatches = true;
      }else{
        this.passwordsNotMatches = false;
      }
    }else{
      this.emptyPassword = false;
      if(this.password != this.confirmPassword){
        this.passwordsNotMatches = true;
      }else{
        this.passwordsNotMatches = false;
      }
    }
  }

  checkConfirmPassword(){
    if(this.confirmPassword == ''){
      this.emptyConfirmPassword = true;
      if(this.confirmPassword != this.password){
        this.passwordsNotMatches = true;
      }else{
        this.passwordsNotMatches = false;
      }
    }else{
      this.emptyConfirmPassword = false;
      if(this.confirmPassword != this.password){
        this.passwordsNotMatches = true;
      }else{
        this.passwordsNotMatches = false;
      }
    }
  }

  checkJmbg(){
    if(this.jmbg == ''){
      this.emptyJmbg = true;
    }else{
      this.emptyJmbg = false;
    }
  }

}

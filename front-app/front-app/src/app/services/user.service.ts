import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = "http://localhost:8080/api/users/"

  getAuthoHeader() : any {
    const headers = {
      'Content-Type': 'application/json',
      'Authorization' : 'Bearer ' + localStorage.getItem("token")
    }
    return{
      headers: headers
    };
  }  

  constructor(private http: HttpClient) { }


  register(data: any){
    return this.http.post(this.baseUrl + "register", data);
  }

  login(data: any){
    return this.http.post(this.baseUrl + "login", data);
  }

  current(){
    console.log()
    return this.http.get(this.baseUrl + "current", this.getAuthoHeader())
  }
}

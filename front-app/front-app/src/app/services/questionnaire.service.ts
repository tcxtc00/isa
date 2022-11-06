import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuestionnaireService {

  private baseUrl = "http://localhost:8080/api/questionnaires/"


  getAuthoHeader() : any {
    const headers = {
      'Content-Type': 'application/json',
      'Authorization' : 'Bearer ' + localStorage.getItem("token")
    }
    return{
      headers: headers
    };
  }  

  constructor(private httpClient: HttpClient) { }


  createQuestionnaire(data: any){
    return this.httpClient.post(this.baseUrl + "create" , data, this.getAuthoHeader())
  }
}

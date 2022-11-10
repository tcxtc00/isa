import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BloodTransfusionCenterService {

  private baseUrl = "http://localhost:8080/api/centers/"

  constructor(private httpClient: HttpClient) { }

  getAuthoHeader() : any {
    const headers = {
      'Content-Type': 'application/json',
      'Authorization' : 'Bearer ' + localStorage.getItem("token")
    }
    return{
      headers: headers
    };
  }  

  getAll(){
    return this.httpClient.get(this.baseUrl + 'all');
  }

  sort(data: any){
    return this.httpClient.post(this.baseUrl + 'sort', data, this.getAuthoHeader())
  }

  getById(id: any){
    return this.httpClient.get(this.baseUrl + 'center/' + id,  this.getAuthoHeader())
  }

}

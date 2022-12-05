import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QrCodeService {


  private baseUrl = "http://localhost:8080/api/qrCodes/"

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


  userQRCodes(username: any){
    return this.httpClient.get(this.baseUrl + 'userQRCodes/' + username, this.getAuthoHeader())
  }

  sort(data: any) {
    return this.httpClient.post(this.baseUrl + 'sort', data, this.getAuthoHeader())
  }
}

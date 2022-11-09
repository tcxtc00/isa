import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuickAppointmentsService {

  private baseUrl = "http://localhost:8080/api/quickAppointments/"

  constructor(private httpClient: HttpClient) { }

  getAuthoHeader(): any {
    const headers = {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem("token")
    }
    return {
      headers: headers
    };
  }

  sort(data: any) {
    return this.httpClient.post(this.baseUrl + 'sort', data, this.getAuthoHeader())
  }

  book(data: any) {
    return this.httpClient.post(this.baseUrl + 'book', data, this.getAuthoHeader())
  }

}

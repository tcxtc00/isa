import { Component, OnInit } from '@angular/core';
import { QuickAppointmentsService } from '../services/quick-appointments.service';

@Component({
  selector: 'app-visiting-centers-history',
  templateUrl: './visiting-centers-history.component.html',
  styleUrls: ['./visiting-centers-history.component.css']
})
export class VisitingCentersHistoryComponent implements OnInit {

  quickAppointments: any[]
  convertedQuickAppointments: any[]
  username: any
  sortBy = ''
  sortType = ''
  constructor(private quickAppointmentsService: QuickAppointmentsService) { }

  ngOnInit(): void {
    let userStrng = localStorage.getItem('user');
    if (userStrng) {
      let user = JSON.parse(userStrng);
      this.username = user.username
      this.quickAppointmentsService.succeffullyCompleted(this.username).subscribe((response: any) => {
        this.quickAppointments = response;
        console.log(this.quickAppointments)
        this.corectQuickAppointments()
      })

    }
  }

  corectQuickAppointments() {

    this.convertedQuickAppointments = [];
    for (let a of this.quickAppointments) {
      let date = new Date(a.date[0], a.date[1] - 1, a.date[2], a.date[3], a.date[4]);
      let duration = a.duration;
      let centerName = a.centerName;
      let centerAddress = a.centerAddress;
      let centerCity = a.centerCity;

      let data = {
        date: date,
        duration: duration,
        centerName: centerName,
        centerAddress: centerAddress,
        centerCity: centerCity

      }
      this.convertedQuickAppointments.push(data);


    }
  }

  sortByChanged() {
    if (this.sortBy != '' && this.sortType != '') {
      let data = {
        sortBy: this.sortBy,
        sortType: this.sortType,
        username: this.username
      }
      this.quickAppointmentsService.sortSuccessfullyCompletedAppointments(data).subscribe((response: any) => {
        this.quickAppointments = response;
        this.corectQuickAppointments();
      })
    }

  }

  sortTypeChanged() {
    if (this.sortBy != '' && this.sortType != '') {
      let data = {
        sortBy: this.sortBy,
        sortType: this.sortType,
        username: this.username
      }
      this.quickAppointmentsService.sortSuccessfullyCompletedAppointments(data).subscribe((response: any) => {
        this.quickAppointments = response;
        this.corectQuickAppointments();
      })
    }
  }

}

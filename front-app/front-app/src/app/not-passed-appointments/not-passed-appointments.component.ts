import { Component, OnInit } from '@angular/core';
import { QuickAppointmentsService } from '../services/quick-appointments.service';

@Component({
  selector: 'app-not-passed-appointments',
  templateUrl: './not-passed-appointments.component.html',
  styleUrls: ['./not-passed-appointments.component.css']
})
export class NotPassedAppointmentsComponent implements OnInit {

  quickAppointments: any[]
  convertedQuickAppointments: any[]
  username: any
  constructor(private quickAppointmentsService: QuickAppointmentsService) { }

  ngOnInit(): void {
    let userStrng = localStorage.getItem('user');
    if (userStrng) {
      let user = JSON.parse(userStrng);
      this.username = user.username
      this.quickAppointmentsService.notPassed(this.username).subscribe((response: any) => {
        this.quickAppointments = response;
        this.corectQuickAppointments()
      })

    }
  }

  corectQuickAppointments() {

    this.convertedQuickAppointments = [];
    for (let a of this.quickAppointments) {
      let date = new Date(a.date[0], a.date[1] - 1, a.date[2], a.date[3], a.date[4]);
      let duration = a.duration;
      let id = a.id;
      let staffs = a.staffs;

      let data = {
        id: id,
        date: date,
        duration: duration,
        staffs: staffs
      }
      this.convertedQuickAppointments.push(data);


    }
  }

}

import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { BloodTransfusionCenterService } from '../services/blood-transfusion-center.service';
import { QuickAppointmentsService } from '../services/quick-appointments.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-center-info',
  templateUrl: './center-info.component.html',
  styleUrls: ['./center-info.component.css']
})
export class CenterInfoComponent implements OnInit {

  id: any
  center: any = {} as any
  appointments: any[]
  quickAppointments: any[]
  convertedQuickAppointments: any[]
  convertedAppointments: any[]
  sortBy = ''
  sortType = ''
  username: any
  user: any
  constructor(private matSnackBar: MatSnackBar, private userService: UserService, private activatedRoute: ActivatedRoute, private bloodTransfusionCenterService: BloodTransfusionCenterService, private quickAppointmentsService: QuickAppointmentsService) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id']
      console.log(this.id)
      let userStrng = localStorage.getItem('user');
      if (userStrng) {
        let user = JSON.parse(userStrng);
        this.username = user.username
        this.userService.current().subscribe((response: any) => {
          this.user = response;
        })

      }
      this.bloodTransfusionCenterService.getById(this.id).subscribe((response: any) => {
        this.center = response;
        this.appointments = this.center.appointments
        this.quickAppointments = this.center.quickAppointments
        this.corectQuickAppointments();
        this.corectAppointments();
      })
    })
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

  corectAppointments() {

    this.convertedAppointments = [];
    for (let a of this.appointments) {
      let startDate = new Date(a.startDate[0], a.startDate[1] - 1, a.startDate[2], a.startDate[3], a.startDate[4]);
      let duration = a.duration
      let id = a.id;

      let data = {
        id: id,
        startDate: startDate,
        duration: duration
      }
      this.convertedAppointments.push(data);


    }
  }

  sortByChanged() {
    if (this.sortBy != '' && this.sortType != '') {
      let data = {
        id: this.id,
        sortBy: this.sortBy,
        sortType: this.sortType
      }
      this.quickAppointmentsService.sort(data).subscribe((response: any) => {
        this.quickAppointments = response;
        this.corectQuickAppointments();
      })
    }

  }

  sortTypeChanged() {
    if (this.sortBy != '' && this.sortType != '') {
      let data = {
        id: this.id,
        sortBy: this.sortBy,
        sortType: this.sortType
      }
      this.quickAppointmentsService.sort(data).subscribe((response: any) => {
        this.quickAppointments = response;
        this.corectQuickAppointments();
      })
    }
  }

  book(id: any) {

    if (this.user.penalties >= 3) {
      this.matSnackBar.open('Imate tri penala i zbog toga ne možete da izvršite rezervaciju termina. Penali se brišu svakog prvog dana u mesecu.', 'Close', { duration: 6500 })
    } else if (!this.user.questionnaire) {
      this.matSnackBar.open('Niste popunili upitnik za davaoca krvi. Popunite upitnik pa potom rezervišite termin.', 'Close', { duration: 6500 })
    } else {
      let data = {
        id: id,
        username: this.username
      }
      this.quickAppointmentsService.book(data).subscribe((response: any) => {
        console.log(response)
        this.bloodTransfusionCenterService.getById(this.id).subscribe((response: any) => {
          this.center = response;
          this.appointments = this.center.appointments
          this.quickAppointments = this.center.quickAppointments
          this.corectQuickAppointments();
          this.corectAppointments();
        })
        this.matSnackBar.open('Uspešno ste rezervisali termin za davanje krvi.', 'Close', { duration: 3500 })
      }, error => {
        this.matSnackBar.open('Rezervacija termina za davanje krvi nije uspela. Proverite u istoriji poseta centrima da li ste u prethodnih 6 meseci već davali krv. Ukoliko niste, razlog neuspešne rezervacije je nemogućnost da zakažete termin u istom centru u isto vreme.', 'Close', { duration: 15000 })
      })

    }
  }


}

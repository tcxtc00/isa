import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BloodTransfusionCenterService } from '../services/blood-transfusion-center.service';
import { QuickAppointmentsService } from '../services/quick-appointments.service';

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
  constructor(private activatedRoute: ActivatedRoute, private bloodTransfusionCenterService: BloodTransfusionCenterService, private quickAppointmentsService: QuickAppointmentsService) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id']
      console.log(this.id)
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

  sortByChanged(){
    if(this.sortBy != '' && this.sortType != ''){
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

  sortTypeChanged(){
    if(this.sortBy != '' && this.sortType != ''){
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


}

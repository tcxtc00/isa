import { Component, OnInit } from '@angular/core';
import { BloodTransfusionCenterService } from '../services/blood-transfusion-center.service';

@Component({
  selector: 'app-blood-transfusion-center',
  templateUrl: './blood-transfusion-center.component.html',
  styleUrls: ['./blood-transfusion-center.component.css']
})
export class BloodTransfusionCenterComponent implements OnInit {

  constructor(private bloodTransfusionCenterService: BloodTransfusionCenterService) { }

  centers: any[]
  sortBy = ''
  sortType = ''
  user: any
  role: any

  ngOnInit(): void {
    this.bloodTransfusionCenterService.getAll().subscribe((response: any) => {
      this.centers = response;
      let userStrng = localStorage.getItem('user');
      if(userStrng) {
      this.user = JSON.parse(userStrng);
      this.role = this.user.userType

    }
    })
  }

  sortByChanged(){
    if(this.sortBy != '' && this.sortType != ''){
      let data = {
        sortBy: this.sortBy,
        sortType: this.sortType
      }
      this.bloodTransfusionCenterService.sort(data).subscribe((response: any) => {
        this.centers = response;
      })
    }
    
  }

  sortTypeChanged(){
    if(this.sortBy != '' && this.sortType != ''){
      let data = {
        sortBy: this.sortBy,
        sortType: this.sortType
      }
      this.bloodTransfusionCenterService.sort(data).subscribe((response: any) => {
        this.centers = response;
      })
    }
  }


}

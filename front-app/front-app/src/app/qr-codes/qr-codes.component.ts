import { Component, OnInit } from '@angular/core';
import { QrCodeService } from '../services/qr-code.service';

@Component({
  selector: 'app-qr-codes',
  templateUrl: './qr-codes.component.html',
  styleUrls: ['./qr-codes.component.css']
})
export class QrCodesComponent implements OnInit {

  qrCodes: any[]
  convertedQRCodes: any[]
  username: any
  sortBy = ''
  filter = ''
  constructor(private qrCodeService: QrCodeService) { }

  ngOnInit(): void {
    let userStrng = localStorage.getItem('user');
    if (userStrng) {
      let user = JSON.parse(userStrng);
      this.username = user.username
      this.qrCodeService.userQRCodes(this.username).subscribe((response: any) => {
        this.qrCodes = response;
        console.log(this.qrCodes)
        this.corectQRCodes()
      })

    }
  }

  corectQRCodes() {

    this.convertedQRCodes = [];
    for (let qr of this.qrCodes) {
      let date = new Date(qr.date[0], qr.date[1] - 1, qr.date[2], qr.date[3], qr.date[4]);
      let base64Data = qr.data;
      let retrievedImage = 'data:image/jpeg;base64,' + base64Data;
      let status = qr.appointment.status;
      if(status == 'Booked'){
        status = "Nov"
      }else if(status == 'SuccessFinished'){
        status = 'Obrađen'
      }else if(status == 'NotSatisfiedConditions'){
        status = 'Odbijen'
      }

      let qrCode = {
        retrievedImage: retrievedImage,
        status: status,
        date: date
      }
      this.convertedQRCodes.push(qrCode);


    }
  }

  sortByChanged() {
    if (this.sortBy != '') {
      let data = {
        sortBy: this.sortBy,
        username: this.username,
        filter: this.filter
      }
      this.qrCodeService.sort(data).subscribe((response: any) => {
        this.qrCodes = response;
        this.corectQRCodes();
      })
    }

  }

  filterChanged() {
    if (this.filter != '') {
      let data = {
        sortBy: this.sortBy,
        username: this.username,
        filter: this.filter
      }
      this.qrCodeService.sort(data).subscribe((response: any) => {
        this.qrCodes = response;
        this.corectQRCodes();
      })
    }
  }

}

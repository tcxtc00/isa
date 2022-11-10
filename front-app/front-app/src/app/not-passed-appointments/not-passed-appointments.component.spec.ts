import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotPassedAppointmentsComponent } from './not-passed-appointments.component';

describe('NotPassedAppointmentsComponent', () => {
  let component: NotPassedAppointmentsComponent;
  let fixture: ComponentFixture<NotPassedAppointmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotPassedAppointmentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NotPassedAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

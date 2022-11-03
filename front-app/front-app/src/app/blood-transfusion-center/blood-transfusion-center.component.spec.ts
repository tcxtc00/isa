import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodTransfusionCenterComponent } from './blood-transfusion-center.component';

describe('BloodTransfusionCenterComponent', () => {
  let component: BloodTransfusionCenterComponent;
  let fixture: ComponentFixture<BloodTransfusionCenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloodTransfusionCenterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BloodTransfusionCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { BloodTransfusionCenterService } from './blood-transfusion-center.service';

describe('BloodTransfusionCenterService', () => {
  let service: BloodTransfusionCenterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BloodTransfusionCenterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

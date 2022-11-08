import { TestBed } from '@angular/core/testing';

import { QuickAppointmentsService } from './quick-appointments.service';

describe('QuickAppointmentsService', () => {
  let service: QuickAppointmentsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QuickAppointmentsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

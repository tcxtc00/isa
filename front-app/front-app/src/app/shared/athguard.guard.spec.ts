import { TestBed } from '@angular/core/testing';

import { AthguardGuard } from './athguard.guard';

describe('AthguardGuard', () => {
  let guard: AthguardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AthguardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});

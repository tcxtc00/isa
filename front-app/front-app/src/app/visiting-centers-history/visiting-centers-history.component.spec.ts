import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitingCentersHistoryComponent } from './visiting-centers-history.component';

describe('VisitingCentersHistoryComponent', () => {
  let component: VisitingCentersHistoryComponent;
  let fixture: ComponentFixture<VisitingCentersHistoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VisitingCentersHistoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VisitingCentersHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

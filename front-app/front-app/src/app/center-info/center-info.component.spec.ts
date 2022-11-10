import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterInfoComponent } from './center-info.component';

describe('CenterInfoComponent', () => {
  let component: CenterInfoComponent;
  let fixture: ComponentFixture<CenterInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CenterInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CenterInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

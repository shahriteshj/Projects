import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpServiceComponent } from './emp-service.component';

describe('HttpServiceComponent', () => {
  let component: EmpServiceComponent;
  let fixture: ComponentFixture<EmpServiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpServiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

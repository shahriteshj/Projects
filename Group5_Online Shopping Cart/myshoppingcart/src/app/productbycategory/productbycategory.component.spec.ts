import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductbycategoryComponent } from './productbycategory.component';

describe('ProductbycategoryComponent', () => {
  let component: ProductbycategoryComponent;
  let fixture: ComponentFixture<ProductbycategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductbycategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductbycategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

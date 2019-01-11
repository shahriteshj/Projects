import { TestBed } from '@angular/core/testing';

import { ProductlistServiceService } from './productlist-service.service';

describe('ProductlistServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProductlistServiceService = TestBed.get(ProductlistServiceService);
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { ContactTypesService } from './contact-types.service';

describe('ContactTypesService', () => {
  let service: ContactTypesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContactTypesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

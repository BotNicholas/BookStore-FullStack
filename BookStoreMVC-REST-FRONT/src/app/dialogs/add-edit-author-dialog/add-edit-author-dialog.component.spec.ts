import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditAuthorDialogComponent } from './add-edit-author-dialog.component';

describe('AddEditAuthorDialogComponent', () => {
  let component: AddEditAuthorDialogComponent;
  let fixture: ComponentFixture<AddEditAuthorDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddEditAuthorDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddEditAuthorDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

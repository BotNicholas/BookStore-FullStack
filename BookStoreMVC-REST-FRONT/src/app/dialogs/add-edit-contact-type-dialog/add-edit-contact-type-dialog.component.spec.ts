import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditContactTypeDialogComponent } from './add-edit-contact-type-dialog.component';

describe('AddEditContactTypeDialogComponent', () => {
  let component: AddEditContactTypeDialogComponent;
  let fixture: ComponentFixture<AddEditContactTypeDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddEditContactTypeDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddEditContactTypeDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

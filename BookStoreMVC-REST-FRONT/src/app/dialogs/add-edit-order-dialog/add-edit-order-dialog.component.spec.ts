import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditOrderDialogComponent } from './add-edit-order-dialog.component';

describe('AddEditOrderDialogComponent', () => {
  let component: AddEditOrderDialogComponent;
  let fixture: ComponentFixture<AddEditOrderDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddEditOrderDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddEditOrderDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

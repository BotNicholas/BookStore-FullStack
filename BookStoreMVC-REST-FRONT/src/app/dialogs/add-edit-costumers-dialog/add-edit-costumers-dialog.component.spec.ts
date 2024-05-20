import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditCostumersDialogComponent } from './add-edit-costumers-dialog.component';

describe('AddEditCostumersDialogComponent', () => {
  let component: AddEditCostumersDialogComponent;
  let fixture: ComponentFixture<AddEditCostumersDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddEditCostumersDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddEditCostumersDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

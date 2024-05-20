import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditOrderItemDialogComponent } from './edit-order-item-dialog.component';

describe('EditOrderItemDoaligComponent', () => {
  let component: EditOrderItemDialogComponent;
  let fixture: ComponentFixture<EditOrderItemDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditOrderItemDialogComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditOrderItemDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

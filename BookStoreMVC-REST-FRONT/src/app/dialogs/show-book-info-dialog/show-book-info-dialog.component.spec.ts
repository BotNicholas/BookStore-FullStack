import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowBookInfoDialogComponent } from './show-book-info-dialog.component';

describe('ShowBookInfoDialogComponent', () => {
  let component: ShowBookInfoDialogComponent;
  let fixture: ComponentFixture<ShowBookInfoDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShowBookInfoDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowBookInfoDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

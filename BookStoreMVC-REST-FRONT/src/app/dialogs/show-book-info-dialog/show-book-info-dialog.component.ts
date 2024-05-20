import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogActions, MatDialogRef, MatDialogTitle} from "@angular/material/dialog";
import {Book} from "../../models/Book";
import {booksImagesPath, url} from "../../constants/constants";
import {RouterLink} from "@angular/router";
import {DatePipe} from "@angular/common";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-show-book-info-dialog',
  standalone: true,
  imports: [
    MatDialogTitle,
    RouterLink,
    DatePipe,
    MatDialogActions,
    MatButton
  ],
  templateUrl: './show-book-info-dialog.component.html',
  styleUrl: './show-book-info-dialog.component.css'
})
export class ShowBookInfoDialogComponent {
  constructor(private dialogRef: MatDialogRef<ShowBookInfoDialogComponent>, @Inject(MAT_DIALOG_DATA) public book: Book, private dialog: MatDialog) {
  }

  close(){
    this.dialogRef.close();
  }

  closeAll(){
    this.dialog.closeAll();
  }

  protected readonly url = url;
  protected readonly booksImagesPath = booksImagesPath;
}

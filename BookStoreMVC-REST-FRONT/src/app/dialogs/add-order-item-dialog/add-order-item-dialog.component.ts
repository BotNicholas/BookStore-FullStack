import {Component, Inject} from '@angular/core';
import {Order} from "../../models/Order";
import {Costumer} from "../../models/Costumer";
import {
  MAT_DIALOG_DATA, MatDialog,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {CostumersService} from "../../services/costumers/costumers.service";
import {FormsModule} from "@angular/forms";
import {MatDatepicker} from "@angular/material/datepicker";
import {MatFormField, MatInput, MatLabel} from "@angular/material/input";
import {MatOption, MatSelect} from "@angular/material/select";
import {MatError} from "@angular/material/form-field";
import {HttpClientModule} from "@angular/common/http";
import {MatButton} from "@angular/material/button";
import {BooksService} from "../../services/books/books.service";
import {Book} from "../../models/Book";
import {booksImagesPath, url} from "../../constants/constants";
import {NgClass} from "@angular/common";
import {AddEditBookDialogComponent} from "../add-edit-book-dialog/add-edit-book-dialog.component";
import {ShowBookInfoDialogComponent} from "../show-book-info-dialog/show-book-info-dialog.component";

@Component({
  selector: 'app-add-edit-order-item-dialog',
  standalone: true,
  imports: [
    FormsModule,
    MatDialogTitle,
    MatDialogContent,
    MatDatepicker,
    MatInput,
    MatLabel,
    MatFormField,
    MatSelect,
    MatError,
    MatOption,
    HttpClientModule,
    MatDialogActions,
    MatButton,
    NgClass
  ],
  templateUrl: './add-order-item-dialog.component.html',
  styleUrl: './add-order-item-dialog.component.css',
  providers: [BooksService]
})
export class AddOrderItemDialogComponent {
  allBooks: any[] = [];
  selectedBooks: Map<Book, number> = new Map<Book, number>();
  selected: boolean = false;

  constructor(private dialogRef: MatDialogRef<AddOrderItemDialogComponent>, private booksService: BooksService, private dialog: MatDialog) {
  }

  ngOnInit() {
    this.booksService.getAll().subscribe((books:any) => {
      for (let book of books) {
        this.allBooks.push([book, false, 0]);
      }
    });
  }

  close(){
    this.dialogRef.close();
  }

  save(){
    this.dialogRef.close(this.selectedBooks);
  }

  selectBook(book: any[]){
    if (book[1]) {
      this.selectedBooks.delete(book[0]);
      book[1] = false;
    } else {
      this.selectedBooks.set(book[0], 1);
      book[1] = true;
    }
    this.selected = this.selectedBooks.size > 0;
  }

  setAmount(event:any, book:Book){
    this.selectedBooks.set(book, event.target.value);
  }

  showInfo(book: Book) {
    const dialogRef = this.dialog.open(ShowBookInfoDialogComponent, {data: book});
  }

  protected readonly url = url;
  protected readonly booksImagesPath = booksImagesPath;
  protected readonly console = console;
}

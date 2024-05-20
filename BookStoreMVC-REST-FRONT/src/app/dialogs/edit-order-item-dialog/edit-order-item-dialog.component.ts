import {Component, Inject, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {MatButton} from "@angular/material/button";
import {FullOrderItem} from "../../models/FullOrderItem";
import {OrderItem} from "../../models/OrderItem";
import {HttpClientModule} from "@angular/common/http";
import {OrderItemsService} from "../../services/order-items/order-items.service";
import {BooksService} from "../../services/books/books.service";
import {Book} from "../../models/Book";
import {MatError, MatFormField, MatLabel} from "@angular/material/form-field";
import {MatOption, MatSelect} from "@angular/material/select";
import {booksImagesPath, url} from "../../constants/constants";
import {MatInput} from "@angular/material/input";
import {CdkTextareaAutosize} from "@angular/cdk/text-field";
import {NotMoreThanDirective} from "../../directives/not-more-than.directive";

@Component({
  selector: 'app-edit-order-item-dialog',
  standalone: true,
  imports: [
    HttpClientModule,
    FormsModule,
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatButton,
    MatFormField,
    MatSelect,
    MatLabel,
    MatError,
    MatOption,
    MatInput,
    CdkTextareaAutosize,
    NotMoreThanDirective
  ],
  templateUrl: './edit-order-item-dialog.component.html',
  styleUrl: './edit-order-item-dialog.component.css',
  providers: [BooksService]
})
export class EditOrderItemDialogComponent implements OnInit{
  orderItem: FullOrderItem = new FullOrderItem(0, 0, "", null, 0, null);
  orderItemAmount: number = 0;
  allBooks: Book[] = [];
  constructor(private dialogRef: MatDialogRef<EditOrderItemDialogComponent>, @Inject(MAT_DIALOG_DATA) public oldOrderItem: FullOrderItem, private booksService: BooksService) {
    this.copyOrderItems(this.orderItem, oldOrderItem);
    this.orderItemAmount = oldOrderItem.amount;
  }

  ngOnInit() {
    this.booksService.getAll().subscribe((result:any)=> {
      this.allBooks = result;
    });
  }

  copyOrderItems(orderItem1: FullOrderItem, orderItem2: FullOrderItem) {
    orderItem1.id = orderItem2.id;
    orderItem1.itemAgreedPrice = orderItem2.itemAgreedPrice;
    orderItem1.itemComment = orderItem2.itemComment;
    orderItem1.book = orderItem2.book;
    orderItem1.amount = orderItem2.amount;
    orderItem1.order = orderItem2.order;
  }

  compareBooks(book1: Book, book2: Book) {
    return book1.id == book2.id;
  }

  close() {
    this.dialogRef.close();
  }
  save(){
    this.dialogRef.close(this.orderItem);
  }

  protected readonly url = url;
  protected readonly booksImagesPath = booksImagesPath;
}

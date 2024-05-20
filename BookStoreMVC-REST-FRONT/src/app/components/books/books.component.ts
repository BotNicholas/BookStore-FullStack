import {Component, OnInit} from '@angular/core';
import {Book} from "../../models/Book";
import {HttpClientModule} from "@angular/common/http";
import {BooksService} from "../../services/books/books.service";
import {ActivatedRoute, RouterLink} from "@angular/router";
import {Observable} from "rxjs";
import {booksImagesPath, url} from "../../constants/constants";
import {style} from "@angular/animations";
import {CurrencyPipe} from "@angular/common";
import {MatDialog} from "@angular/material/dialog";
import {AddEditBookDialogComponent} from "../../dialogs/add-edit-book-dialog/add-edit-book-dialog.component";
import {DeleteConfirmationComponent} from "../../dialogs/delete-confirmation/delete-confirmation.component";

@Component({
  selector: 'app-books',
  standalone: true,
  imports: [HttpClientModule, RouterLink, CurrencyPipe],
  templateUrl: './books.component.html',
  styleUrl: './books.component.css',
  providers: [BooksService]
})
export class BooksComponent implements OnInit{
  books: Book[] = [];
  constructor(private service: BooksService, private activatedRoute: ActivatedRoute, private dialog: MatDialog) {}

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe((params:any)=>{
      let books: Observable<Object>;
      if (params.filter) {
        books = this.service.getFiltered(params.filter);
      } else {
        books = this.service.getAll();
      }
      books.subscribe((data:any)=>this.books = data);
    });

  }

  addNewBook(){
    const dialogRef = this.dialog.open(AddEditBookDialogComponent, {autoFocus: false});

    dialogRef.afterClosed().subscribe((body:any)=>{
      if(body) {
        this.service.save(body).subscribe((response:any) => {
          this.books.push(response);
        });
      }
    });
  }

  editBook(book: Book) {
    const dialogRef = this.dialog.open(AddEditBookDialogComponent, {autoFocus: false, data: book});

    dialogRef.afterClosed().subscribe((body: any)=> {
      // console.log(body);
      if(body) {
        this.service.update(book.id, body).subscribe((response:any)=>{
          let bookIndex: number = this.books.indexOf(book);
          this.books[bookIndex] = response;
        });
      }
    })
  }

  deleteBook(book: Book) {
    const dialogRef = this.dialog.open(DeleteConfirmationComponent, {autoFocus: false, data: {target: 'Book', object: book}});

    dialogRef.afterClosed().subscribe((result:any)=>{
      if(result === "Yes"){
        this.service.delete(book.id).subscribe((response:any)=>{
          if (response.status == 204){
            this.books.splice(this.books.indexOf(book), 1);
          }
        })
      }
    })
  }

  protected readonly url = url;
  protected readonly booksImagesPath = booksImagesPath;
  protected readonly alert = alert;
}

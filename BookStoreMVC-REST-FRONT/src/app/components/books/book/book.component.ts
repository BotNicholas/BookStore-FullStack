import {Component, OnInit} from '@angular/core';
import {booksImagesPath, url} from "../../../constants/constants";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {BooksService} from "../../../services/books/books.service";
import {Book} from "../../../models/Book";
import {CurrencyPipe} from "@angular/common";
import {MatDialog} from "@angular/material/dialog";
import {AddEditAuthorDialogComponent} from "../../../dialogs/add-edit-author-dialog/add-edit-author-dialog.component";
import {AddEditBookDialogComponent} from "../../../dialogs/add-edit-book-dialog/add-edit-book-dialog.component";

@Component({
  selector: 'app-book',
  standalone: true,
  imports: [RouterLink, HttpClientModule, CurrencyPipe],
  templateUrl: './book.component.html',
  styleUrl: './book.component.css',
  providers: [BooksService]
})
export class BookComponent implements OnInit{
  book: Book|undefined;
  private currentBookId: number = 0;
  constructor(private service: BooksService, private activatedRoute: ActivatedRoute, private dialog: MatDialog, private router: Router) {
    activatedRoute.params.subscribe((params:any)=>this.currentBookId = params.id);
  }

  ngOnInit(): void {
    this.service.getById(this.currentBookId).subscribe((data:any)=>this.book = data);
  }

  editBook(){
    const dialogRef = this.dialog.open(AddEditAuthorDialogComponent, {autoFocus: false, data: this.book});

    dialogRef.afterClosed().subscribe((body:any) => {
      if(body) {
        this.service.update(this.book?.id as any, body).subscribe((response:any)=>{
          this.book = response;
        });
      }
    });
  }

  deleteBook(){
    const dialogRef = this.dialog.open(AddEditBookDialogComponent, {autoFocus: false, data: {target: 'Book', object: this.book}});

    dialogRef.afterClosed().subscribe(value => (response:any)=>{
      if(response == "Yes") {
        this.service.delete(this.book?.id as any).subscribe((result:any)=>{
          if(result.status == 204) {
            this.router.navigate(["/books"]);
          }
        });
      }
    });
  }

  protected readonly url = url;
  protected readonly booksImagesPath = booksImagesPath;
}

import {Component, Inject, OnInit} from '@angular/core';
import {Book} from "../../models/Book";
import {authorsImagesPath, defaultMaxUploadFileSize, url} from "../../constants/constants";
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {AuthorsService} from "../../services/authors/authors.service";
import {CategoryService} from "../../services/categories/category.service";
import {FormsModule, NgModel} from "@angular/forms";
import {MatError, MatFormField, MatLabel} from "@angular/material/form-field";
import {MatOption, MatSelect} from "@angular/material/select";
import {Author} from "../../models/Author";
import {Category} from "../../models/Category";
import {HttpClientModule} from "@angular/common/http";
import {MatInput} from "@angular/material/input";
import {MatButton} from "@angular/material/button";
import {CdkTextareaAutosize} from "@angular/cdk/text-field";

@Component({
  selector: 'app-add-edit-book-dialog',
  standalone: true,
  imports: [
    HttpClientModule,
    FormsModule,
    MatDialogTitle,
    MatDialogContent,
    MatFormField,
    MatLabel,
    MatSelect,
    MatError,
    MatOption,
    MatInput,
    MatDialogActions,
    MatButton,
    CdkTextareaAutosize
  ],
  templateUrl: './add-edit-book-dialog.component.html',
  styleUrl: './add-edit-book-dialog.component.css',
  providers: [AuthorsService, CategoryService]
})
export class AddEditBookDialogComponent implements OnInit{
  maxUploadFileSize: number = defaultMaxUploadFileSize;
  heading: string = "Add new";
  book: Book = new Book(0, null, null, "", new Date(), new Date(), "", 0, "", "Placeholder.png");
  allAuthors: Author[] = [];
  allCategories: Category[] = [];
  file: File | null = null;
  uploadedFileSize: number = 0;

  constructor(private dialogRef: MatDialogRef<AddEditBookDialogComponent>, @Inject(MAT_DIALOG_DATA) private oldBook: Book, private authorService: AuthorsService, private categoryService: CategoryService) {
    if (oldBook) {
      this.heading = "Edit";
      this.copyBook(this.book, oldBook);
    }
  }

  ngOnInit() {
    this.authorService.getAll().subscribe((data: any)=>this.allAuthors = data);
    this.categoryService.getAll().subscribe((data: any)=>this.allCategories = data);
  }

  copyBook(book: Book, oldBook: Book){
    book.id = oldBook.id;
    book.author = oldBook.author;
    book.category = oldBook.category;
    book.isbn = oldBook.isbn;
    book.publicationDate = oldBook.publicationDate;
    book.dateAcquired = oldBook.dateAcquired;
    book.title = oldBook.title;
    book.recommendedPrice = oldBook.recommendedPrice;
    book.comments = oldBook.comments;
    book.image = oldBook.image;
  }

  onFileUploaded(event: any, model: NgModel) {
    // console.log(model);
    //todo: create method save -> check how it works (returned object from dialog), realize Books saving on back
    if(event.target.files[0]){
      this.uploadedFileSize = event.target.files[0].size;
      if(this.uploadedFileSize > this.maxUploadFileSize){
        model.control.setErrors({"fileSize": true});
      } else {
        this.file = event.target.files[0];
      }

    }
  }

  close(){
    this.dialogRef.close();
  }

  save(){
    const formData: FormData = new FormData();

    if(this.file) {
      formData.append("photo", this.file);
      this.book.image = this.file.name;
    }

    formData.append("book", JSON.stringify(this.book));

    this.dialogRef.close(formData);
  }

  compareAuthors(author1: Author, author2: Author){
    return author1.id === author2.id;
  }

  compareCategories(category1: Category, category2: Category){
    return category1.code === category2.code;
  }

  // selectChange(event: any) {
  //   console.log(event);
  //   // here we can get id and select needed author from authors list like this. This can be used for simple html select, but wI use mat select thus i will use compareWith method
  //   console.log(this.book);
  //   this.book.author = this.allAuthors.find(a => a.id === event.value) as any;
  //   console.log(this.book);
  // }


  protected readonly url = url;
  protected readonly authorsImagesPath = authorsImagesPath;
  protected readonly console = console
}

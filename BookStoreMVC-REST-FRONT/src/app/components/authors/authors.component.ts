import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {AuthorsService} from "../../services/authors/authors.service";
import {Author} from "../../models/Author";
import {authorsImagesPath, url} from "../../constants/constants";
import {ActivatedRoute, RouterLink} from "@angular/router";
import {Observable} from "rxjs";
import {AddEditAuthorDialogComponent} from "../../dialogs/add-edit-author-dialog/add-edit-author-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {DeleteConfirmationComponent} from "../../dialogs/delete-confirmation/delete-confirmation.component";

@Component({
  selector: 'app-authors',
  standalone: true,
  imports: [HttpClientModule, RouterLink],
  templateUrl: './authors.component.html',
  styleUrl: './authors.component.css',
  providers: [AuthorsService]
})
export class AuthorsComponent implements OnInit{
  authors: Author[] = [];
  constructor(private service: AuthorsService, private activatedRoute: ActivatedRoute, private dialog: MatDialog) {}
  ngOnInit() {
    this.activatedRoute.queryParams.subscribe((params:any)=>{
      let authors: Observable<Object>;
      if (params.filter) {
        authors = this.service.getFiltered(params.filter);
      } else {
        authors = this.service.getAll();
      }

      authors.subscribe((data:any)=>this.authors = data);
    });
    // this.service.getAll().subscribe((data:any)=>{
    //   this.authors = data;
    //   // console.log(this.authors);
    // });
  }

  // showTouchedAuthor(author: Author) {
  //   alert(`${author.id} ${author.firstname} ${author.lastname} ${author.initials} ${author.birthDate} ${author.gender} ${author.contactDetails} ${author.otherDetails} ${author.books} `);
  // }


  addAuthor(){
    // this.dialog.open(AddEditAuthorDialogComponent, {data: {name: "aaa", animal: "aaaaaaaaa"}, hasBackdrop: true})
    // this.dialog.open(AddEditAuthorDialogComponent, {data:this.authors[0], autoFocus:false})
    const dialogRef = this.dialog.open(AddEditAuthorDialogComponent, {autoFocus: false});

    // dialogRef.afterClosed().subscribe((body:any)=>console.log(body));
    dialogRef.afterClosed().subscribe((body:any)=>{
      if (body) {
        this.service.save(body).subscribe((response: any) => {
          this.authors.push(response);
        });
      }
    });
  }

  editAuthor(author: Author){
    const dialogRef = this.dialog.open(AddEditAuthorDialogComponent, {autoFocus: false, data: author});
    dialogRef.afterClosed().subscribe((body:any)=>{
      if (body) {
        this.service.update(author.id, body).subscribe((response: any)=>{
          let authorIndex: number = this.authors.indexOf(author);
          author = response;
          this.authors[authorIndex] = author;
        });
      }
    });
  }

  deleteAuthor(author: Author){
    const dialogRef = this.dialog.open(DeleteConfirmationComponent, {autoFocus:false, data: {target: 'Author', object: author}});

    dialogRef.afterClosed().subscribe((response:string)=>{
      if (response == "Yes") {
        this.service.delete(author.id).subscribe((response: any)=>{
          // console.log(response);
          if (response.status == 204) {
            // console.log(this.authors.indexOf(author));
            this.authors.splice(this.authors.indexOf(author), 1);
          }
        });
      }
    });
  }

  protected readonly url = url;
  protected readonly authorsImagesPath = authorsImagesPath;
}

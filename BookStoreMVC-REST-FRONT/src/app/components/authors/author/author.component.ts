import {Component, OnInit} from '@angular/core';
import {Author} from "../../../models/Author";
import {HttpClientModule} from "@angular/common/http";
import {AuthorsService} from "../../../services/authors/authors.service";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {authorsImagesPath, url} from "../../../constants/constants";
import {AddEditAuthorDialogComponent} from "../../../dialogs/add-edit-author-dialog/add-edit-author-dialog.component";
import {DeleteConfirmationComponent} from "../../../dialogs/delete-confirmation/delete-confirmation.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-author',
  standalone: true,
  imports: [HttpClientModule, RouterLink],
  templateUrl: './author.component.html',
  styleUrl: './author.component.css',
  providers: [AuthorsService]
})
export class AuthorComponent implements OnInit{
  author: Author|undefined;
  authorBooks: number = 0;
  private currentAuthorId: number = 0;
  constructor(private service: AuthorsService, private activatedRoute: ActivatedRoute, private dialog: MatDialog, private router: Router) {
    activatedRoute.params.subscribe((data:any)=>this.currentAuthorId = data.id);
  }

  ngOnInit() {
    // console.log(this.currentAuthorId);
    this.service.getById(this.currentAuthorId).subscribe((data:any)=>{
      this.author = data;
      this.authorBooks = this.author?.books.length as any;
    });
  }

  editAuthor(){
    const dialogRef = this.dialog.open(AddEditAuthorDialogComponent, {autoFocus: false, data: this.author});
    dialogRef.afterClosed().subscribe((body:any)=>{
      if (body) {
        this.service.update(this.author?.id as any, body).subscribe((response: any)=>{
          this.author = response;
        });
      }
    });
  }

  deleteAuthor(){
    const dialogRef = this.dialog.open(DeleteConfirmationComponent, {autoFocus:false, data: {target: 'Author', object: this.author}});

    dialogRef.afterClosed().subscribe((response:string)=>{
      if (response == "Yes") {
        this.service.delete(this.author?.id as any).subscribe((response: any)=>{
          if (response.status == 204) {
            this.router.navigate(["/authors"]);
          }
        });
      }
    });
  }

  protected readonly url = url;
  protected readonly authorsImagesPath = authorsImagesPath;
}

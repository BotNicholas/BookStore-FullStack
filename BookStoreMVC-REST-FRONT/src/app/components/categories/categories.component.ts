import {Component, OnInit} from '@angular/core';
import {Category} from "../../models/Category";
import {HttpClientModule} from "@angular/common/http";
import {CategoryService} from "../../services/categories/category.service";
import {RouterLink} from "@angular/router";
import {Author} from "../../models/Author";
import {MatDialog} from "@angular/material/dialog";
import {
  AddEditCategoryDialogComponent
} from "../../dialogs/add-edit-category-dialog/add-edit-category-dialog.component";
import {DeleteConfirmationComponent} from "../../dialogs/delete-confirmation/delete-confirmation.component";

@Component({
  selector: 'app-categories',
  standalone: true,
  imports: [HttpClientModule, RouterLink],
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.css',
  providers: [CategoryService]
})
export class CategoriesComponent implements OnInit{
  categories: Category[] = [];

  constructor(private service: CategoryService, private dialog: MatDialog) {}

  ngOnInit() {
    this.service.getAll().subscribe((data:any)=>this.categories = data);
  }

  addNewCategory() {
    const dialogRef = this.dialog.open(AddEditCategoryDialogComponent, {autoFocus: false});

    dialogRef.afterClosed().subscribe((data: any) => {
      if (data) {
        this.service.save(data).subscribe((response:any) => {
          this.categories.push(response);
        });
      }
    })
  }

  editCategory(category: Category){
    const dialogRef = this.dialog.open(AddEditCategoryDialogComponent, {autoFocus: false, data: category});

    dialogRef.afterClosed().subscribe((data: any) => {
      if (data) {
        this.service.update(category.code, data).subscribe((response:any) => {
          let categoryIndex: number = this.categories.indexOf(category);
          this.categories[categoryIndex] = response;
        });
      }
    });
  }

  deleteCategory(category: Category){
    const dialogRef = this.dialog.open(DeleteConfirmationComponent, {autoFocus: false, data: {target: 'Category', object: category}});
    dialogRef.afterClosed().subscribe((result: any) => {
      if(result == "Yes") {
        this.service.delete(category.code).subscribe((result: any)=>{
          // console.log(result);
          if (result.status == 204) {
            // console.log(this.categories.indexOf(category));
            this.categories.splice(this.categories.indexOf(category), 1);
          }
        });
      }
    })
  }
}

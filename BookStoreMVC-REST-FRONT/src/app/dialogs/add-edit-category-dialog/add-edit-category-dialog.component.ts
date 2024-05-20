import {Component, Inject} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {Category} from "../../models/Category";
import {MatError, MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-add-edit-category-dialog',
  standalone: true,
  imports: [
    FormsModule,
    MatDialogTitle,
    MatDialogContent,
    MatLabel,
    MatInput,
    MatFormField,
    MatError,
    MatDialogActions,
    MatButton
  ],
  templateUrl: './add-edit-category-dialog.component.html',
  styleUrl: './add-edit-category-dialog.component.css'
})
export class AddEditCategoryDialogComponent {
  heading: string = "Add new";
  category: Category = new Category(0, "");

  constructor(private dialogRef: MatDialogRef<AddEditCategoryDialogComponent>, @Inject(MAT_DIALOG_DATA) public oldCategory: Category) {
    if (oldCategory) {
      this.heading = "Edit";
      this.copyCategory(this.category, oldCategory);
    }
  }

  copyCategory(category: Category, oldCategory: Category){
    category.code = oldCategory.code;
    category.categoryDescription = oldCategory.categoryDescription;
  }

  cancel(){
    this.dialogRef.close();
  }

  save() {
    this.dialogRef.close(this.category);
  }
}

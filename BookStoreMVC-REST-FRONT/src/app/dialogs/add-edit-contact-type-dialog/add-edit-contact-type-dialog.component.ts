import {Component, Inject} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {ContactType} from "../../models/ContactType";
import {MatError, MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-add-edit-contact-type-dialog',
  standalone: true,
  imports: [
    FormsModule,
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatFormField,
    MatInput,
    MatError,
    MatLabel,
    MatButton
  ],
  templateUrl: './add-edit-contact-type-dialog.component.html',
  styleUrl: './add-edit-contact-type-dialog.component.css'
})
export class AddEditContactTypeDialogComponent {
  heading: string = "Add new";
  contactType: ContactType = new ContactType(0, "");

  constructor(private dialogRef: MatDialogRef<AddEditContactTypeDialogComponent>, @Inject(MAT_DIALOG_DATA) private oldContactType: ContactType) {
    if(oldContactType) {
      this.heading = "Edit";
      this.copyContactTypes(this.contactType, oldContactType);
    }
  }

  copyContactTypes(contactType1:ContactType, contactType2:ContactType){
    contactType1.code = contactType2.code;
    contactType1.contactTypeDescription = contactType2.contactTypeDescription;
  }

  close(){
    this.dialogRef.close();
  }

  save(){
    this.dialogRef.close(this.contactType);
  }
}

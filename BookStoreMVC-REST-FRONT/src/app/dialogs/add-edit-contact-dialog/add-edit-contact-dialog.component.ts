import {Component, Inject, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {Contact} from "../../models/Contact";
import {MatError, MatFormField, MatLabel} from "@angular/material/form-field";
import {MatOption, MatSelect} from "@angular/material/select";
import {ContactType} from "../../models/ContactType";
import {HttpClientModule} from "@angular/common/http";
import {ContactTypesService} from "../../services/contact-types/contact-types.service";
import {MatInput} from "@angular/material/input";
import {CdkTextareaAutosize} from "@angular/cdk/text-field";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-add-edit-contact-dialog',
  standalone: true,
  imports: [
    HttpClientModule,
    FormsModule,
    MatDialogTitle,
    MatDialogContent,
    MatFormField,
    MatLabel,
    MatError,
    MatSelect,
    MatOption,
    MatInput,
    CdkTextareaAutosize,
    MatDialogActions,
    MatButton
  ],
  templateUrl: './add-edit-contact-dialog.component.html',
  styleUrl: './add-edit-contact-dialog.component.css',
  providers: [ContactTypesService]
})
export class AddEditContactDialogComponent implements OnInit{
  heading: string = "Add new ";
  contact: Contact = new Contact(0, null, "", "", "", "", "");
  allContactTypes: ContactType[] = [];

  constructor(private dialogRef: MatDialogRef<AddEditContactDialogComponent>, @Inject(MAT_DIALOG_DATA) private oldContact: Contact, private contactTypesService: ContactTypesService) {
    if (oldContact) {
      this.heading = "Edit";
      this.copyContact(this.contact, oldContact);
    }
  }

  ngOnInit() {
    this.contactTypesService.getAll().subscribe((data:any)=>this.allContactTypes = data);
  }

  copyContact(contact1: Contact, contact2: Contact) {
    contact1.id = contact2.id;
    contact1.firstname = contact2.firstname;
    contact1.lastname = contact2.lastname;
    contact1.contactType = contact2.contactType;
    contact1.workPhone = contact2.workPhone;
    contact1.cellPhone = contact2.cellPhone;
    contact1.otherDetails = contact2.otherDetails;
  }

  compareContactTypes(contactType1: ContactType, contactType2: ContactType) {
    return contactType1.code === contactType2.code;
  }

  close(){
    this.dialogRef.close();
  }

  save(){
    this.dialogRef.close(this.contact);
  }
}

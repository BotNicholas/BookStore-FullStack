import {Component, OnInit} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {AuthorsService} from "../../services/authors/authors.service";
import {ContactTypesService} from "../../services/contact-types/contact-types.service";
import {ContactType} from "../../models/ContactType";
import {RouterLink} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {
  AddEditContactTypeDialogComponent
} from "../../dialogs/add-edit-contact-type-dialog/add-edit-contact-type-dialog.component";
import {Category} from "../../models/Category";
import {DeleteConfirmationComponent} from "../../dialogs/delete-confirmation/delete-confirmation.component";

@Component({
  selector: 'app-contact-types',
  standalone: true,
  imports: [HttpClientModule, RouterLink],
  templateUrl: './contact-types.component.html',
  styleUrl: './contact-types.component.css',
  providers: [ContactTypesService]
})
export class ContactTypesComponent implements OnInit{
  contactTypes: ContactType[] = [];
  constructor(private service: ContactTypesService, private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.service.getAll().subscribe((data:any)=>this.contactTypes=data);
  }

  addNewContactType() {
    const dialogRef = this.dialog.open(AddEditContactTypeDialogComponent, {autoFocus: false});

    dialogRef.afterClosed().subscribe((data: any) => {
      if (data) {
        this.service.save(data).subscribe((response:any) => {
          this.contactTypes.push(response);
        })
      }
    })
  }

  editContactType(contactType: ContactType){
    const dialogRef = this.dialog.open(AddEditContactTypeDialogComponent, {autoFocus: false, data: contactType});

    dialogRef.afterClosed().subscribe((data: any) => {
      if (data) {
        this.service.edit(contactType.code, data).subscribe((response:any) => {
          let contactTypeIndex: number = this.contactTypes.indexOf(contactType);
          this.contactTypes[contactTypeIndex] = response;
        })
      }
    })
  }

  deleteContactType(contactType: ContactType){
    const dialogRef = this.dialog.open(DeleteConfirmationComponent, {autoFocus: false, data: {target: 'ContactType', object: contactType}});

    dialogRef.afterClosed().subscribe((data: any) => {
      if (data == "Yes") {
        this.service.delete(contactType.code).subscribe((response:any) => {
          if (response.status == 204) {
            this.contactTypes.splice(this.contactTypes.indexOf(contactType), 1);
          }
        })
      }
    })
  }
}

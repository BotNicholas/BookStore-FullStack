import {Component, OnInit} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {AuthorsService} from "../../services/authors/authors.service";
import {ContactsService} from "../../services/contacts/contacts.service";
import {Contact} from "../../models/Contact";
import {ActivatedRoute, RouterLink} from "@angular/router";
import {Observable} from "rxjs";
import {MatDialog} from "@angular/material/dialog";
import {AddEditContactDialogComponent} from "../../dialogs/add-edit-contact-dialog/add-edit-contact-dialog.component";
import {DeleteConfirmationComponent} from "../../dialogs/delete-confirmation/delete-confirmation.component";

@Component({
  selector: 'app-contacts',
  standalone: true,
  imports: [HttpClientModule, RouterLink],
  templateUrl: './contacts.component.html',
  styleUrl: './contacts.component.css',
  providers: [ContactsService]
})
export class ContactsComponent implements OnInit{
  contacts: Contact[] = [];

  constructor(private service: ContactsService, private activatedRoute: ActivatedRoute, private dialog: MatDialog) {
  }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe((params:any)=>{
      let contacts: Observable<Object>;
      if (params.filter){
        contacts = this.service.getFiltered(params.filter);
      } else {
        contacts = this.service.getAll();
      }

      contacts.subscribe((data:any)=>this.contacts = data);
    })
  }

  addNewContact(){
    const dialogRef = this.dialog.open(AddEditContactDialogComponent, {autoFocus: false});

    dialogRef.afterClosed().subscribe((body:any)=>{
      if (body) {
        this.service.save(body).subscribe((response: any) => {
          this.contacts.push(response);
        });
      }
    })
  }

  editContact(contact: Contact) {
    const dialogRef = this.dialog.open(AddEditContactDialogComponent, {autoFocus: false, data: contact});

    dialogRef.afterClosed().subscribe((body:any)=>{
      if (body) {
        this.service.update(contact.id, body).subscribe((response:any)=>{
          let contactIndex: number = this.contacts.indexOf(contact);
          this.contacts[contactIndex] = response;
        });
      }
    });
  }

  deleteContact(contact: Contact) {
    const dialogRef = this.dialog.open(DeleteConfirmationComponent, {autoFocus: false, data: {target: 'Contact', object: contact}});

    dialogRef.afterClosed().subscribe((result:any)=>{
      if(result == "Yes") {
        this.service.delete(contact.id).subscribe((response:any)=>{
          if (response.status == 204) {
            this.contacts.splice(this.contacts.indexOf(contact), 1);
          }
        })
      }
    })
  }
}

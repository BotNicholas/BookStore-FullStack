import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {ContactsService} from "../../../services/contacts/contacts.service";
import {Contact} from "../../../models/Contact";
import {ContactTypesService} from "../../../services/contact-types/contact-types.service";
import {ContactType} from "../../../models/ContactType";

@Component({
  selector: 'app-contact-type',
  standalone: true,
    imports: [RouterLink, HttpClientModule],
  templateUrl: './contact-type.component.html',
  styleUrl: './contact-type.component.css',
  providers: [ContactTypesService]
})
export class ContactTypeComponent implements OnInit{
  contactType: ContactType|undefined;
  private currentCategoryId: number = 0;
  constructor(private service: ContactTypesService, private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe((params:any)=>this.currentCategoryId = params.id);
  }

  ngOnInit() {
    this.service.getById(this.currentCategoryId).subscribe((data:any)=>this.contactType = data);
  }

  showTouchedContactType(){
    alert(`${this.contactType?.code} ${this.contactType?.contactTypeDescription}`);
  }
}

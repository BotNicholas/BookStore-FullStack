import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {url} from "../../constants/constants";
import {ContactType} from "../../models/ContactType";

@Injectable()
export class ContactTypesService {
  constructor(private http: HttpClient) {}

  getAll(){
    return this.http.get(url + "ref-contact-types");
  }

  getById(id: number) {
    return this.http.get(url + "ref-contact-types/" + id);
  }

  save(contactType: ContactType){
    return this.http.post(url + "ref-contact-types", contactType);
  }

  edit(id: number, contactType: ContactType){
    return this.http.patch(url + "ref-contact-types/" + id, contactType);
  }

  delete(id: number) {
    return this.http.delete(url + "ref-contact-types/" + id, {observe: 'response'});
  }
}

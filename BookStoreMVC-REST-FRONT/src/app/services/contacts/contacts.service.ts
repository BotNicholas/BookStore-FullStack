import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {url} from "../../constants/constants";
import {Contact} from "../../models/Contact";

@Injectable()
export class ContactsService {
  constructor(private http: HttpClient) {}

  getAll(){
    return this.http.get(url + "contacts");
  }

  getFiltered(filter: string) {
    return this.http.get(url + "contacts?filter=" + filter);
  }

  save(contact: Contact) {
    return this.http.post(url + "contacts", contact);
  }

  update(id: number, contact: Contact){
    return this.http.patch(url + "contacts/" + id, contact);
  }

  delete(id: number) {
    return this.http.delete(url + "contacts/" + id, {observe: "response"});
  }
}

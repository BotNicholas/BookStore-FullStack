import { Injectable } from '@angular/core';
import { url} from "../../constants/constants";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class BooksService {
  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get(url + "books");
  }

  getById(id: number) {
    return this.http.get(url + "books/" + id);
  }

  getFiltered(filter:string){
    return this.http.get(url + "books?filter="+filter);
  }

  save(body: FormData) {
    return this.http.post(url + "books", body);
  }

  update(id: number, body: FormData){
    return this.http.patch(url + "books/" + id, body);
  }

  delete(id: number) {
    return this.http.delete(url + "books/" + id, {observe: "response"});
  }
}

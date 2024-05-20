import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {authorsImagesPath,  url} from "../../constants/constants";
import {map} from "rxjs";

@Injectable()
export class AuthorsService {
  constructor(private http: HttpClient) {}
  getAll(){
    return this.http.get(url + "authors");
  }

  getFiltered(filter: string) {
    return this.http.get(url + "authors?filter=" + filter);
  }

  getById(id: number) {
    return this.http.get(url + "authors/" + id);
  }

  save(body: FormData){
    return this.http.post(url + "authors", body);
  }

  update(id: number, body: FormData){
    return this.http.patch(url + "authors/"+id, body);
  }

  delete(id: number) {
    return this.http.delete(url + "authors/"+id, {responseType: 'text', observe: "response"});
  }
}

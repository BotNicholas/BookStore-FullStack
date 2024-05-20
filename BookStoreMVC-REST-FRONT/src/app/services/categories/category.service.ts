import { Injectable } from '@angular/core';
import {url} from "../../constants/constants";
import {HttpClient} from "@angular/common/http";
import {Category} from "../../models/Category";

@Injectable()
export class CategoryService {
  constructor(private http: HttpClient) {}

  getAll(){
    return this.http.get(url + "categories");
  }

  getById(id: number) {
    return this.http.get(url + "categories/" + id);
  }
  save(category: Category) {
    return this.http.post(url + "categories", category);
  }

  update(code: number, category: Category){
    return this.http.patch(url + "categories/" + code, category);
  }

  delete(code: number) {
    return this.http.delete(url + "categories/" + code, {responseType: 'text', observe: "response"}); //observe: "response" - tells Angular to return whole http response. Can be also "body" and "events"
  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {url} from "../../constants/constants";

@Injectable()
export class UsersService {
  constructor(private http: HttpClient) {}

  getAll(){
    return this.http.get(url + "users");
  }

  save(body: FormData){
    return this.http.post(url + "users", body);
  }

  update(id: number, body: FormData) {
    return this.http.patch(url + "users/" + id, body);
  }

  delete(id: number) {
    return this.http.delete(url + "users/" + id, {observe: "response"});
  }
}

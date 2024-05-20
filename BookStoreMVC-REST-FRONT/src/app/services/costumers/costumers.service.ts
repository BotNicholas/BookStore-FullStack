import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {url} from "../../constants/constants";
import {Costumer} from "../../models/Costumer";

@Injectable()
export class CostumersService {
  constructor(private http: HttpClient) {}

  getAll(){
    return this.http.get(url+'costumers');
  }

  getById(id: number){
    return this.http.get(url+'costumers/'+id);
  }

  save(costumer: Costumer) {
    return this.http.post(url + "costumers", costumer);
  }

  update(id: number, costumer: Costumer) {
    return this.http.patch(url + "costumers/" + id, costumer);
  }

  delete(id: number) {
    return this.http.delete(url + "costumers/" + id, {observe: "response"});
  }
}

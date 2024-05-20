import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FullOrderItem} from "../../models/FullOrderItem";
import {url} from "../../constants/constants";

@Injectable()
export class OrderItemsService {
  constructor(private http: HttpClient) {}

  save(orderItem: FullOrderItem){
    return this.http.post(url + "order-items", orderItem);
  }

  update(id: number, orderItem: FullOrderItem){
    return this.http.patch(url + "order-items/" + id, orderItem);
  }

  delete(id: number) {
    return this.http.delete(url + "order-items/" + id, {observe: "response"});
  }
}

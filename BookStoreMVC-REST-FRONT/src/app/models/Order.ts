import {Costumer} from "./Costumer";
import {OrderItem} from "./OrderItem";

export class Order {
  constructor(public id: number, public orderDate: Date, public orderValue: number, public itemList: OrderItem[], public costumer: Costumer|null) { }
}

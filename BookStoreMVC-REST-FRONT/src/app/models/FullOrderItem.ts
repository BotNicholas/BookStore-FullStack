import {Book} from "./Book";
import {Order} from "./Order";
import {OrderItem} from "./OrderItem";

export class FullOrderItem {
  constructor(public id: number, public itemAgreedPrice: number, public itemComment: string, public book: Book|null, public amount: number, public order: Order|null){}
}

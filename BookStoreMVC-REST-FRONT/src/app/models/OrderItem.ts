import {Book} from "./Book";

export class OrderItem {
  constructor(public id: number, public itemAgreedPrice: number, public itemComment: string, public book: Book|null, public amount: number){}
}

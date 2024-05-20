import {Author} from "./Author";
import {Category} from "./Category";

export class Book {
  constructor(public id: number, public author: Author|null, public category: Category|null, public isbn: string, public publicationDate: Date, public dateAcquired: Date, public title: string, public recommendedPrice: number, public comments: string, public image: string) {}
}

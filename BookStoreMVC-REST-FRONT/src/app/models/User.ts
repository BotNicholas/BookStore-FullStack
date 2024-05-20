import {Costumer} from "./Costumer";

export class User {
  constructor(public id: number, public username: string, public password: string, public roles: string, public costumer: Costumer|null, public image: string) {}
}

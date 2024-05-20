import {Order} from "./Order";

export class Costumer {
  constructor(public id: number, public idnp: string, public name: string, public address: string, public phone: string, public email: string, public orders: number[]) {
  }
}

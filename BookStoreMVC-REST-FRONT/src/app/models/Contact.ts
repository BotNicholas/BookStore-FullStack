import {ContactType} from "./ContactType";

export class Contact {
  constructor(public id: number, public contactType: ContactType|null, public firstname: string, public lastname: string, public workPhone: string, public cellPhone: string, public otherDetails: string) {}
}

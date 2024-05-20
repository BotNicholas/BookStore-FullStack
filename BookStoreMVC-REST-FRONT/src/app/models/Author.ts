export class Author {
  constructor(public id: number,
              public firstname: string,
              public lastname: string,
              public initials: string,
              public birthDate: Date,
              public gender: string,
              public contactDetails: string,
              public otherDetails: string,
              public image: string,
              public books: number[]) {}
}

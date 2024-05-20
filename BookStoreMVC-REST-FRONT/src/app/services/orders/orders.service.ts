import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {url} from "../../constants/constants";
import {firstValueFrom, lastValueFrom, map} from "rxjs";
import {BooksService} from "../books/books.service";
import {OrderItem} from "../../models/OrderItem";
import {Book} from "../../models/Book";
import {Order} from "../../models/Order";

@Injectable()
export class OrdersService {
  constructor(private http: HttpClient, private booksService: BooksService) {
  }

  async test(){
    // this.http.get(url + "orders").pipe(map(async (orders: any) => {
    // let copy = orders;
    //
    // for (let order of copy) {
    //   let orderItems = order.itemList;
    //
    //   for (let orderItem of orderItems) {
    //     let AAA;
    //     // this.booksService.getById(orderItem.book).subscribe((data: any) => {orderItem = data});
    //     //await stops the function execution, unless it obtains the result. That's why it needs the function to be async - it controls it's execution
    //
    //     // Да, вы абсолютно правы! Ключевое слово async определяет функцию как асинхронную, что позволяет использовать внутри неё await для управления асинхронными операциями. Await приостанавливает выполнение текущей асинхронной функции до тех пор, пока промис не будет разрешен или отклонен, но это приостановление не влияет на выполнение остальной части приложения. Приложение продолжает обрабатывать другие события, пользовательский ввод или другие асинхронные операции.
    //     //
    //     // Это критически важно для приложений, работающих в однопоточных средах, как например JavaScript в браузере, где блокирование главного потока привело бы к "замерзанию" пользовательского интерфейса.
    //     // await firstValueFrom(this.booksService.getById(orderItem.book)).then(value => AAA = value);
    //
    //     //Promise работает только с одним значением, возвращая его один раз. Observable же работает с потоком данных, которые могут поступать в любое время, позволяя возвращать множество данных
    //     //Promise
    //     //
    //     //     Одноразовое использование: Promise предназначен для однократной операции, которая либо успешно завершится, либо завершится с ошибкой. Он не может быть использован повторно после того, как разрешится или отклонится.
    //     //     Одно значение: Каждый Promise может возвращать только одно значение или ошибку, и после этого его состояние не изменится.
    //
    //     //Observable
    //     //
    //     //     Множественные значения: Observable может излучать множество значений со временем, что делает его идеальным для обработки потоков данных, таких как пользовательские вводы, данные с сервера и т.д.
    //     //     Повторное использование: Observable может быть подписан и отписан многократно, и он способен обслуживать множество подписчиков.
    //     //     Управление подписками: Подписчики могут активно решать, когда начинать и прекращать прослушивание данных, позволяя более гибко управлять ресурсами.
    //
    //     //То есть Promise - это одноразовый Observable, который точно вернет данные и уже никак не изменится
    //     console.log(AAA);
    //   }
    // }
    //
    // console.log(copy);

    // const value = await lastValueFrom(this.booksService.getById(1));
    // console.log(value);


    // }));

    let res;
    // res = await lastValueFrom(this.booksService.getAll()); //await waits ang gets the result. Here res has value!!!
    // this.booksService.getAll().subscribe(value => res = value); //Here res == undefined
    console.log(res);
  }

  getAll(){
    // return this.http.get(url + "orders").pipe(map((orders:any)=>{
    //   for (let order of orders) {
    //     let orderItems = order.itemList;
    //
    //     for (let item of orderItems) {
    //       this.booksService.getById(item.book).subscribe((data:any)=>item.book = data);
    //     }
    //   }
    //   return orders;
    // }));
    return this.http.get(url + "orders");
  }

  getById(id: number) {
    return this.http.get(url + "orders/" + id);
  }

  save(order: Order){
    return this.http.post(url + "orders", order);
  }

  update(id: number, order: Order){
    return this.http.patch(url + "orders/" + id, order);
  }

  delete(id: number) {
    return this.http.delete(url + "orders/" + id, {observe: 'response'});
  }
}

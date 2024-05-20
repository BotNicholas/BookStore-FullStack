import {Component, ElementRef, OnInit} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {BooksService} from "../../services/books/books.service";
import {OrdersService} from "../../services/orders/orders.service";
import { Order } from '../../models/Order';
import {RouterLink} from "@angular/router";
import {DatePipe, DecimalPipe} from "@angular/common";
import {MatDialog} from "@angular/material/dialog";
import {AddEditOrderDialogComponent} from "../../dialogs/add-edit-order-dialog/add-edit-order-dialog.component";
import {AddOrderItemDialogComponent} from "../../dialogs/add-order-item-dialog/add-order-item-dialog.component";
import {OrderItemsComponent} from "../order-items/order-items.component";
import {Book} from "../../models/Book";
import {FullOrderItem} from "../../models/FullOrderItem";
import {OrderItemsService} from "../../services/order-items/order-items.service";
import {DeleteConfirmationComponent} from "../../dialogs/delete-confirmation/delete-confirmation.component";

@Component({
  selector: 'app-orders',
  standalone: true,
  imports: [HttpClientModule, RouterLink, DatePipe, OrderItemsComponent, DecimalPipe],
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css',
  providers: [OrdersService, BooksService, OrderItemsService]
})
export class OrdersComponent implements OnInit{
  orders: Order[] = [];
  constructor(private service:OrdersService, private orderItemsService: OrderItemsService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.service.getAll().subscribe((data:any)=>{
      this.orders = data;
      // console.log(data);
    });
  }

  showItems(itemsElement: HTMLTableCellElement){
    if (window.getComputedStyle(itemsElement).display == 'none') {
      itemsElement.style.display = 'table-cell';
      itemsElement.classList.remove('order-item-cell-close');
      itemsElement.classList.add('order-item-cell-open');
      // itemsElement.style.animationName = 'item-close';
    } else {
      itemsElement.classList.remove('order-item-cell-open');
      itemsElement.classList.add('order-item-cell-close');
      setTimeout(()=>{itemsElement.style.display = 'none';}, 700);

      // itemsElement.style.animationName = 'item-close';
    }
  }


  addNewOrder(){
    const dialogRef = this.dialog.open(AddEditOrderDialogComponent, {autoFocus: false});

    dialogRef.afterClosed().subscribe((body:any)=>{
      console.log(body);
      if(body) {
        this.service.save(body).subscribe((response:any) => {
          this.orders.push(response);
        });
      }
    });
  }

  editOrder(order: Order) {
    let dialogRef = this.dialog.open(AddEditOrderDialogComponent, {autoFocus: false, data: order});

    dialogRef.afterClosed().subscribe((body:any)=>{
      if (body) {
        this.service.update(order.id, body).subscribe((response:any) => {
          let orderIndex = this.orders.indexOf(order);
          this.orders[orderIndex] = response;
        });
      }
    });
  }

  deleteOrder(order: Order) {
    let dialogRef = this.dialog.open(DeleteConfirmationComponent, {autoFocus: false, data: {target: 'Order', object: order}});

    dialogRef.afterClosed().subscribe((body:any)=>{
      if (body == "Yes") {
        this.service.delete(order.id).subscribe((response:any) => {
          if (response.status == 204) {
            this.orders.splice(this.orders.indexOf(order), 1);
          }
        });
      }
    });
  }

  addNewOrderItemFor(order: Order) {
    const dialogRef = this.dialog.open(AddOrderItemDialogComponent, {autoFocus: false});

    dialogRef.afterClosed().subscribe((body:Map<Book, number>)=>{
      if (body) {
        for (let book of body.keys()){
          // order.itemList = order.itemList.map((item:OrderItem) => {return item.id}) as any;
          // to save new order tem object Order object can contain only its id
          // let orderItem: FullOrderItem = new FullOrderItem(0, book.recommendedPrice, "", book, body.get(book) as number, new Order(order.id, new Date(), 0, [], null));
          let orderItem: FullOrderItem = new FullOrderItem(0, book.recommendedPrice, "", book, body.get(book) as number, order);

          this.orderItemsService.save(orderItem).subscribe((response:any)=>{
            order.itemList.push(response);

            this.updateOrder(order);

          });
        }
      }
    });
  }

  updateOrder(order: Order){
    this.service.getById(order.id).subscribe((response:any)=>{
      this.orders[this.orders.indexOf(order)] = response;
    });
  }

  showTouchedOrder(order: Order){
    alert(`${order.id} ${order.orderDate} ${order.orderValue} ${order.costumer?.name} \n${order.itemList} `);
  }

  protected readonly window = window;
}

//todo: On service side transform BookId into Book with help of .pipe(map()...)
//todo: Header height must be dynamic (min height = ... height = max-content)

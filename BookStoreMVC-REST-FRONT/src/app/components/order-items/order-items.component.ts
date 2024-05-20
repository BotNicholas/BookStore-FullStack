import {Component, EventEmitter, Input, Output} from '@angular/core';
import {RouterLink} from "@angular/router";
import {Book} from "../../models/Book";
import {Order} from "../../models/Order";
import {OrderItem} from "../../models/OrderItem";
import {FullOrderItem} from "../../models/FullOrderItem";
import {OrdersService} from "../../services/orders/orders.service";
import {OrderItemsService} from "../../services/order-items/order-items.service";
import {HttpClientModule} from "@angular/common/http";
import {MatDialog} from "@angular/material/dialog";
import {EditOrderItemDialogComponent} from "../../dialogs/edit-order-item-dialog/edit-order-item-dialog.component";
import {DeleteConfirmationComponent} from "../../dialogs/delete-confirmation/delete-confirmation.component";

@Component({
  selector: 'order-items',
  standalone: true,
  imports: [
    HttpClientModule,
    RouterLink
  ],
  templateUrl: './order-items.component.html',
  styleUrl: './order-items.component.css',
  providers: [OrderItemsService]
})
export class OrderItemsComponent {
  @Input("order") order: Order|null = null;
  @Output("orderItemUpdated") orderItemUpdatedEventEmitter: EventEmitter<Order> = new EventEmitter<Order>();

  constructor(private orderItemService: OrderItemsService, private dialog: MatDialog) {}

  editOrderItem(orderItem: OrderItem) {
    let fullOrderItem: FullOrderItem = new FullOrderItem(orderItem.id, orderItem.itemAgreedPrice, orderItem.itemComment, orderItem.book, orderItem.amount, this.order);
    const dialogRef = this.dialog.open(EditOrderItemDialogComponent, {autoFocus: false, data: fullOrderItem});

    dialogRef.afterClosed().subscribe((body: any)=>{
      if (body) {
        this.orderItemService.update(orderItem.id, body).subscribe((response: any)=>{
          if (this.order) {
            let orderItemIndex: number = this.order.itemList.indexOf(orderItem);
            this.order.itemList[orderItemIndex] = response;
            this.orderItemUpdatedEventEmitter.emit(this.order);
          }
        });
      }
    });
  }

  deleteOrderItem(orderItem: OrderItem) {
    let dialogRef = this.dialog.open(DeleteConfirmationComponent, {autoFocus: false, data: {target: 'OrderItem', object: orderItem}});

    dialogRef.afterClosed().subscribe((result:any)=>{
      if (result == "Yes") {
        this.orderItemService.delete(orderItem.id).subscribe((response:any)=>{
          if (response.status == 204) {
            if (this.order) {
              this.order?.itemList.splice(this.order.itemList.indexOf(orderItem), 1);
              this.orderItemUpdatedEventEmitter.emit(this.order);
            }
          }
        });
      }
    });
  }
  showTouchedOrderItem(orderItem: OrderItem){
    alert(`${orderItem.id} ${orderItem.itemAgreedPrice} ${orderItem.itemComment} ${orderItem.book}`);
  }
}

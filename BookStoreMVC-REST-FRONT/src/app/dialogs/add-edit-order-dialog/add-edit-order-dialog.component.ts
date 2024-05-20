import {Component, Inject, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {Order} from "../../models/Order";
import {MatDatepicker} from "@angular/material/datepicker";
import {MatFormField, MatInput, MatLabel} from "@angular/material/input";
import {MatOption, MatSelect} from "@angular/material/select";
import {Costumer} from "../../models/Costumer";
import {HttpClientModule} from "@angular/common/http";
import {CostumersService} from "../../services/costumers/costumers.service";
import {MatError} from "@angular/material/form-field";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-add-edit-order-dialog',
  standalone: true,
  imports: [
    FormsModule,
    MatDialogTitle,
    MatDialogContent,
    MatDatepicker,
    MatInput,
    MatLabel,
    MatFormField,
    MatSelect,
    MatError,
    MatOption,
    HttpClientModule,
    MatDialogActions,
    MatButton
  ],
  templateUrl: './add-edit-order-dialog.component.html',
  styleUrl: './add-edit-order-dialog.component.css',
  providers: [CostumersService]
})
export class AddEditOrderDialogComponent implements OnInit{
  heading: string = "Add new";
  order: Order = new Order(0, new Date(), 0, [], null);
  allCostumers: Costumer[] = [];

  constructor(private dialogRef: MatDialogRef<AddEditOrderDialogComponent>, @Inject(MAT_DIALOG_DATA) public oldOrder: Order, private costumersService: CostumersService) {
    if (oldOrder) {
      this.heading = "Edit";
      this.copyOrders(this.order, oldOrder);
    }
  }

  ngOnInit() {
    this.costumersService.getAll().subscribe((costumers:any) => {this.allCostumers = costumers});
  }

  copyOrders(order1: Order, order2: Order){
    order1.id = order2.id;
    order1.orderDate = order2.orderDate;
    order1.orderValue = order2.orderValue;
    order1.itemList = order2.itemList;
    order1.costumer = order2.costumer;
  }

  close(){
    this.dialogRef.close();
  }

  save(){
    this.dialogRef.close(this.order);
  }

  compareCostumers(costumer1: Costumer, costumer2: Costumer){
    return costumer1.id == costumer2.id;
  }
}

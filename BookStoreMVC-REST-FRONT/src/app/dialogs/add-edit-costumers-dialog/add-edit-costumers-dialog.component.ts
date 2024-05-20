import {Component, Inject} from '@angular/core';
import {CdkTextareaAutosize} from "@angular/cdk/text-field";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatButton} from "@angular/material/button";
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {MatError, MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {Costumer} from "../../models/Costumer";

@Component({
  selector: 'app-add-edit-costumers-dialog',
  standalone: true,
  imports: [
    CdkTextareaAutosize,
    FormsModule,
    MatButton,
    MatDialogActions,
    MatDialogContent,
    MatDialogTitle,
    MatError,
    MatFormField,
    MatInput,
    MatLabel,
    MatOption,
    MatSelect,
    ReactiveFormsModule
  ],
  templateUrl: './add-edit-costumers-dialog.component.html',
  styleUrl: './add-edit-costumers-dialog.component.css'
})
export class AddEditCostumersDialogComponent {
  heading: string = "Add new";
  costumer: Costumer = new Costumer(0, "" ,"", "", "", "", []);

  constructor(private dialogRef: MatDialogRef<AddEditCostumersDialogComponent>, @Inject(MAT_DIALOG_DATA) private oldCostumer: Costumer) {
    if (oldCostumer) {
      this.heading = "Edit";
      this.copyCostumers(this.costumer, oldCostumer);
    }
  }

  copyCostumers(costumer1: Costumer, costumer2: Costumer) {
    costumer1.id = costumer2.id;
    costumer1.name = costumer2.name;
    costumer1.idnp = costumer2.idnp;
    costumer1.address = costumer2.address;
    costumer1.email = costumer2.email;
    costumer1.phone = costumer2.phone;
    costumer1.orders = costumer2.orders;
  }

  close(){
    this.dialogRef.close();
  }

  save(){
    this.dialogRef.close(this.costumer);
  }
}

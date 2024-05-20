import {Component, OnInit} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {CostumersService} from "../../services/costumers/costumers.service";
import {Costumer} from "../../models/Costumer";
import {MatDialog} from "@angular/material/dialog";
import {
  AddEditCostumersDialogComponent
} from "../../dialogs/add-edit-costumers-dialog/add-edit-costumers-dialog.component";
import {DeleteConfirmationComponent} from "../../dialogs/delete-confirmation/delete-confirmation.component";

@Component({
  selector: 'app-costumers',
  standalone: true,
  imports: [HttpClientModule],
  templateUrl: './costumers.component.html',
  styleUrl: './costumers.component.css',
  providers: [CostumersService]
})
export class CostumersComponent implements OnInit{
  costumers: Costumer[] = [];
  constructor(private service:CostumersService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.service.getAll().subscribe((data:any)=>this.costumers=data);
  }

  addNewCostumer(){
    const dialogRef = this.dialog.open(AddEditCostumersDialogComponent, {autoFocus: false});

    dialogRef.afterClosed().subscribe((data: any) => {
      if (data) {
        this.service.save(data).subscribe((response: any)=>{
          this.costumers.push(response);
        });
      }
    });
  }

  editCostumer(costumer: Costumer){
    const dialogRef = this.dialog.open(AddEditCostumersDialogComponent, {autoFocus: false, data: costumer});

    dialogRef.afterClosed().subscribe((data: any)=>{
      if (data) {
        this.service.update(costumer.id, data).subscribe((response: any)=>{
          let costumerIndex = this.costumers.indexOf(costumer);
          this.costumers[costumerIndex] = response;
        });
      }
    });
  }

  deleteCostumer(costumer: Costumer){
    const dialogRef = this.dialog.open(DeleteConfirmationComponent, {autoFocus:false, data:{target: 'Costumer', object: costumer}});

    dialogRef.afterClosed().subscribe((data: any)=>{
      if (data == "Yes") {
        this.service.delete(costumer.id).subscribe((response: any)=>{
          if (response.status == 204) {
            window.location.reload();
            // this.costumers.splice(this.costumers.indexOf(costumer), 1);
          }
        });
      }
    });
  }
  // showTouchedCostumer(costumer: Costumer){
  //   alert(`${costumer.id} ${costumer.idnp} ${costumer.name} ${costumer.address} ${costumer.phone} ${costumer.email}`);
  // }

}
//todo: customers/:id will be needed for users page. b`cause costumers links are expected there

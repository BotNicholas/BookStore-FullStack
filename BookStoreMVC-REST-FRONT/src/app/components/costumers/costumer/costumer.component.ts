import {Component, OnInit} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {CostumersService} from "../../../services/costumers/costumers.service";
import {Costumer} from "../../../models/Costumer";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-costumer',
  standalone: true,
  imports: [HttpClientModule],
  templateUrl: './costumer.component.html',
  styleUrl: './costumer.component.css',
  providers: [CostumersService]
})
export class CostumerComponent implements OnInit{
  costumer: Costumer|undefined;
  private currentCustomerId: number = 0;
  constructor(private service: CostumersService, private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe((params:any)=>this.currentCustomerId = params.id);
  }

  ngOnInit() {
    this.service.getById(this.currentCustomerId).subscribe((data:any)=>this.costumer = data);
  }

  showTouchedCostumer(){
    alert(`${this.costumer?.id} ${this.costumer?.idnp} ${this.costumer?.name} ${this.costumer?.address} ${this.costumer?.phone} ${this.costumer?.email}`);
  }
}

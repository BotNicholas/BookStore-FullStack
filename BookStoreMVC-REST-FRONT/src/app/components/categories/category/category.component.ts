import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from "@angular/router";
import {Category} from "../../../models/Category";
import {HttpClientModule} from "@angular/common/http";
import {CategoryService} from "../../../services/categories/category.service";

@Component({
  selector: 'app-category',
  standalone: true,
  imports: [RouterLink, HttpClientModule],
  templateUrl: './category.component.html',
  styleUrl: './category.component.css',
  providers: [CategoryService]
})
export class CategoryComponent implements OnInit{
  private currentCategoryId: number = 0;
  category: Category|undefined;

  constructor(private service: CategoryService, private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe((params:any)=>this.currentCategoryId = params.id);
  }

  ngOnInit() {
    this.service.getById(this.currentCategoryId).subscribe((data:any)=>this.category = data);
  }

  showTouchedCategory() {
    alert(`${this.category?.code} ${this.category?.categoryDescription}`);
  }
}

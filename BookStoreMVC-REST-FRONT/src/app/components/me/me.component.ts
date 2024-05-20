import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-me',
  standalone: true,
  imports: [],
  templateUrl: './me.component.html',
  styleUrl: './me.component.css'
})
export class MeComponent {
  x: number = 1;
  increment(){
    this.x++;
  }
  constructor(private router: Router) {
  }
  goHome(){
    this.router.navigate(['/']);
  }
}

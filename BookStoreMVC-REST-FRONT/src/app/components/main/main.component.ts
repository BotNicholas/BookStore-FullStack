import { Component } from '@angular/core';
import {Router, RouterLink, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {
  constructor(private router: Router) {
    // router.events.pipe(filter((event)=> event instanceof NavigationEnd))
    //   .subscribe((data:any)=>this.currentUrl = data.urlAfterRedirects);
  }

  goHome(){
    this.router.navigate(['/']);
  }

  goToMe(){
    this.router.navigate(['/me']);
  }
}

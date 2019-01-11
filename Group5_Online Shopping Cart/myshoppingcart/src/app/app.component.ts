import { Component } from '@angular/core';
import { routerNgProbeToken } from '@angular/router/src/router_module';
import {Router} from '@angular/router';
import { CartService } from './services/cart.service';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  [x: string]: any;
  title = 'myshoppingcart';

  constructor(private router:Router,private authService:AuthService){}
 
  logOut(){
    localStorage.removeItem('token');
    
    this.router.navigate(['/home'])

    }
}

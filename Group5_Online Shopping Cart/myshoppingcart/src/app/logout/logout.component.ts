import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router, private cartService:CartService) { }

  ngOnInit() {
    this.logout();
  }
logout()
{
  localStorage.clear();
  this.cartService.cleartcart();
  alert("Thanks for Chosing Flipzon! Have a nice day");
  this.router.navigate(['/home'])
}

}

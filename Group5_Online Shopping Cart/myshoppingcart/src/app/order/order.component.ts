import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from '../services/order.service';
import { Order } from '../Model/order';
@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  orderSummary: Order[] = [];


  constructor(private router: Router, private orderService: OrderService, private httpclientservice: OrderService) { }
  ngOnInit() {
    this.getOrderSummary();
  }


  getOrderSummary() {
    let em=localStorage.getItem('email');
    //let em = "b@b.com";
    if (em != null) {
      this.httpclientservice.getOrderSummary(em).subscribe(orderSummary => 
        { this.orderSummary = orderSummary; 
          console.log(this.orderSummary)
      })
      
    }
    else {
      this.router.navigate['/login'];
    }
  }

}

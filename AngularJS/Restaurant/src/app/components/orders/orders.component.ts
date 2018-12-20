import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/order.service';
import { Order } from 'src/app/viewmodels/order.viewmodel';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orders: Order[] = [];
  ordersCart: any = {};
  constructor(private orderService: OrderService) { }

  get format() {
    return 'short';
  }

  ngOnInit() {
    this.getOrders();
  }

  getOrders() {
    this.orderService.getOrderFromJSON().subscribe((res) => {
      this.orders = res;
    });
  }

  getOrdersCart(id) {
    this.ordersCart = {};
    this.orderService.getCartFromJSON(id).subscribe((res) => {
      this.ordersCart = res;
    });
  }
}

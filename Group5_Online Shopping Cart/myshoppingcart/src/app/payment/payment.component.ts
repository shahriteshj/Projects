import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { Cart } from '../Model/cart';
import { Order } from '../Model/order';
import { OrderDetails } from '../Model/orderDetails';
import { OrderService } from '../services/order.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  totalPrice: Number;
  orderId: Number;
  constructor(private cartService: CartService, private _orderService: OrderService, private router: Router) { }
  address = "";
  ngOnInit() {
    this.totalPrice = this.cartService.getSum();
  }

  placeOrder() {
    console.log(" in place order");
    var orderDetails: OrderDetails[] = [];
    var cart: Cart[] = this.cartService.cart;
    console.log("Check : " + JSON.stringify(cart));
    for (var i = 0; i < cart.length; i++) {
      console.log(cart[i]);
      var obj = new OrderDetails(cart[i].productId, cart[i].productName, cart[i].productQuantity, cart[i].productPrice);
      console.log(obj);
      orderDetails.push(obj);
    }
    let ord: Order = {
      email: localStorage.getItem('email'),
      shippingAddress: this.address,//this.cartService.cart[i].productCategoryId
      orderAmount: this.totalPrice,
      orderDetails: orderDetails
    }
    console.log("Order info :" + JSON.stringify(ord));

    this._orderService.createOrder(ord).subscribe((res: any) => {

      this.orderId = res;
      alert("Your Order is succesfully Placed. Order Number is :" + this.orderId);//this.orderId, localStorage.getItem('token'));
      this.cartService.cleartcart();
      this.router.navigate(['/productlist']);
    });
  }
}

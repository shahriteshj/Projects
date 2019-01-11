import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import { Product } from '../Model/product';
import { Cart } from '../Model/cart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  viewcart: Cart[]=[];
  totalPrice: Number;
  constructor(private router: Router, private cartService: CartService) { }

  ngOnInit() {
    this.viewcart = this.cartService.viewCart();
    this.getSum();

    //console.log(this.viewcart);
  }

  removefromcart(c) {
    this.cartService.removefromcart(c);
    this.cartService.getSum();
    console.log(this.cartService.getSum());
  }

  Placeorder(cart) {
    this.cartService.Placeorder(cart);
  }
  Emptycart() {
    this.cartService.emptyCart();
  }

  getSum()
  {
    //this.cartService.getSum();
    this.totalPrice=this.cartService.getSum();
    console.log("Received : " + this.totalPrice);
  }
  decrement(c){
    c.productQuantity=c.productQuantity-1
    this.getSum();
    if (c.productQuantity<1)
    {
      this.removefromcart(c)
    }
  }
  increment(c){
    c.productQuantity=c.productQuantity+1
    this.getSum();
  }

  topaymentGateway() 
  {
    //console.log("i am in");
    var emailId=localStorage.getItem("email");

    if (emailId!=null)
    {
        this.router.navigate(['/paymentgateway']);
    }
    else
    {
      this.router.navigate(['/login']);
    }
  }


changequantity(index, quantity)
{
  console.log("in change quantity" + index +" "+ quantity);
  this.cartService.changequantity(index, quantity);
  this.getSum();
}
}


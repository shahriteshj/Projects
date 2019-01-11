import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../Model/product';
import { Cart } from '../Model/cart';
import { Order } from '../Model/order';
@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private router: Router) { }

  cart: Cart[] = [];
  
  addToCart(pro: Cart) {
    console.log(pro);
    if(pro)
    {
      let data=this.cart.find((c)=>c.productId===pro.productId);
      if(data){
        data.productQuantity+=1;
        console.log(data.productQuantity)
      }
      else{
        this.cart.push(pro);
        console.log(this.cart)
      }
      alert("Product Added to the cart!!");
    }
   
    // for (let i = 0; i < this.cart.length; i++) {
    //   this.cart[i].productQuantity = 1;
    // }
    // console.log(this.cart);
  }

  viewCart() {
    this.getSum();
    //console.log(this.cart);
    return this.cart;
  }

  removefromcart(pro) {
    let index =  this.cart.indexOf(pro);
    this.cart.splice(index, 1)
    this.getSum();
    this.router.navigate(['/viewcart'])
    
  }

  getSum() {
    let sum = 0;
    let orderPrice = 0;
    for (let i = 0; i < this.cart.length; i++)
     {
      orderPrice = this.cart[i].productPrice * this.cart[i].productQuantity;
      this.cart[i].productTotalprice = orderPrice;
      sum += this.cart[i].productTotalprice;
    }
    console.log(sum);
    return sum;

  }
  Placeorder(cart) {
    var token = localStorage.getItem("token");
    console.log(token);
    if (token !== null) {
      console.log("Order placed sucessfully");
    }
    else {
      this.router.navigate(['/login']);
    }
  }
  emptyCart() {
    for (let i = 0; i < this.cart.length; i++) {
      this.cart.slice(i);
    }
  }

  changequantity(index: number, quantity: number) {
    for (let i = 0; i <= this.cart.length; i++) {
      if (i == index) {
        this.cart[i].productQuantity = quantity;
      }
      this.getSum();
    }
    console.log(this.cart);
    

  }
  cleartcart()
  {
    for (let i = 0; i <= this.cart.length; i++) 
    {
        this.cart.splice(i);
    }
  }


  
  
}

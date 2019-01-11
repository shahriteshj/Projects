import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';

@Component({
    selector:"app-user-cart",
    templateUrl:'./user-cart.component.html',
    styleUrls:['./user-cart.component.css']
})

export class UserCartComponent implements OnInit{
    cartItems = [];    
    constructor (private cartService: CartService){
        
    }
    
    ngOnInit(){
        this.cartItems = this.cartService.getCartItems();
    }
}
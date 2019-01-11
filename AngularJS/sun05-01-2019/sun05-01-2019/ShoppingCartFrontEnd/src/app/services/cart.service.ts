import {Injectable} from '@angular/core';
@Injectable()
export class CartService{
    cartItems = [];
    addToCart(cartItem: any){
        this.cartItems.push(cartItem);
    }
    
    getCartItems(): any[]{
        return this.cartItems;
    }
}
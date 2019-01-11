import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';
import { Item } from '../model/Item';
import { NgForm } from '@angular/forms';
import { CartItem } from '../model/CartItem';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  cartItems: CartItem[]=[];
  products: Product[];
  cartItem:CartItem;

  constructor(private _productService: ProductService) { }

  ngOnInit() {
    this.getProducts();
    console.log(this.products);
    let i:number =1;
    for(let p of this.products ){
      let cartItem1:CartItem={
        id:i,
        product:<Product>p,
        quantity:0
      }
      this.cartItems.push(cartItem1);
      i=i+1;
    }

  }

  getProducts() {
    return this._productService.getProducts().subscribe(products => { return this.products = <Product[]>products; });
  }

  AddItem(frm:NgForm){
    
    let item:Item={
      
      name:frm.value.name,
      quantity:Number(frm.value.quantity)
    }
  }

}

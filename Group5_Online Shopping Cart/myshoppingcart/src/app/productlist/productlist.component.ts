import { Component, OnInit } from '@angular/core';
import { Product } from '../Model/product';
import { Cart } from '../Model/cart';

import { ProductlistService } from 'src/app/services/productlist.service'
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {

  products: Product[]

  constructor(private httpclientservice: ProductlistService, private router: Router, private cartService: CartService) { }

  ngOnInit() {
    this.getProducts().then(res => {
      console.log(" after", this.products)
    });
    console.log("before ", this.products);


  }

  getProducts() {
    return new Promise((resolve) => {
      this.httpclientservice.getProducts().subscribe(
        products => { this.products = products; resolve(true); });
    })
  }

  addToCart(p: Cart) {
    console.log(p);
    let selectedProduct: Cart = {
      productId: p.productId,
      productName: p.productName,
      productPrice: p.productPrice,
      productQuantity: 1,
      productCategoryId: p.productCategoryId,
      productPrimaryImage: p.productPrimaryImage,
      productTotalprice: p.productTotalprice
    };

    //document.getElementById("demo").innerHTML = "Product Added to the cart";
    // this.cartService.addToCart(p);
    this.cartService.addToCart(selectedProduct)

  }

}


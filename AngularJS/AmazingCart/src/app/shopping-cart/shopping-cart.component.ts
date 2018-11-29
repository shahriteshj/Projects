import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  products: Product[];
  toggleForm: Boolean = false;
  selectedProduct: Product;

  constructor(private _productService: ProductService) { }

  ngOnInit() {
    this.getProducts();
    console.log(this.products);

  }

  getProducts() {
    return this._productService.getProducts().subscribe(products => { this.products = <Product[]>products; });
  }

}

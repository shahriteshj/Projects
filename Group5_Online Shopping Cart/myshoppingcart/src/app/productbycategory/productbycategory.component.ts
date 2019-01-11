import { Component, OnInit } from '@angular/core';
import { Product } from '../Model/product';
import {ProductlistService} from 'src/app/services/productlist.service'
@Component({
  selector: 'app-productbycategory',
  templateUrl: './productbycategory.component.html',
  styleUrls: ['./productbycategory.component.css']
})
export class ProductbycategoryComponent implements OnInit {
  productsbyc: Product[]
  categoryName: String

  constructor(private httpclientservice: ProductlistService) { }

  ngOnInit() {
    this.getProductsbycategory(this.categoryName).then(res=>{
      console.log(" after",this.categoryName)
    });
    console.log("before " , this.categoryName);
  }

  getProductsbycategory(categoryName) {
    // console.log("Hello");
    // console.log(this.categoryName);
    return new Promise((resolve)=>{
      this.httpclientservice.getProductsbycategory(categoryName).subscribe(
        productsbyc => { this.productsbyc = <Product[]>productsbyc; resolve(true); });
    })
  }
}



 
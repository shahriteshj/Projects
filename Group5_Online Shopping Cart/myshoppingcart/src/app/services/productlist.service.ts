import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../Model/product';
@Injectable({
  providedIn: 'root'
})
export class ProductlistService {


  constructor(private _http: HttpClient) {

  }
  getProducts(): Observable<Product[]> {
    return this._http.get<Product[]>('http://192.168.1.94:8082/api/products/productList');
    // http://localhost:8082/api/products/productList
  }

  getProductsbycategory(cg) {
    console.log("In Service " + cg)
    var url = "http://192.168.1.94:8082/api/products/ProductListbyCategory/" + cg;
    console.log(url);

    return this._http.get(url);
  }

  // updateProduct(product: Product) {
  //   console.log(product.id);
  //   return this._http.put('http://localhost:3000/Products/' + product.id, product);

  // }
}

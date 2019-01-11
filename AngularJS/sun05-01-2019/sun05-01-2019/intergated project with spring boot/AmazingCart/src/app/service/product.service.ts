import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../model/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private _http: HttpClient) { }

  getProducts():Observable<Product[]> {
    return this._http.get<Product[]>('http://localhost:3000/Products');
  }

  addProduct(product: Product) {
    return this._http.post("http://localhost:3000/Products", product);

  }

  updateProduct(product: Product) {
    console.log(product.id);
    return this._http.put('http://localhost:3000/Products/' + product.id, product);

  }

  removeProduct(id) {
    return this._http.delete('http://localhost:3000/Products/' + id)

  }
}

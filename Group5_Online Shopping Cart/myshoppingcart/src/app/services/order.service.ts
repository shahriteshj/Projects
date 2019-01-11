import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from '../Model/order';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  createOrder(order: Order) {
    return this.http.post("http://192.168.1.33:8082/api/products/placeOrder", order);
  }

  getOrderSummary(email):Observable<Order[]> {
    return this.http.get<Order[]>('http://192.168.1.33:8082/api/products/orderSummery/'+email);
  }
}

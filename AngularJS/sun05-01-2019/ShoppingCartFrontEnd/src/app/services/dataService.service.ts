 import { Injectable } from "@angular/core";
//  import { Http, Response,Headers } from '@angular/http';
//  import { Observable } from 'rxjs';
//  import 'rxjs/add/operator/map';
//  import { map } from 'rxjs/operator/map';
 import { HttpClient } from '@angular/common/http';

 import { ShoppingItem } from '../model/ShoppingItem';
 import { User } from '../model/User';
 @Injectable()
 export class DataService{
     constructor(private httpClient: HttpClient){//private http: Http,        
     }

     getUser(user:User) {//:Observable<User>{
        // return this.http.post('http://localhost:3000/getUser',user).map((res:Response) =>  <User>(res.json())); 
       //return this.httpClient.post<User>("getUser", user);
       return this.httpClient.post<User>("http://localhost:3000/getUser", user);
     }

     createUser(user:User){//:Observable<User>{
        // return this.httpClient.post('http://localhost:3000/createUser',user).map((res:Response) =>  <User>(res.json())); 
        //return this.httpClient.post<User>('createUser',user);
       return this.httpClient.post<User>('http://localhost:3000/createUser', user);
     }
     
     getItems(){//: Observable<ShoppingItem[]>{
        // return this.http.get('http://localhost:3000/items').map((res:Response) =>  <ShoppingItem[]>(res.json()));
       //return this.httpClient.get<ShoppingItem[]>('items');
       return this.httpClient.get<ShoppingItem[]>('http://localhost:3000/items');
     }

     addNewItem(shoppingItem: ShoppingItem){//: Observable<Response>{
        // let headers= new Headers();
        // headers.append('Content-Type','application/json');
        // return this.http.post('http://localhost:3000/item',shoppingItem)//,{headers:headers})
        // .map(res=>res.json()); 
       //return this.httpClient.post('item', shoppingItem);
       return this.httpClient.post('http://localhost:3000/item', shoppingItem);
     }
     
     updateItem(shoppingItem:ShoppingItem){//: Observable<Response>{
        // return this.http.put('http://localhost:3000/item',shoppingItem)
        // .map(res=>res.json());
       //return this.httpClient.put('item', shoppingItem);
       return this.httpClient.put('http://localhost:3000/item', shoppingItem);
     }

     deleteItem(id:string){//:Observable<Response>{
        // return this.http.delete('http://localhost:3000/item/'+ id)
        // .map(res=>res.json());    
       //return this.httpClient.delete('item/' + id);
       return this.httpClient.delete('http://localhost:3000/item/' + id);
     }
 }

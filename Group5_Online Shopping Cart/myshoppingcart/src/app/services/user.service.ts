import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { map } from "rxjs/operators";


@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }


  authenticateUser(email:string,password:string){
    let user={
      email:email,
      password:password
    };
    return this.http.post("http://192.168.1.94:8082/api/products/users/validate", user).pipe(
    map(user => {
                                if (user) {
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }
                return user;
            }));

  }

  create(user: User) {
    return this.http.post("http://192.168.1.94:8082/api/products/users/add", user);
  }

  // update(user: User) {
  //   return this.http.put(http://localhost:8082/api/products/users/update' + user.email, user);
  // }

  // delete(username: number) {
  //   return this.http.delete('http://localhost:8082/api/products/users/delete' + email)
  // }

}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient) { }
  getAll() {
    console.log("service: getall");
    return this.http.get('http://localhost:3000/Users');
  }

  create(user: User) {
    return this.http.post("http://localhost:3000/Users", user);
  }

  update(user: User) {
    return this.http.put('http://localhost:3000/Users/' + user.id, user);
  }

  delete(id: number) {
    return this.http.delete('http://localhost:3000/Users/' + id)
  }

}

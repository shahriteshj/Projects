import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get('http://localhost:3000/User');
  }

  authenticateUser(username:string,password:string){
    return this.http.get("http://localhost:3000/User?username="+username+"&password="+password);
    
  }

  create(user: User) {
    return this.http.post("http://localhost:3000/User", user);
  }

  update(user: User) {
    return this.http.put('http://localhost:3000/User/' + user.id, user);
  }

  delete(id: number) {
    return this.http.delete('http://localhost:3000/User/' + id)
  }

}

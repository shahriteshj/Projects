import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  users:User[];
  constructor(private _userService: UserService) { }

  ngOnInit() {
    this.getAllUsers();
    console.log(this.users);
  }

  getAllUsers() {
    return this._userService.getAll().subscribe(userList=>{this.users=<User[]>userList});
   //return this._userService.getAll().subscribe(_users=>{this._userService.getAll();});
  }

  Register(registerFrm) {
    let name = registerFrm.value.name;
    let username = registerFrm.value.username;
    let password = registerFrm.value.password;
    console.log(name);
    console.log(username);
    console.log(password);
    let user: User = {
      name: registerFrm.value.name,
      username: registerFrm.value.username, 
      password: registerFrm.value.password
    }
    console.log(user);
    this._userService.create(user).subscribe(_users=>{this._userService.getAll();});
    console.log(username);

  }

}

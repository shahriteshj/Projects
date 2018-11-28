import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { User } from '../model/user';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  users: User[];
  user:User;
  usersArr:Object[][];
  username:string;
  password:string;
  constructor(private _userService: UserService) { }

  ngOnInit() {
    this.getAllUsers();
    console.log(this.usersArr);
  }

  getAllUsers() {
   return this._userService.getAll().subscribe(usersList => { this.usersArr = <Object[][]>usersList; console.log(this.usersArr);});
     
  }



  Login(frm: NgForm) {
    this.username = frm.value.username;
    this.password = frm.value.password;
    console.log(this.username);
    this._userService.authenticateUser(this.username,this.password).subscribe(user=>{this.user=<User>user;});

    //this._userService.getAll().subscribe(users => { this.userList = <User[]>users });
  //users: User[];
  console.log(this.user);
    // for (let user1 of this.userList) {
    //   if (username == user1.username && password == user1.password) {
    //     this.router.navigate(['/menu']);
    //   } else {
    //     this.router.navigate(['/login']);
    //   }
    }





  }



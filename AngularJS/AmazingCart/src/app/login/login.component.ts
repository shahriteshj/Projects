import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { UserServiceService } from '../service/user-service.service';
import { User } from '../model/user';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  users: User[];
  constructor(private router: Router, private _userService: UserServiceService) { }

  ngOnInit() {
    this.getAllUsers();
    console.log(this.users);
  }

  getAllUsers() {
    return this._userService.getAll().subscribe(usersList => { this.users = <User[]>usersList; });
   //return this._userService.getAll().subscribe(_users=>{this._userService.getAll();});
  }



  Login(frm: NgForm) {
    let username = frm.value.username;
    let password = frm.value.password;
    console.log(username);

    //this._userService.getAll().subscribe(users => { this.userList = <User[]>users });
  //users: User[];
  console.log(this.users);
    // for (let user1 of this.userList) {
    //   if (username == user1.username && password == user1.password) {
    //     this.router.navigate(['/menu']);
    //   } else {
    //     this.router.navigate(['/login']);
    //   }
    }





  }



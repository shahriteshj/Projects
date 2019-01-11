import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { AlertService } from '../services/alert.service';
import { UserService } from '../services/user.service';
import { NgForm } from '@angular/forms';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loading = false;
  users: User[];
  user: User;
  email: string;
  password: string;
  constructor(private router: Router, private _userService: UserService,
    private alertService: AlertService, private cartService: CartService) { }

  ngOnInit() {
    localStorage.removeItem('currentUser');
  }


  Login(loginFrm: NgForm) {
    this.loading = true;
    this.email = loginFrm.value.email;
    this.password = loginFrm.value.password;
    this._userService.authenticateUser(this.email, this.password).subscribe(
      (data: any) => {
         console.log(data);
        let strUser = JSON.parse(localStorage.getItem('currentUser'));
        console.log(strUser);
        //!!localStorage.getItem('token');
        if (strUser != null) 
        {
          console.log("in if");
            localStorage.setItem('token', data.token);
           localStorage.setItem('email', data.email);
           localStorage.setItem('name', data.name);
          if (this.cartService.cart.length > 0) 
              {
               this.router.navigate(['/viewcart']);
             }
           else 
            {
            this.router.navigate(['/home']);
            }
        }
        else 
        {
          alert("Invalid Username password! Please try again");
          this.router.navigate(['/login']);
        }
  

      }
    )
  }



}

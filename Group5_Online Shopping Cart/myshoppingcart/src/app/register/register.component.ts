import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { AlertService } from '../services/alert.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  loading = false;
  users: User[];
  
  constructor(private router: Router, private _userService: UserService,
    private alertService: AlertService) { }

  ngOnInit() {
  }
  
  Register(registerFrm) {

    this.loading = true;
    let name = registerFrm.value.name;
    let mobile = registerFrm.value.mobile;
    let email = registerFrm.value.email;
    let password = registerFrm.value.password;
    
    console.log(name);
    console.log(password);
    console.log(email);
    console.log(mobile);

    let user: User = {
      name: registerFrm.value.name,
      mobile: registerFrm.value.mobile,
      email: registerFrm.value.email,
      password: registerFrm.value.password
    }
    console.log(user);
    this._userService.create(user)
      .subscribe(
        data => {
          this.alertService.success('Registration successful', true);
          this.router.navigate(['/login']);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        }
      );
  }
}

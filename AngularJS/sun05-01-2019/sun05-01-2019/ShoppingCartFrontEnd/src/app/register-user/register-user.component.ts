import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../services/dataService.service';
import { User } from '../model/user';

@Component({
    selector:'app-register-user',
    templateUrl:'./register-user.component.html',
    styleUrls:['./register-user.component.css']
})

export class RegisterUserComponent{
    user : User = {
        userName:null,
        password:null
    }
    constructor(private dataService: DataService, private router: Router){

    }

    register() {
        this.dataService.createUser(this.user)
            .subscribe(
                data => {
                    this.router.navigate(['/login']);
                },
                error => {
                    console.log(error);
                });
    }
}
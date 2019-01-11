import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserLoginService } from '../services/userLogin.service';
import { Router } from '@angular/router';
import { LocalStorageService } from 'ngx-webstorage';
import { SharedDataService } from '../services/sharedData.service';

@Component({
    selector:'app-login',
    templateUrl:'./login.component.html',
    styleUrls:['./login.component.css']
})

export class LoginComponent implements OnInit{
    constructor(private loginService: UserLoginService , 
        private _router: Router,
        private localStorage: LocalStorageService,
        private sharedDataService : SharedDataService) {

    }

    ngOnInit(){

    }
    
    onLogin(loginForm:NgForm):void{
        // let login=  
        this.loginService.Login(loginForm.value.userName, loginForm.value.passWord).subscribe(res =>{
            let isValid:Boolean = false;
            if(res.userName){
                this.sharedDataService.isUserLoggedIn = true;
                this.localStorage.store("user",res.userName.toLowerCase());
                if (res.userName.toLowerCase()=='admin') {
                    this.sharedDataService.isAdminUser = true;
                    isValid=true;
                    this._router.navigate(['/admin']);
                }
                else {
                    isValid=true;
                    this._router.navigate(['/user']);
                }
            }
            else {
                alert('LoginFailed....');
                this._router.navigate(['/']);
            }
            this.localStorage.store("valid",isValid);
        });

    }
}

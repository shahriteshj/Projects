import { Injectable } from '@angular/core';
import { LocalStorageService, LocalStorage } from 'ngx-webstorage';
import { User } from '../model/User';
import { DataService } from '../services/dataService.service';

@Injectable()

export class UserLoginService {
    @LocalStorage()
    public valid: boolean;
    private Users: User[] =[
        {userName:'admin', password:"admin"},
        {userName:'test', password:"test"}
    ];

    constructor(private localStorage: LocalStorageService, private dataService: DataService){
        
    }
    public Login(un: string, pwd: string){//: string {
        // let flag: string='notFound';
        // this.Users.forEach(element => {
        //     if (element.userName == un && element.password == pwd) {
        //         if(element.userName.toLowerCase()=='admin'){
        //             flag = 'admin';
        //             this.localStorage.store("user","admin");
        //         }
        //         else{
        //             flag = 'user'; 
        //             this.localStorage.store("user","user");               
        //         }
        //         this.valid= true;
        //     }
        // });
        return this.dataService.getUser({userName:un,password:pwd});
        // .subscribe(res =>{
        //     debugger;
        //     flag = res.userName;
        //     this.valid = true;
        //     this.localStorage.store("user",flag);    
        //     return flag;
        // });    
        // return flag;
    }

    public Register (u : string, p : string){
        
        this.Users.push({ 'userName': u, 'password': p });
        alert('User Registerd : ' + u)
    }
    public isValid () : boolean
    {
        // if(this.localStorage.retrieve("valid")){
        //     this.valid = this.localStorage.retrieve("valid");
        // }
        // this.localStorage.store("valid",this.valid);  
        // return  this.valid;
        return this.localStorage.retrieve("valid");
    }

}
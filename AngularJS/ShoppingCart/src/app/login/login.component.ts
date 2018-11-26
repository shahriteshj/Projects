import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserProfileServiceService } from '../service/user-profile-service.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  Login(frm:NgForm){
    let username=frm.value.username; 
    console.log(username);
    if(username=="admin"){
      sessionStorage.setItem("profile",'admin');
    }else{
      sessionStorage.setItem("profile",'normal');
      
    }     
  }

}

import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { AppComponent } from '../app.component';
//import { UserProfileServiceService } from '../service/user-profile-service.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  Login(frm:NgForm){
    let username=frm.value.username; 
    console.log(username);
    AppComponent.userLogged=true;

    localStorage.setItem('currentUser',username);
    
    this.router
    this.router.navigate(['/menu']);
      
   // if(username=="admin"){
      
 //     sessionStorage.setItem("profile",'admin');
   // }else{
 //     sessionStorage.setItem("profile",'normal');
      
    //}     
  }

}

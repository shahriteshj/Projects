import { Component, OnChanges, DoCheck } from '@angular/core';
import { LocalStorageService } from 'ngx-webstorage';
import { SharedDataService } from './services/sharedData.service';
import { Router } from  '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent{// implements DoCheck{
  title = 'app';
  // isUserLoggedIn : boolean;
  // isAdminUser: boolean;
  constructor( private sharedDataService : SharedDataService, private router : Router){//private localStore:LocalStorageService){
    
  }

  // ngDoCheck(){
  //   this.isUserLoggedIn =  (this.localStore.retrieve("valid")==null) ? false : this.localStore.retrieve("valid");
  //   this.isAdminUser =   (this.localStore.retrieve("user")== null) ? false : (<String>this.localStore.retrieve("user").toLowerCase()== 'admin' ? true: false);
  // }

  logout(){
    this.sharedDataService.clear();
    this.router.navigate(['/login']);
  }
}

import { Injectable} from '@angular/core';
import { LocalStorageService } from 'ngx-webstorage';

@Injectable()
export class SharedDataService{
    isAdminUser : boolean;
    isUserLoggedIn : boolean;
    noOfCartItems : number = 0;

    constructor(private localStorage: LocalStorageService){
        this.getStoredValues();
    }

    getStoredValues(){
        this.isUserLoggedIn =  (this.localStorage.retrieve("valid")==null) ? false : this.localStorage.retrieve("valid");
        this.isAdminUser =   (this.localStorage.retrieve("user")== null) ? false : (<String>this.localStorage.retrieve("user").toLowerCase()== 'admin' ? true: false);
    }

    clear(){
        this.isAdminUser = false;
        this.isUserLoggedIn = false;
        this.localStorage.clear();
    }
}
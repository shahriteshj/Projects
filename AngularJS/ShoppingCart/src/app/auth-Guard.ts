import { CanActivate } from '@angular/router';

export class AuthGuard implements CanActivate {
    canActivate() {
        console.log("authGuard");
        let profile = sessionStorage.getItem('profile');
        console.log(profile);
        if (profile == "admin") {

            return true;
        } else {
            return false;
        }


    }


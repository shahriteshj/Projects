import { Injectable } from '@angular/core';
import { Router} from '@angular/router';
import { routerNgProbeToken } from '@angular/router/src/router_module';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private router:Router) { }

  Login(username:String, passwd: String)
  {
    console.log(username +" "+ passwd);
    if (username==="a" && passwd==="a")
    {
        return "1234";
    }
    else
    {
      this.router.navigate(['/login']);
        
    }

  }
}

import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Emp } from '../viewmodels/emp.viewmodel';
import { AppSettings } from  '../app.module';
import { Profile } from '../viewmodels/profile.viewmodel';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }
  getEmployees(){
    return this.http.get(AppSettings.baseURL+"employees")
  }
  getEmpById(id:number):Observable<Emp>{
    return this.http.get<Emp>(AppSettings.baseURL +"emps/1")
  }
  getProfiles(){
    return this.http.get(AppSettings.baseURL+ "emps/listEmpProfile")
  }
  getProfileById(id:number):Observable<Profile>{
    return this.http.get<Profile>(AppSettings.baseURL +"emps/profile/1")
  }
}

import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './services/employee.service';
import { Emp } from './viewmodels/emp.viewmodel';
import { Profile } from './viewmodels/profile.viewmodel';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'testspringapp';
  constructor(private employeeService: EmployeeService) {
  }
  employees = [];
  profiles = [];
  getEmployeesFromService() {
    this.employeeService.getEmployees().subscribe((res: any) => {
      this.employees = res;
      console.log(this.employees);
    });
  }
  emp:Emp= null;
  getEmpByIdFromService() {
    this.employeeService.getEmpById(1).subscribe((res: any) => {
      this.emp = res;
      console.log(this.emp);
    })
  }
  pfl:Profile=null;
  getProfileByIdFromService(){
    this.employeeService.getProfileById(1).subscribe((res:any)=> {
      this.pfl = res;
      console.log(this.pfl);
    })
  }

  getProfilesFromService(){
    this.employeeService.getProfiles().subscribe((res:any)=>{
      this.profiles = res;
      console.log("App Service : "+this.profiles);
    })
  }

  ngOnInit() {
    this.getEmployeesFromService();
    this.getEmpByIdFromService();
    this.getProfileByIdFromService();
    this.getProfilesFromService();
  }
}

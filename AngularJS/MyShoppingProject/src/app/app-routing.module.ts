import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EmployeeInfoComponent } from './employee-info/employee-info.component';
import { EmployeeComponent } from './employee/employee.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { EmplistserviceComponent } from './emplistservice/emplistservice.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { HttpServiceComponent } from './http-service/http-service.component';



const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'employeeslist', component: EmployeeInfoComponent },
  { path: 'employees', component: EmployeeComponent },
  { path: 'employeeservice', component: EmplistserviceComponent },
  { path: 'app-create-employee', component: CreateEmployeeComponent },
  { path: 'app-http-service', component: HttpServiceComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Emp } from '../model/emp';

const httpOptions = {
  headers: new HttpHeaders({ 
    'Access-Control-Allow-Origin':'*',
    'Access-Control-Allow-Headers':'X-Requested-With, Content-Type, Accept, Origin, Authorization',
    'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS',
    'Access-Control-Allow-Credentials': 'true' 
  })
};

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private http: HttpClient) {

  }

  getEmployeeList() {
    console.log(httpOptions);
    return this.http.get('/Spring300_MVC_JPA_Rest_Ng/hr/emps',httpOptions);
  }

  addNewEmployee(emp: Emp) {
    console.log(emp);
    return this.http.post("/Spring300_MVC_JPA_Rest_Ng/hr/empCreate", emp);

  }

  updateEmployeeDetails(emp: Emp) {
    return this.http.put('/Spring300_MVC_JPA_Rest_Ng/hr/emps' + emp.empId, emp,httpOptions);

  }

  deleteEmployee(empId) {
    return this.http.delete('/Spring300_MVC_JPA_Rest_Ng/hr/emps/' + empId,httpOptions)

  }


}

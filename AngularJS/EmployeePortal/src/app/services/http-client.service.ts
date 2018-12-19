import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Emp } from '../model/emp';

const httpOptions = {
  headers: new HttpHeaders({ 
    'Access-Control-Allow-Origin':'http://localhost:8080/',
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
    return this.http.get('http://localhost:8080/Spring300_MVC_JPA_Rest_Ng/hr/emps',httpOptions);
  }

  addNewEmployee(emp: Emp) {
    return this.http.post("http://localhost:8080/Spring300_MVC_JPA_Rest_Ng/hr/create", emp,httpOptions);

  }

  updateEmployeeDetails(emp: Emp) {
    return this.http.put('http://localhost:8080/Spring300_MVC_JPA_Rest_Ng/hr/' + emp.empId, emp,httpOptions);

  }

  deleteEmployee(empId) {
    return this.http.delete('http://localhost:8080/Spring300_MVC_JPA_Rest_Ng/hr/' + empId,httpOptions)

  }


}

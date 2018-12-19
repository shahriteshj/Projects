import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../services/http-client.service';
import { Emp } from '../model/emp';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-emp-service',
  templateUrl: './emp-service.component.html',
  styleUrls: ['./emp-service.component.css']
})
export class EmpServiceComponent implements OnInit {
  emp: Emp[];
  toggleForm: Boolean = false;
  selectedEmp: Emp;


  constructor(private httpclientservice: HttpClientService) { }

  ngOnInit() {
    this.getEmpList();

  }

  getEmpList() {
    return this.httpclientservice.getEmployeeList().subscribe(emp => { this.emp = <Emp[]>emp; });
  }

  setItems(emp: Emp) {
    //this.httpclientservice.setItem(post).subscribe(post=>{console.log(post);this.getitems();});
  }

  SaveEmployee(frm: NgForm): void {

    let emp: Emp = {
      empId: Number(frm.value.empId),
      firstName: frm.value.firstName,
      lastName: frm.value.lastName
    }

    this.httpclientservice.addNewEmployee(emp).subscribe(emp => { this.emp = <Emp[]>emp;})

  }


  EditEmployee(editfrm: NgForm) {
    let newEmp: Emp = {
      empId: Number(this.selectedEmp.empId),
      firstName: editfrm.value.firstName,
      lastName: editfrm.value.lastName,

    }
    this.httpclientservice.updateEmployeeDetails(newEmp)

      .subscribe(result => {
        console.log('original Emp to be updated with new values' + result);
        this.getEmpList;
        this.toggleForm = !this.toggleForm;
      })

  }


  showEditform(emp) {
    this.selectedEmp = emp;
    this.toggleForm = true;
  }

  showAddForm() {
    this.toggleForm = false;
  }

  deleteEmployee(empId) {
    this.httpclientservice.deleteEmployee(empId)
      .subscribe(result => {
        console.log(result);

        for (var i = 0; i < this.emp.length; i++) {
          if (empId == this.emp[i].empId) {
            this.emp.splice(i, 1);



          }

        }
      })
  }


}

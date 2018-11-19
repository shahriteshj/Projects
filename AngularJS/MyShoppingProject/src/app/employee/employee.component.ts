import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  fname="John";
  lname="Smith";
  gender="Male";
  age=30;
  constructor() { }

  displayFullName():string{
      return this.fname+ " " + this.lname;
  }

  ngOnInit() {
  }

}

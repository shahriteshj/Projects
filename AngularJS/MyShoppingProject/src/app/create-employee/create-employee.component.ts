import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  defName;
  defEmail;
  defContact;
  constructor() { }

  ngOnInit() {
    
  }

  SaveEmployee(frm:NgForm): void{
   
    console.log(frm.value);

  }

}

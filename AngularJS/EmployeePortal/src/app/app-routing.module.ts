import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpServiceComponent } from './emp-service/emp-service.component';

const routes: Routes = [ { path: '', component: EmpServiceComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

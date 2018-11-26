import { NgModule } from '@angular/core';
import { Routes, RouterModule, CanActivate } from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { RegisterComponent } from './register/register.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ShoppingItemComponent } from './shopping-item/shopping-item.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { LogOutComponent } from './log-out/log-out.component';
import { AuthGuard } from './auth-Guard';;

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'productlist', component: ProductListComponent, canActivate: [AuthGuard] },
  { path: 'shoppingitem', component: ShoppingItemComponent, canActivate: [AuthGuard] },
  { path: 'shoppingcart', component: ShoppingCartComponent },
  { path: 'logout', component: LogOutComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ShoppingitemComponent } from './shoppingitem/shoppingitem.component';
import { ProductlistComponent } from './productlist/productlist.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LogoutComponent } from './logout/logout.component';
import { Routes, RouterModule } from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { FormsModule } from '@angular/forms';
import { CarouselModule } from 'ngx-bootstrap';
import { HttpClient } from 'selenium-webdriver/http';
import { HttpClientModule } from '@angular/common/http';
import { ProductbycategoryComponent } from './productbycategory/productbycategory.component';
import { LoginService } from './services/login.service';
import { CartService } from './services/cart.service';
import { CartComponent } from './cart/cart.component';
import { OrderComponent } from './order/order.component';
import { PaymentComponent } from './payment/payment.component';
import { AuthService } from './services/auth.service';
const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'about', component: AboutComponent},
  {path: 'items', component: ShoppingitemComponent},
  {path: 'productlist', component: ProductlistComponent},
  {path: 'productbycategory', component: ProductbycategoryComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'ordersummary', component: OrderComponent},
  {path: 'viewcart', component: CartComponent},
  {path: 'paymentgateway', component: PaymentComponent},
  {path: 'logout', component: LogoutComponent},
  {path: '', redirectTo:'/home', pathMatch: 'full'},
  {path:'**', component: PageNotFoundComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ShoppingitemComponent,
    ProductlistComponent,
    AboutComponent,
    LoginComponent,
    RegisterComponent,
    LogoutComponent,
    PageNotFoundComponent,
    ProductbycategoryComponent,
    CartComponent,
    OrderComponent,
    PaymentComponent
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    CarouselModule.forRoot(),
    HttpClientModule
  ],
  providers: [LoginService, CartService,AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }

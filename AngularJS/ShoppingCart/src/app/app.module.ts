import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { StorageServiceModule } from 'angular-webstorage-service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ShoppingItemComponent } from './shopping-item/shopping-item.component';
import { ProductListComponent } from './product-list/product-list.component';
import { RegisterComponent } from './register/register.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { LogOutComponent } from './log-out/log-out.component';
import {AuthGuard} from './auth-Guard';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    LoginComponent,
    HomeComponent,
    AboutComponent,
    ShoppingItemComponent,
    ProductListComponent,
    RegisterComponent,
    ShoppingCartComponent,
    LogOutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    StorageServiceModule ,
    AppRoutingModule
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }

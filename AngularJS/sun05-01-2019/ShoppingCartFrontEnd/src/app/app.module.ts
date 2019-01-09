import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { Ng2Webstorage } from 'ngx-webstorage';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ShoppingItemComponent } from './shopping-item/shopping-item.component';
import { DataService } from './services/dataService.service';
import { ShoppingItemRComponent } from './shopping-item-r/shopping-item-r.component';
import { RoutingModule } from './routingModule';
import { NotFoundComponent } from './notFound/notFound.component';
import { UserLoginService } from './services/userLogin.service';
import { LoginRouteGuard } from './services/loginGuard.service';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UserCartComponent } from './user-cart/user-cart.component';
import { CartService } from './services/cart.service';
import { SharedDataService } from './services/sharedData.service';
import { ShoppingCartViewComponent } from './shopping-cart-view/shopping-cart-view.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ShoppingItemComponent,
    ShoppingItemRComponent,
    NotFoundComponent,
    RegisterUserComponent,
    UserCartComponent,
    ShoppingCartViewComponent
  ],
  imports: [
    // HttpModule,
    BrowserModule,
    FormsModule,
    RoutingModule,
    Ng2Webstorage,
    HttpClientModule
  ],
  providers: [ 
    DataService, 
    UserLoginService,
    LoginRouteGuard,
    CartService,
    SharedDataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

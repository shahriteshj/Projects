import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';


import { MenuRoutingModule } from './menu-routing.module';
import { LogOutComponent } from './log-out/log-out.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { ShoppingItemComponent } from './shopping-item/shopping-item.component';
import { ProductListComponent } from './product-list/product-list.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { MenuComponent } from './menu.component';



@NgModule({
  declarations: [
    LogOutComponent,
    MenuComponent,
    ShoppingCartComponent,
    ShoppingItemComponent,
    ProductListComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    MenuRoutingModule
  ],
  providers: [],
  bootstrap: [MenuComponent]
})
export class MenuModule { }

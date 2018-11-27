import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LogOutComponent } from 'src/menu/log-out/log-out.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ShoppingItemComponent } from './shopping-item/shopping-item.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { MenuComponent } from './menu.component';

const routes: Routes = [
  { path: 'menu', component: MenuComponent },
  { path: 'logout', component: LogOutComponent },
  { path: 'productlist', component: ProductListComponent, },
  { path: 'shoppingitem', component: ShoppingItemComponent,},
  { path: 'shoppingcart', component: ShoppingCartComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MenuRoutingModule { }

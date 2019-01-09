import { NgModule } from '@angular/core';
import { RouterModule, Routes , RouterLinkActive, CanActivate } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ShoppingItemComponent } from './shopping-item/shopping-item.component';
import { ShoppingItemRComponent } from './shopping-item-r/shopping-item-r.component';
import { NotFoundComponent } from './notFound/notFound.component';
import { LoginRouteGuard } from './services/loginGuard.service';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UserCartComponent } from './user-cart/user-cart.component';

const routes: Routes = [
    {path :'', redirectTo :'/login', pathMatch:'full'},
    {path :'login', component:LoginComponent},
    {path :'register', component : RegisterUserComponent },
    {path :'admin', component : ShoppingItemComponent, canActivate: [ LoginRouteGuard ] },
    {path :'user', component : ShoppingItemRComponent, canActivate: [ LoginRouteGuard ] },
    {path :'cart', component : UserCartComponent, canActivate: [ LoginRouteGuard ]},
    {path : '**', component : NotFoundComponent}
];

@NgModule({
    imports:[ RouterModule.forRoot(routes)],
    exports:[ RouterModule ]
})

export class RoutingModule {

}
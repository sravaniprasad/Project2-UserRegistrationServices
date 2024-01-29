import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { TitleComponent } from './title/title.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CheckStatusComponent } from './check-status/check-status.component';

const routes: Routes = [
  {redirectTo:'login',path:'login', pathMatch:'full'},
  {
    path:'signup', component:SignupComponent
  },
  {
    path:'dashboard', component:DashboardComponent
  },
  {
    path:'registered', component:TitleComponent
  },
  {
    path:'status',component:CheckStatusComponent
  },
  {
    path:'logout', component:LogoutComponent
  },
  {
    path:'login', component:SigninComponent
  },
  {
    path:'home',component:HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

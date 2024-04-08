import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import {CreatePostComponent} from "./create-post/create-post.component";

export const routes: Routes = [ { path: 'login', component: LoginComponent },
  { path: 'create', component: CreatePostComponent },
{ path: 'register', component: RegisterComponent },];

import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import {CreatePostComponent} from "./create-post/create-post.component";
import {MainFeedComponent} from "./main-feed/main-feed.component";
import {LandingpageComponent} from "./landingpage/landingpage.component";

export const routes: Routes = [ { path: 'login', component: LoginComponent },
  { path: 'create', component: CreatePostComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  {path: 'main',component: MainFeedComponent},
  {path: 'landing',component: LandingpageComponent},
  { path: "**", component: LoginComponent },];

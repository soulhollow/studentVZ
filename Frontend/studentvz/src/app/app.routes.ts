import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CreatePostComponent } from "./create-post/create-post.component";
import { ChatComponent } from './main-feed/main-feed.component'; // Fix: Import the correct component from the correct file path

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'create', component: CreatePostComponent },
  { path: 'main', component: ChatComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  { path: "**", component: LoginComponent },
];

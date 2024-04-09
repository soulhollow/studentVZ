import { Component } from '@angular/core';
import {LoginService} from "./login.service";
import {Router} from "@angular/router";
// @ts-ignore
//import { FormControl,FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
 // email = new FormControl('', {nonNullable: true, validators: [Validators.required, Validators.email]});
 // hide = true;
  //password = new FormControl('', {nonNullable: true, validators: [Validators.required]});

  constructor(private router: Router, private loginService: LoginService) {
  }


login(){
   this.loginService.login()

}
}

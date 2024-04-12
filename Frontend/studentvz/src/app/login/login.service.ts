import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginComponent } from './login.component';
import { Router } from '@angular/router';
import { CreatePostComponent } from '../create-post/create-post.component';

@Injectable({
  providedIn: 'root'
})
export class LoginService{

  constructor(private http: HttpClient, private router: Router) { }

  login() {
    console.log("Checkpoint 0")
    const emailInput = document.getElementById("email") as HTMLInputElement;
    const passwordInput = document.getElementById("password") as HTMLInputElement;

    const password = passwordInput.value;
    const email = emailInput.value;
    const userData = {
      "email": email,
      "password": password
    }
    console.log("Checkpoint -1")

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    this.http.post('http://localhost:8080/api/users/login', userData, { headers: headers })
      .subscribe(response => {
        console.log(response);
        if (response === true) {
          this.router.navigate(["\create"]);
        }
      }, error => {
        console.error(error);
      });
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginComponent } from '../login/login.component';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient, private router: Router) { }

  register(email: string, password: string): void {
    const userData = {
      "email": email,
      "password": password
    };

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    this.http.post('http://localhost:8080/api/users/register', userData, { headers: headers })
      .subscribe(response => {
        console.log(response);
        if (response === true) {
          this.router.navigate(["\login"]);
        }
      }, error => {
        console.error(error);
      });
  }
}

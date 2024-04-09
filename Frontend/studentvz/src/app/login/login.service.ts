import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() {
  }

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
     const x = fetch('http://localhost:8080/api/users/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },

      body: JSON.stringify(userData)
    })
    console.log(x + " test")
  }
}

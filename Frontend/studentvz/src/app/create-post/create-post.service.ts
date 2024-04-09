import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class CreatePostService {

  constructor(private http: HttpClient) {
  }


  handleSubmit() {

    const headerInput = document.getElementById("header") as HTMLInputElement;
    const contentInput = document.getElementById("content") as HTMLInputElement;

    const headerValue = headerInput.value;
    const contentValue = contentInput.value;

    // Erstelle das Datenobjekt, das an das Backend gesendet werden soll
    const messageData = {
      content: contentValue,
      header: headerValue,
      user: {
        "id": 1,
        "username": "test",
        "password": "test",
        "email": "test@test"
      }

    }

    fetch('http://localhost:8080/api/messages/post', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },

      body: JSON.stringify(messageData)
    })
  }
}


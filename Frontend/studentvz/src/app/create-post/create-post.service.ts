import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CreatePostService {

  constructor(private http: HttpClient) {}

  handleSubmit() {
    const headerInput = document.getElementById("header") as HTMLInputElement;
    const contentInput = document.getElementById("content") as HTMLInputElement;

    const headerValue = headerInput.value;
    const contentValue = contentInput.value;

    const messageData = {
      content: contentValue,
      header: headerValue,
      user: {
        "id": 1,
        "username": "test",
        "password": "test",
        "email": "test@test"
      }
    };

    this.http.post('http://localhost:8080/api/messages/post', messageData)
      .subscribe(response => {
        console.log('Post erfolgreich erstellt:', response);
      }, error => {
        console.error('Fehler beim Erstellen des Posts:', error);
      });
  }
}

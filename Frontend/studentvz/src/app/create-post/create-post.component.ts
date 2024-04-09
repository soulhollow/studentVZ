import { Component } from '@angular/core';
import {provideHttpClient} from "@angular/common/http";

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent {

}
function handleSubmit(event: Event) {
  event.preventDefault();

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
  console.log(messageData);
  // Sende die Daten an das Backend
  fetch('localhost:8080/api/messages/post', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },

    body: JSON.stringify(messageData)
  })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      // Hier kannst du mit der Antwort vom Server weiterarbeiten
      console.log('Response from server:', data);
      // Optional: Zurücksetzen der Eingabefelder nach dem Absenden des Formulars
      headerInput.value = "";
      contentInput.value = "";
    })
    .catch(error => {
      console.error('Error:', error);
    });
}


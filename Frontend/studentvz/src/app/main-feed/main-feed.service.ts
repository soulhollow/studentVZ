import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class MainFeedService {

  constructor(private http: HttpClient, private router: Router) { }
  reload(){
    console.log("Main Feed Service");
    
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    this.http.get<Message[]>('http://localhost:8080/api/messages/all', { headers: headers })
      .subscribe(response => {
        console.log(response);
        // Process the response here
        // Assuming Message is the interface representing the message structure
        // You can replace it with your actual interface or type
        response.forEach((message: Message) => {
          console.log('ID:', message.id);
          console.log('Header:', message.header);
          console.log('Content:', message.content);
          console.log('Timestamp:', message.timestamp);
          console.log('user_ID:', message.userId);
        });
      }, error => {
        console.error(error);
      });
  }
}

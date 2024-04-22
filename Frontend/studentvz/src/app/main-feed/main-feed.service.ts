import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MainFeedService {
  constructor(private http: HttpClient, private router: Router) { }

  getMessages(): Observable<Message[]> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<Message[]>('http://localhost:8080/api/messages/all', { headers: headers });
  }
}

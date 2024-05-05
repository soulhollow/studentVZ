import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Message } from '../message';
import { Observable, map, tap } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class MainFeedService {
  constructor(private http: HttpClient, private router: Router) { }

  meassages: Message[]= [];

  getMessages(): Observable<Message[]>{
    return this.http.get<Message[]>('http://localhost:8080/api/messages/all').pipe(map(res=> res.map (value  => ({
    id: value.id,
    header: value.header,
    content: value.content,
    timestamp: value.timestamp,
    email: value.email,
  } as Message))));
  }
}

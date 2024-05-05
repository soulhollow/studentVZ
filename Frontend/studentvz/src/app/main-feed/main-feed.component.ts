import { CUSTOM_ELEMENTS_SCHEMA, Component, OnInit } from '@angular/core';
import { MainFeedService } from './main-feed.service';
import { Observable, tap } from 'rxjs';
import { Message } from '../message';
import { NgFor } from '@angular/common';



@Component({
  selector: 'app-chat-component',
  standalone: true,
  templateUrl: './main-feed.component.html',
  styleUrls: ['./main-feed.component.css'],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  imports: [NgFor]
})
export class ChatComponent implements OnInit {
  messages: Message[] = [];

  constructor(private mainFeedService: MainFeedService) { }

  ngOnInit(): void {
    this.reload();
  }
  

  reload() {
    this.mainFeedService.getMessages().subscribe(data => {console.log(data); data = this.messages;});
    console.log(this.messages);
  }
}

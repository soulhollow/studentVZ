import { Component, OnInit } from '@angular/core';
import { MainFeedService } from './main-feed.service';


@Component({
  selector: 'app-chat-component',
  templateUrl: './main-feed.component.html',
  styleUrls: ['./main-feed.component.css']
})
export class ChatComponent implements OnInit {
  messages: Message[] = [];

  constructor(private mainFeedService: MainFeedService) { }

  ngOnInit(): void {
    this.loadMessages();
  }

  loadMessages(): void {
    this.mainFeedService.reload();
  }
}

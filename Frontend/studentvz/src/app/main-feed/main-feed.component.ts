import { Component, OnInit } from '@angular/core';
import { MainFeedService } from './main-feed.service';
import { tap } from 'rxjs';



@Component({
  selector: 'app-chat-component',

  templateUrl: './main-feed.component.html',
  styleUrls: ['./main-feed.component.css'],
  imports: [Message]
})
export class ChatComponent implements OnInit {
  messages: Message[] = [];

  constructor(private mainFeedService: MainFeedService) { }

  ngOnInit(): void {
    this.reload();
  }

  reload() {
    console.log("Relouding...");
    this.mainFeedService.getMessages().pipe(tap({next: (messages: Message[]) => {this.messages = messages}}))
  }
}

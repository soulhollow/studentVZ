import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MainFeedService } from './main-feed.service';

@Component({
  selector: 'app-main-feed',
  standalone: true,
  imports: [],
  templateUrl: './main-feed.component.html',
  styleUrl: './main-feed.component.css'
})
export class MainFeedComponent {
  constructor(private router: Router, mainFeedService: MainFeedService) {
  }
  reload() {
    console.log("Relouding...");
    this.mainFeedService.reload();
  }
}

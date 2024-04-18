import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreatePostComponent } from './create-post/create-post.component';
import { NbChatModule } from '@nebular/theme'; // Import the NbChatModule from the appropriate package



@NgModule({
  declarations: [
    CreatePostComponent
  ],
  imports: [
    CommonModule,
    NbChatModule,
  ]
})
export class AppModule { }

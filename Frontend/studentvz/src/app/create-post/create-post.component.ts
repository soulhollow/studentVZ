import { Component } from '@angular/core';
import {HttpClient,HttpParams, provideHttpClient, HttpHeaders} from "@angular/common/http";
// @ts-ignore
import { HttpErrorHandler, HandleError } from '../http-error-handler.service';
import {CreatePostService} from "./create-post.service";
//import * as http from "http";

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})

export class CreatePostComponent {
  constructor(private createpost: CreatePostService) {
  }
  handleSubmitcomp() {
   // event.preventDefault();

    this.createpost.handleSubmit();

  }
}







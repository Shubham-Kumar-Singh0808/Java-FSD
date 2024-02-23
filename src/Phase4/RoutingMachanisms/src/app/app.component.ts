import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  constructor(private formBuilder: FormBuilder) { }

  title = 'angCare';
  status = 'You haven\'t signed up yet';
  name = '';

  ngOnInit() {
  }

  ontyping(event: Event) {
    this.name = (event.target as HTMLInputElement).value;
  }

  signup() {
    this.status = 'Oops! We are working on it!';
  }
}

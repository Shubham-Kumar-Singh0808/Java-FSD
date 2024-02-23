import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  registerForm!: FormGroup;
  submitted = false;
  loading = false;
  name: string = ''; // Define the 'name' property
  title: string = ''; // Define the 'title' property
  status: string = ''; // Define the 'status' property

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  // Convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;

    // Stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    // Display form values on successful submission
    console.log('Form Submitted!', this.registerForm.value);

    // Show user details in the alert message
    alert(`
      Registration successful!
      Name: ${this.registerForm.value.firstName} ${this.registerForm.value.lastName}
      Email: ${this.registerForm.value.email}
    `);

    // Simulate API call for registration (loading state)
    this.loading = true;
    setTimeout(() => {
      alert('Registration successful!'); // Replace with your actual API call
      this.loading = false;
    }, 2000); // Simulating 2 seconds of loading time
  }

  // Define the 'ontyping' method
  ontyping(event: any) {
    this.name = event.target.value;
  }

  // Define the 'signup' method
 signup() {
    const firstName = this.registerForm.value.firstName;
    const lastName = this.registerForm.value.lastName;
    const email = this.registerForm.value.email;
    const password = this.registerForm.value.password;
  
    const message = `
      First Name: ${firstName}\n
      Last Name: ${lastName}\n
      Email: ${email}\n
      Password: ${password}
    `;
  
    alert('User Details:\n\n' + message);
  }
}

import { Component, OnInit} from '@angular/core';
import { SignupService } from '../signup.service';
@Component({
  selector: 'app-title',
  templateUrl: './title.component.html',
  styleUrls: ['./title.component.css']
})
export class TitleComponent {
constructor(private signupService:SignupService){}
successMessage: string | null = null;
ngOnInit(): void {
  this.signupService.getSuccessMessage().subscribe((message) => {
    this.successMessage = message;
    setTimeout(() => {
      this.successMessage = null;
    }, 5000); // Hide the message after 5 seconds
  });
  
}
onRegister(): void {
  this.signupService.setSuccessMessage('You have successfully registered!');
}

}

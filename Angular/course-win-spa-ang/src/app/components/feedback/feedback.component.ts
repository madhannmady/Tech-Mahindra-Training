import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LocalStorageService } from '../../services/local-storage.service';
import { Feedback } from '../../models/feedback.model';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css'],
})
export class FeedbackComponent {
  feedbackForm: FormGroup;
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private localStorageService: LocalStorageService
  ) {
    this.feedbackForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(2)]],
      email: ['', [Validators.required, Validators.email]],
      rating: [5, [Validators.required, Validators.min(1), Validators.max(5)]],
      comments: ['', [Validators.required, Validators.minLength(10)]],
    });
  }

  onSubmit() {
    if (this.feedbackForm.valid) {
      const feedback: Feedback = {
        id: Date.now(),
        name: this.feedbackForm.value.name,
        email: this.feedbackForm.value.email,
        rating: this.feedbackForm.value.rating,
        comments: this.feedbackForm.value.comments,
        date: new Date().toISOString(),
      };

      this.localStorageService.addFeedback(feedback);
      this.submitted = true;
      this.feedbackForm.reset();
      setTimeout(() => (this.submitted = false), 3000);
    }
  }
}

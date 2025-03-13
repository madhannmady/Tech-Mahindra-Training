import { Injectable } from '@angular/core';
import { Feedback } from '../models/feedback.model';

@Injectable({
  providedIn: 'root',
})
export class LocalStorageService {
  private feedbackKey = 'courseWinFeedback';

  getFeedbacks(): Feedback[] {
    const feedbacks = localStorage.getItem(this.feedbackKey);
    return feedbacks ? JSON.parse(feedbacks) : [];
  }

  addFeedback(feedback: Feedback) {
    const feedbacks = this.getFeedbacks();
    feedbacks.push(feedback);
    localStorage.setItem(this.feedbackKey, JSON.stringify(feedbacks));
  }
}

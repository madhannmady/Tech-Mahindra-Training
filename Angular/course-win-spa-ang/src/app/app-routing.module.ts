import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseListComponent } from './components/course-list/course-list.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { PlansPricingComponent } from './components/plans-pricing/plans-pricing.component';
import { BestSellingComponent } from './components/best-selling/best-selling.component';
import { FeedbackComponent } from './components/feedback/feedback.component';

const routes: Routes = [
  { path: '', component: CourseListComponent },
  { path: 'about-us', component: AboutUsComponent },
  { path: 'plans-pricing', component: PlansPricingComponent },
  { path: 'best-selling', component: BestSellingComponent },
  { path: 'feedback', component: FeedbackComponent },
  { path: 'courses', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

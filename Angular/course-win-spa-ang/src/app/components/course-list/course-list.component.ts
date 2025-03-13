import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css'],
})
export class CourseListComponent implements OnInit {
  courses: Course[] = [];
  filterForm: FormGroup;
  categories: string[] = ['Game Design', 'Programming', 'Art', 'Sound Design'];

  constructor(private courseService: CourseService, private fb: FormBuilder) {
    this.filterForm = this.fb.group({
      category: [''],
      minPrice: [0],
      maxPrice: [1000],
      searchTerm: [''],
    });
  }

  ngOnInit() {
    this.courseService.getCourses().subscribe((data) => {
      this.courses = data.filter((course) => !course.bestseller); // Exclude bestsellers from explore
    });
  }
}

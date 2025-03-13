import { Pipe, PipeTransform } from '@angular/core';
import { Course } from '../models/course.model';

@Pipe({
  name: 'filterCourse',
})
export class FilterCoursePipe implements PipeTransform {
  transform(courses: Course[], filter: any): Course[] {
    if (!courses || !filter) return courses;

    return courses.filter((course) => {
      const matchesCategory = filter.category
        ? course.category === filter.category
        : true;
      const matchesPrice =
        course.price >= (filter.minPrice || 0) &&
        course.price <= (filter.maxPrice || Infinity);
      const matchesSearch = filter.searchTerm
        ? course.title
            .toLowerCase()
            .includes(filter.searchTerm.toLowerCase()) ||
          course.description
            .toLowerCase()
            .includes(filter.searchTerm.toLowerCase())
        : true;
      const matchesBestseller = filter.bestseller ? course.bestseller : true;

      return (
        matchesCategory && matchesPrice && matchesSearch && matchesBestseller
      );
    });
  }
}

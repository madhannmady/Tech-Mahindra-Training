import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'projectStatusFilter',
})
export class ProjectStatusFilterPipe implements PipeTransform {
  transform(projects: any[], selectedStatus: string): any[] {
    if (!projects || !selectedStatus || selectedStatus === 'All') {
      return projects;
    }
    return projects.filter((project) => project.status === selectedStatus);
  }
}

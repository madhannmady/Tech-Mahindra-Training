import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'projectStatusFilter'
})
export class ProjectStatusPipe implements PipeTransform {

  transform(projects: any[], status: string): any[] {
    if (!projects || !status) return projects;
    return projects.filter(project => project.status.toLowerCase() === status.toLowerCase());
  }

}

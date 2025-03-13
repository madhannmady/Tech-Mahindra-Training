import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'teamSizeFilter',
})
export class TeamSizeFilterPipe implements PipeTransform {
  transform(projects: any[], minSize: number, maxSize: number): any[] {
    if (!projects || minSize === undefined || maxSize === undefined) {
      return projects;
    }
    return projects.filter(
      (project) => project.teamSize >= minSize && project.teamSize <= maxSize
    );
  }
}

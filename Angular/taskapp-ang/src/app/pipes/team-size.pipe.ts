import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'teamSizeFilter'
})
export class TeamSizePipe implements PipeTransform {

  transform(projects: any[], minSize: number, maxSize: number): any[] {
    if (!projects || projects.length === 0) return [];
    return projects.filter(project => project.teamSize >= minSize && project.teamSize <= maxSize);
  }

}

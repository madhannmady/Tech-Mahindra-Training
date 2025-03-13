import { Component } from '@angular/core';
import { Input } from '@angular/core';
import { project } from '../../../model/project';

@Component({
  selector: 'app-project-card',
  templateUrl: './project-card.component.html',
  styleUrl: './project-card.component.css',
})
export class ProjectCardComponent {
  @Input() project: project = {
    id: '',
    name: '',
    description: '',
    startDate: new Date(),
    endDate: new Date(),
    status: '',
    image: '',
    teamSize: 0,
  };
}

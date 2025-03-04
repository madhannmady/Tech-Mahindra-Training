import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css'],
})
export class ChildC {
  @Input() childItems: string[] = [];
  @Output() itemMovedToParent = new EventEmitter<string>();

  moveItemToParent(item: string) {
    this.itemMovedToParent.emit(item);
  }
}

import { Component } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css'],
})
export class ParentC {
  parentItems: string[] = ['TV', 'CD', 'Laptop'];
  childItems: string[] = [];

  moveToChild(item: string) {
    this.parentItems = this.parentItems.filter((i) => i !== item);
    this.childItems.push(item);
  }

  moveToParent(item: string) {
    this.childItems = this.childItems.filter((i) => i !== item);
    this.parentItems.push(item);
  }
}

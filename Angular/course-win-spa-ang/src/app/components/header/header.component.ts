import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  navItems = [
    { name: 'Courses', path: '/courses' },
    { name: 'Best Selling', path: '/best-selling' },
    { name: 'About Us', path: '/about-us' },
    { name: 'Plans & Pricing', path: '/plans-pricing' },
    { name: 'Feedback', path: '/feedback' },
  ];
}

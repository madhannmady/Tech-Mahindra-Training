import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildC } from './child.component';

describe('ChildC', () => {
  let component: ChildC;
  let fixture: ComponentFixture<ChildC>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ChildC],
    }).compileComponents();

    fixture = TestBed.createComponent(ChildC);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

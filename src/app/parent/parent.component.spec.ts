import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParentC } from './parent.component';

describe('ParentC', () => {
  let component: ParentC;
  let fixture: ComponentFixture<ParentC>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ParentC],
    }).compileComponents();

    fixture = TestBed.createComponent(ParentC);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

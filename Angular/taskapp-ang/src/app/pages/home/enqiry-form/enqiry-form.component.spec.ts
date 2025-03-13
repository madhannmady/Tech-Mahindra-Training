import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnqiryFormComponent } from './enqiry-form.component';

describe('EnqiryFormComponent', () => {
  let component: EnqiryFormComponent;
  let fixture: ComponentFixture<EnqiryFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EnqiryFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EnqiryFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

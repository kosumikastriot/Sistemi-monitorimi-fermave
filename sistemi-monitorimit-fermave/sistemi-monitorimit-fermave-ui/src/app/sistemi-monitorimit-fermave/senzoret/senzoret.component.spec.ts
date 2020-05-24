import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SenzoretComponent } from './senzoret.component';

describe('SimplePageComponent', () => {
  let component: SenzoretComponent;
  let fixture: ComponentFixture<SenzoretComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SenzoretComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SenzoretComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

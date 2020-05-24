import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SimulimiComponent } from './simulimi.component';

describe('SimplePageComponent', () => {
  let component: SimulimiComponent;
  let fixture: ComponentFixture<SimulimiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SimulimiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SimulimiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

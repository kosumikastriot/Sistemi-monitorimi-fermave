import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PajisjetComponent } from './pajisjet.component';

describe('SimplePageComponent', () => {
  let component: PajisjetComponent;
  let fixture: ComponentFixture<PajisjetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PajisjetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PajisjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KonfigurimetComponent } from './konfigurimet.component';

describe('SimplePageComponent', () => {
  let component: KonfigurimetComponent;
  let fixture: ComponentFixture<KonfigurimetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KonfigurimetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KonfigurimetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

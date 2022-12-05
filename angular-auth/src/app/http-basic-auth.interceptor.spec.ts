import { TestBed } from '@angular/core/testing';

import { HttpBasicAuthInterceptor } from './http-basic-auth.interceptor';

describe('HttpBasicAuthInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      HttpBasicAuthInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: HttpBasicAuthInterceptor = TestBed.inject(HttpBasicAuthInterceptor);
    expect(interceptor).toBeTruthy();
  });
});

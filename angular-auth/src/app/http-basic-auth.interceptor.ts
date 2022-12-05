import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { StorageService } from './storage.service';

@Injectable()
export class HttpBasicAuthInterceptor implements HttpInterceptor {

  constructor(private storage: StorageService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    // return next.handle(request);
    console.log('HttpBasicAuthInterceptor - Test');
    const credentials = this.storage.get('authorization');
   
    if(credentials){
      console.log('HttpBasicAuthInterceptor - credentials: ' + credentials);
      return next.handle(request.clone({setHeaders:{Authorization: 'Basic ' + credentials}}));
    }
    else return next.handle(request);
  }
}

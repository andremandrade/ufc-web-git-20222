import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { StorageService } from '../storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';
  loginFailMessage: string = '';

  constructor(private loginService: LoginService,
    private router: Router,
    private localStorage: StorageService
    ) { }

  ngOnInit(): void {
  }

  login(){
    console.log('login - ' + this.username + ':' + this.password);
    this.loginService.login(this.username, this.password).subscribe((user) => {
      console.log('USER/ME: ');
      console.log(user);
      this.localStorage.set('authorization', btoa(this.username + ':' + this.password));
      this.router.navigate(['/dashboard']);
    }, (error) => {
      this.loginFailMessage = 'Usuario ou senha invalidos. Tente novamente';
    });
  }
}

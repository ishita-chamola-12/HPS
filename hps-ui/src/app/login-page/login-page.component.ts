import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { RoleService } from '../role.service';
import { AppUser } from '../app-user';
import { Role } from '../role';
import { LoginResponse } from '../login-response';
import { StorageService } from '../storage.service';
import { RegisterPageComponent } from '../register-page/register-page.component';
import { AppointmentService } from '../appointment.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css',
  standalone:true,
  imports:[FormsModule,CommonModule]
})
export class LoginPageComponent {

  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private authService: RegisterService, private storageService: StorageService,
  private router: Router) { }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.roles = this.storageService.getUser().roles;
    }
  }

  onSubmit(): void {
    const { username, password } = this.form;
//     this.as.authenticate(this.form);
    this.authService.login(username, password).subscribe({
      next: data => {
        this.storageService.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.storageService.getUser().roles;
        this.gotoHospitalHome();
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    });
  }

  gotoHospitalHome(){
  this.router.navigate(['/homeHospital']);
  }


}



import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common'
import { RegisterService } from '../register.service';
import { StorageService } from '../storage.service';
import { FormsModule } from '@angular/forms';
import { AddAppointmentComponent } from '../add-appointment/add-appointment.component';
import { AppointmentListComponent } from '../appointment-list/appointment-list.component';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
  standalone:true,
  imports:[FormsModule,CommonModule]
})
export class NavbarComponent {

username:string;
isAdmin=false;
user_id:number;
roles:string[];

constructor(private storageService:StorageService){ }
ngOnInit(): void{
if(this.storageService.isLoggedIn()){
const user=this.storageService.getUser();
this.roles=user.roles;
this.isAdmin=this.roles.includes('ROLE_ADMIN');
}

}
}

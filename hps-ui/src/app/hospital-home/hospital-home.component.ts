import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'
import { NavbarComponent } from '../navbar/navbar.component';
import { AppointmentListComponent } from '../appointment-list/appointment-list.component';
import { AddAppointmentComponent } from '../add-appointment/add-appointment.component';
import { UpdateAppointmentComponent } from '../update-appointment/update-appointment.component';
import { RegisterService } from '../register.service';
import { StorageService } from '../storage.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-hospital-home',
  templateUrl: './hospital-home.component.html',
  styleUrl: './hospital-home.component.css',
  standalone:true,
  imports:[FormsModule,CommonModule,NavbarComponent,AppointmentListComponent,AddAppointmentComponent,UpdateAppointmentComponent]
})
export class HospitalHomeComponent {

isAdmin=false;
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

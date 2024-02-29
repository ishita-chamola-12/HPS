import { Component} from '@angular/core';
import { Appointment } from '../appointment'
import { CommonModule } from '@angular/common'
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';
import { AppointmentService } from '../appointment.service'
import { Doctor } from '../doctor';
import { Patient } from '../patient';
import { NavbarComponent } from '../navbar/navbar.component';
import { AddAppointmentComponent } from '../add-appointment/add-appointment.component';
import { RegisterService } from '../register.service';
import { StorageService } from '../storage.service';
import { FormsModule } from '@angular/forms';



@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrl: './appointment-list.component.css',
  standalone:true,
  imports:[FormsModule,CommonModule]
})
export class AppointmentListComponent {


appointments:Appointment[];
isAdmin=false;
roles:string[];
//
//
// constructor(private storageService:StorageService){ }
// ngOnInit(): void{
// if(this.isLoggedIn()){
// const user=this.storageService.getUser();
// this.roles=user.roles;
// this.isAdmin=this.roles.includes('ROLE_ADMIN');
// }
//
// }

constructor( private appointmentService : AppointmentService ,private router:Router,
private registerService:RegisterService,private storageService:StorageService
){ }

ngOnInit(): void{
if(this.storageService.isLoggedIn()){
const user=this.storageService.getUser();
this.roles=user.roles;
this.isAdmin=this.roles.includes('ROLE_ADMIN');
}
this.getAppointments();
}
private getAppointments(){
this.appointmentService.getAppointmentList().subscribe(data=>{
this.appointments=data});
}

deleteAppointment(appointmentId:number){
this.appointmentService.deleteAppointment(appointmentId).subscribe(()=>this.getAppointments());
}
updateAppointment(appointmentId:number){
this.router.navigate(['updateAppointment',appointmentId]);

}

}

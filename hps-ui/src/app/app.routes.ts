import { Routes,RouterModule } from '@angular/router';
import { AppointmentListComponent } from './appointment-list/appointment-list.component';
import { AddAppointmentComponent } from './add-appointment/add-appointment.component';
import { UpdateAppointmentComponent } from './update-appointment/update-appointment.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { RegisterHospitalComponent } from './register-hospital/register-hospital.component';
import { RegisterDoctorComponent } from './register-doctor/register-doctor.component';
import { RegisterPatientComponent } from './register-patient/register-patient.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { HospitalHomeComponent } from './hospital-home/hospital-home.component';
import { DoctorHomeComponent } from './doctor-home/doctor-home.component';
import { PatientHomeComponent } from './patient-home/patient-home.component';
import { NgModule } from '@angular/core';
import { NavbarComponent } from './navbar/navbar.component';

// order of routes matter

export const routes: Routes = [
{path:'appointments',component:AppointmentListComponent},
{path:'addAppointment',component:AddAppointmentComponent},
{path: 'updateAppointment/:app_id',component:UpdateAppointmentComponent},
{path:'register',component:RegisterPageComponent},
{path:'registerHospital',component:RegisterHospitalComponent},
{path:'registerDoctor',component:RegisterDoctorComponent},
{path:'registerPatient',component:RegisterPatientComponent},
{path:'loginPage',component:LoginPageComponent},
{path:'homeHospital',component:HospitalHomeComponent},
{path :'homeDoctor',component:DoctorHomeComponent},
{path:'homePatient',component:PatientHomeComponent},
{path :'navbar',component:NavbarComponent,canActivate: []},
{path:'',redirectTo:'loginPage',pathMatch:'full'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }
  
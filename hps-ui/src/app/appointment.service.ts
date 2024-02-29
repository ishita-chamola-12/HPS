import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

// const headers;

  constructor(private httpClient:HttpClient) { }

//   authenticate(credentials){
//     const headers = new HttpHeaders(credentials ? { authorization :
//     'Basic ' + btoa(credentials.username +':'+ credentials.password)} : {});
//   }

  getAppointmentList():Observable<Appointment[]>{

  return this.httpClient.get<Appointment[]>('http://localhost:8080/api/appointments/allAppointments');
  }

  addAppointment(appointment:Appointment):Observable<Appointment>{
  return this.httpClient.post<Appointment>('http://localhost:8080/api/appointments/newAppointment',appointment);
  }

  deleteAppointment(app_id:number):Observable<any>{
  return this.httpClient.delete<any>('http://localhost:8080/api/appointments/'+app_id);
  }

  // function to get appointment by id ->used in update appointment form
  getAppointmentById(app_id:number):Observable<Appointment>{
  return this.httpClient.get<Appointment>('http://localhost:8080/api/appointments/appointment/'+app_id);
  }

  updateAppointment(app_id:number,appointment:Appointment):Observable<Appointment>{
  return this.httpClient.put<Appointment>('http://localhost:8080/api/appointments/updateAppointment/'+app_id , appointment);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Doctor } from './doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private httpClient:HttpClient) { }

  getDoctorList():Observable<Doctor[]>{
  return this.httpClient.get<Doctor[]>('http://localhost:8080/api/doctors/allDoctors');
  }
}

import { Doctor } from './doctor'
import { Patient } from './patient'

// this holds response of rest api
export class Appointment {
appointmentId:number;
doctor:Doctor;
patient:Patient;
// doctor_name:Doctor["doctor_name"];
// patient_name:Patient["patient_name"];
date:string;
time:string;
location:string;
}

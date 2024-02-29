import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppUser } from './app-user';
import { Role } from './role';
import { Hospital } from './hospital';
import { LoginResponse } from './login-response';
import { map, catchError } from 'rxjs/operators';

const httpOptions={
headers:new HttpHeaders({ 'Content-Type':'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private httpClient:HttpClient) { }

  // function to register in first page->username,password,role

  registerUser(user:AppUser):Observable<AppUser>{
  return this.httpClient.post<AppUser>('http://localhost:8080/api/authentication/register',user);
  }

  login(username: string, password: string): Observable<any> {
    return this.httpClient.post('http://localhost:8080/api/authentication/login',
      {
        username,
        password,
      },
    )
//     .pipe(
//     map(response=>{
//     localStorage.setItem("user_id",response.user_id);
//     localStorage.setItem("username",response.username);
//     localStorage.setItem("roles",JSON.stringify(response.roles));
//     }
//     )
//     )
    ;
  }

//   getUsername():string{
//   return localStorage.getItem('username');
//   }
//
//   getUserId():number{
//   return parseInt(localStorage.getItem('user_id'));
//   }
//
//   isAdmin():boolean{
//   const roleStr= localStorage.getItem("roles");
//   if(roleStr){
//   const roles=JSON.parse(roleStr);
//   return roles.includes("ADMIN");
//   }
//   return false;
//   }


  registerHospital(hospital:Hospital):Observable<Hospital>{
  return this.httpClient.post<Hospital>('http://localhost:8080/api/authentication/saveHospital',hospital);
  }

}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Role } from './role';
@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(private httpClient:HttpClient) { }

  getRoleList():Observable<Role[]>{
  return this.httpClient.get<Role[]>('http://localhost:8080/api/roles/allRoles');
  }
}

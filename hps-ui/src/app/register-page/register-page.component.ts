import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { RoleService } from '../role.service';
import { AppUser } from '../app-user';
import { Role } from '../role';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrl: './register-page.component.css',
  standalone:true,
  imports:[FormsModule]
})
export class RegisterPageComponent {

user:AppUser=new AppUser();
roles:Role[];

constructor(private registerService:RegisterService,private roleService:RoleService
,private router:Router){}

ngOnInit(): void{
this.loadRoles();
}

loadRoles():void{
this.roleService.getRoleList().subscribe(data=>{
console.log(data)
this.roles=data})
}

register(){
this.registerService.registerUser(this.user).subscribe(()=>{
this.gotoRegisterPage();
console.log("Successful Registration");
}
// re route to specific form pages based on role selected
)
}

gotoRegisterPage(){
switch(this.user.authority.role_id){
case 1:
this.router.navigate(['/registerHospital'],
{queryParams:{'username':this.user.username}});
break;
case 2:
this.router.navigate(['/registerDoctor']);
break;
case 3:
this.router.navigate(['/registerPatient']);
break;
}
}
onSubmit(){
this.register();
}

}


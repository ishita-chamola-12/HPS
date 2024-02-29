import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { Hospital } from '../hospital';
// import { ToastrService,ToastrModule } from 'ngx-toastr';

import { Subscription} from 'rxjs';

@Component({
  selector: 'app-register-hospital',
  templateUrl: './register-hospital.component.html',
  styleUrl: './register-hospital.component.css',
  standalone:true,
  imports:[FormsModule]
})
export class RegisterHospitalComponent {
hospital:Hospital=new Hospital();
username:string;
constructor(private registerService:RegisterService,private activatedRoute:ActivatedRoute,private router:Router,
// private toastr:ToastrService
){}

ngOnInit():void{
this.activatedRoute.queryParams.subscribe(params=>{
this.username=params['username'];
})
}

gotoLoginPage(){
// this.toastr.success('Hospital added successfully','Success',{
// timeOut:3000
// });
this.router.navigate(['/loginPage']);
}

registerHospital(){
this.registerService.registerHospital(this.hospital).subscribe(()=>{
this.gotoLoginPage();
console.log("Successful  Hospital Registration");
})

}
onSubmit(){
this.registerHospital();
}


}

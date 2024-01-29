import { Component,OnInit } from '@angular/core';
import { UserdataService } from '../userdata.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { StatusService } from '../status.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
//names:string[]=[];
public names!: any[];
public dashboard !:FormGroup|any;
healthcheck:any;
constructor(private userdata:UserdataService, private statusService:StatusService,private _http:HttpClient, private _router:Router){ }

check() {
  const currentStatus = this.dashboard.value.status;
  this.statusService.updateStatus(currentStatus);


  const currentName = this.dashboard.value.firstName;
  const currentBugs = this.dashboard.value.bugs;

  this.statusService.updateName(currentName);
  this.statusService.updateBugs(currentBugs);
  
  console.log(this.dashboard.value);
  this.healthcheck = this.dashboard.value.firstName; // Corrected property name
  this._http.post<any>("http://localhost:8080/api/health/save", this.dashboard.value)
    .subscribe(
      (res) => {
         alert("data added successfully");
        //this.dashboard.reset();
        this._router.navigate(['status']);
      },
      (err) => {
        alert("something went wrong");
      }
    );
  console.log('Form Submitted:', this.dashboard.value);
}



ngOnInit(): void {

 
  this.dashboard=new FormGroup({
    'firstName':new FormControl('',[Validators.required]),
    'bugs':new FormControl('',[Validators.required]),
    'deploymentTimeline':new FormControl('',[Validators.required]),
    'status':new FormControl('',[Validators.required]),
    'serviceRate':new FormControl('',[Validators.required]),
   
  })

  this.userdata.users().subscribe(
      (data) => {
          this.names = data;
      },
      (error) => {
          console.error('Error fetching names', error);
      }
  );
  
}

}

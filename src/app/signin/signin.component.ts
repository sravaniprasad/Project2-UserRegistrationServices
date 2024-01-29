import { Component,OnInit } from '@angular/core';
import {  FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
 userLogin:any={};
  show=false;
  

  openpopup(){
   // this.show=true;
  }
login:FormGroup|any;
  constructor(private formbuilder:FormBuilder, private _route:Router ,private _http: HttpClient){}
  showpassword=false;
  
  Show(){
    this.showpassword=!this.showpassword;
  }
  ngOnInit():void{ 
    this.login=new FormGroup({
      'userName':new FormControl('',[Validators.required]),
      'password':new FormControl('',[Validators.required,Validators.minLength(10)])
    });

  }
  

  logindata(){
    console.log(this.login.value);
    this._http.get<any>("http://localhost:8080/api/user/all")
    .subscribe(res=>{
      const user=res.find((a:any)=>{
        return a.userName===this.login.value.userName && a.password===this.login.value.password
      });
      if(user){
        alert("Login Success");
        this.login.reset();
        this._route.navigate(['home'])
      }else{
        alert("User Not Found!!")
      }
    },err=>{
      alert("Something Went Wrong!!!");
    })

    // console.log(this.userLogin);
    // this.loginuserservice.loginUser(this.userLogin).subscribe(data=>{
    //  alert("login success")
    // })
    
  }
}


import { HttpClient } from '@angular/common/http';
import { Component} from '@angular/core';
import { FormGroup,FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { SignupService } from '../signup.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  previewImage: string | ArrayBuffer | null = null;
  successMessage: string | null = null;
  country=[
    {
      id:1,name:"India", code:"IND"
    },
    {
      id:2, name:"pakisthan", code:"PAK"
    },
    {
      id:3,name:"chaina", code:"CHN"
    },
  ]

  state=[
    {
      id:1,name:"Andhrapradesh", c_id:1
    },
    {
      id:2, name:"karnataka",c_id:1
    },
    {
      id:3,name:"pakstate",c_id:2
    },
    {
      id:4,name:"pakstate1",c_id:2
    },
    {
      id:5,name:"chainastate",c_id:3
    }
  ]

  district=[
    {
      id:1,name:"kadapa", s_id:1
    },
    {
      id:2,name:"chittoor",s_id:1
    },
    {
      id:3,name:"pakdist",s_id:3
    },
    {
      id:4,name:"mysore",s_id:2
    },
    {
      id:5,name:"chinadist",s_id:5
    },
    {
      id:6,name:"pakdist1",s_id:4
    }
  ]
  addressText: FormGroup|any;
filteredStates=this.state;
filteredDist=this.district;
 public signup !:FormGroup|any;
  signuser:any;
  constructor(private signupService:SignupService,private userService: UserService, private _router:Router,private _http:HttpClient){}
  

  

//   updateStates(e:any){
//  let cid=e.target.value;
//  this.filteredStates=this.state.filter((c)=>{
//   return c['c_id']==cid
//  })
//   }

//   updateDist(e:any){
//     let sid=e.target.value;
//     this.filteredDist=this.district.filter((s)=>{
//       return s['s_id']==sid
//     })
//   }
updateStates(e: any) {
  const selectedCountryId = e.target.value;
  const selectedCountry = this.country.find(c => c['id'] == selectedCountryId);
  const countryName = selectedCountry ? selectedCountry['name'] : '';
  this.filteredStates = this.state.filter(s => s['c_id'] == selectedCountryId);
  console.log('Filtered States:', this.filteredStates);
  this.signup.get('country').setValue(countryName);
  this.signup.get('state').setValue('');
  this.signup.get('district').setValue('');
}

updateDist(e: any) {
  const selectedStateId = e.target.value;
  const selectedState = this.filteredStates.find(s => s['id'] == selectedStateId); 
  const stateName = selectedState ? selectedState['name'] : '';
  this.filteredDist = this.district.filter(d => d['s_id'] == selectedStateId); 
  this.signup.get('state').setValue(stateName);
  this.signup.get('district').setValue(''); 
}
  
onFileChange(event: any) {
  const fileInput = event.target;
  const file = fileInput.files && fileInput.files[0];

  if (file) {
    const reader = new FileReader();

    // reader.onload = (e: any) => {
    //   this.previewImage = e.target.result;
    // };

     reader.readAsDataURL(file);
  }
}
  ngOnInit():void{

    
  

    this.signup=new FormGroup({
      'firstName':new FormControl('',[Validators.required]),
      'lastName':new FormControl('',[Validators.required]),
      'userName':new FormControl('',[Validators.required]),
      'gender':new FormControl('',[Validators.required]),
      'country':new FormControl('',[Validators.required]),
      'state':new FormControl('',[Validators.required]),
      'district':new FormControl('',[Validators.required]),
      'address': new FormControl('', [Validators.required, Validators.maxLength(200)]),
      'phoneNumber':new FormControl('',[Validators.required,Validators.pattern(/^\d{10}$/)]),
      'email':new FormControl('',[Validators.required,Validators.email]),
      'password':new FormControl('',[Validators.required,Validators.minLength(10)]),
      'image':new FormControl('',[Validators.required])
    })

  }

  // onRegister(): void {
  //   this.signupService.setSuccessMessage('You have successfully registered!');
  // }
  // clicksubmit(){
  //   console.log(this.signup.value);
  //   this.signup.reset();
  // }
  signupdata(Values:any){
   console.log(this.signup.value);
    this.signuser=this.signup.value.firstname
   this._http.post<any>("http://localhost:3000/signup",this.signup.value)
   .subscribe(res=>{
        
    //  alert("data added successfull");
     this.signup.reset();
     this._router.navigate(['registered']);
       },err=>{
   alert("something went wrong");
   })

  
  
  this.userService.registeration(this.signup.value).subscribe(
    response => {
      console.log(response);
    },
    error => {
      console.error(error);
    }
  );

   }
}

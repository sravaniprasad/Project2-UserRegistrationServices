import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserdataService } from '../userdata.service';
import { switchMap } from 'rxjs/operators';
import * as XLSX from 'xlsx';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  fileUploadUrl='http://localhost:8080/api/user/data/upload';
  @ViewChild ("table") table!: ElementRef
  public users!: any[];
  public filteredUsers: any[] = []; 
  tableData: any[] = [];//table data[middle]
  searchForm: FormGroup;
  file:any;
  flag=true;
p:number=1;
  constructor(private userData: UserdataService,private _http:HttpClient, private fb: FormBuilder) {
    this.searchForm = this.fb.group({
      firstName: ['']
    });
  }

  ngOnInit(): void {
    this.userData.users().subscribe((data: any) => {
      this.users = data;
    });
  }
  chooseFile(event:any){
    // console.log(event);
 
     this.file=event.target.files[0];
     console.log(this.file);
   }
  UploadFile(){
    let formData=new FormData();
    formData.append("file",this.file);

    this.flag=false;
    this._http.post(this.fileUploadUrl,formData).subscribe(
      (data:any)=>{
        console.log(data);
        alert(data.message);
        this.flag=true;
      },
      (error:any)=>{
        console.log(error);
        alert('Please upload the file');
        this.flag=true;
      }
    );
     
  }
  // Search() {
  //   const searchTerm = this.searchForm.value.firstName.toLowerCase();

  //   if (searchTerm === "") {
  //      this.ngOnInit();
  //    } else {
    //   this.users = this.users.filter((user: any) => {
   
    //  return user.firstName.toLowerCase().includes(searchTerm);
  //  })
  //  }
  
  // }
  private loadUsersData() {
    this.userData.users().subscribe((data: any) => {
      this.users = data;
    });
  }
 
  Search() {
    const searchTerm = this.searchForm.value.firstName.toLowerCase();

    if (searchTerm.length === 0) {
      this.loadUsersData();
    } else {
      this.filteredUsers = this.users.filter((user: any) =>
        user.firstName.toLowerCase() === searchTerm
      );
    }
    
  }
  exportDataToExcel() {
  //  let excelsheet= XLSX.utils.table_to_book(this.table.nativeElement)
  //  XLSX.writeFile(excelsheet,'users.xlsx')
    const ws: XLSX.WorkSheet = XLSX.utils.json_to_sheet(this.users);
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');
    XLSX.writeFile(wb, 'data.xlsx');
  }
   
}


  // Search() {
  //   const searchTerm = this.searchForm.value.firstName.toLowerCase();
  
  //   if (searchTerm === 0) {
  //     this.ngOnInit();
  //   } else {
  //     this.users = this.users.filter((user: any) => {
   
  //       user.firstName.toLowerCase() === searchTerm
  //     });
      // this.userData.searchUsers(searchTerm).subscribe((data: any) => {
      //   if (Array.isArray(data)) {
      //     // If response is an array, filter the users directly
      //     this.users = data.filter((user: any) =>
      //       user.firstName.toLowerCase() === searchTerm
      //     );
      //   } else if (data && data.users && Array.isArray(data.users)) {
      //     // If response has nested 'users' array, use that for filtering
      //     this.users = data.users.filter((user: any) =>
      //       user.firstName.toLowerCase() === searchTerm
      //     );
      //   } else {
      //     // Handle other scenarios or log an error
      //     console.error("Unexpected response format:", data);
      //   }
      // });
  //   }
  // }
  
  


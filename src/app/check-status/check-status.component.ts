import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { StatusService } from '../status.service';
import { UserdataService } from '../userdata.service';

@Component({
  selector: 'app-check-status',
  templateUrl: './check-status.component.html',
  styleUrls: ['./check-status.component.css']
})
export class CheckStatusComponent implements OnInit {
  public users!: any[];
  currentStatus: string = '';
  currentName: string = '';
  currentBugs: string = '';

  constructor(private userData: UserdataService,private statusService: StatusService) {}

  ngOnInit(): void {
    this.statusService.currentStatus.subscribe(status => {
      this.currentStatus = status;
    });
    
    this.statusService.currentName.subscribe(name => {
      this.currentName = name;
    });

    this.statusService.currentBugs.subscribe(bugs => {
      this.currentBugs = bugs;
    });

    this.userData.users().subscribe((data: any) => {
      this.users = data;
    });
  }
}

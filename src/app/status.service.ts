// status.service.ts

import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatusService {
  private statusSubject = new BehaviorSubject<string>('');
  public currentStatus = this.statusSubject.asObservable();
  private nameSubject = new BehaviorSubject<string>('');
  private bugsSubject = new BehaviorSubject<string>('');
  public currentName = this.nameSubject.asObservable();
  public currentBugs = this.bugsSubject.asObservable();

  updateStatus(status: string) {
    this.statusSubject.next(status);
  }
  updateName(name: string) {
    this.nameSubject.next(name);
  }

  updateBugs(bugs: string) {
    this.bugsSubject.next(bugs);
  }
}

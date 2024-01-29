import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SignupService {

  private successMessageSubject: BehaviorSubject<string | null> = new BehaviorSubject<string | null>(null);

  setSuccessMessage(message: string): void {
    this.successMessageSubject.next(message);
  }

  getSuccessMessage(): Observable<string | null> {
    return this.successMessageSubject.asObservable();
  }
  constructor() { }
}

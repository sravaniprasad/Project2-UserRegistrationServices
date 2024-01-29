import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserdataService {
url="http://localhost:8080/api/user/all"
Searchurl="http://localhost:8080/api/user/name/"
  constructor(private _http:HttpClient) { }
  users():Observable<string[]> {
    return this._http.get<string[]>(this.url);
  }
searchUsers(searchTerm: string){
  return this._http.get(`${this.Searchurl}${searchTerm}`);
}
  

}

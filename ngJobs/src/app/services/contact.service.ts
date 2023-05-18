import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Contact } from '../models/contact';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  //private baseUrl = 'http://localhost:8086/';
  //private url = this.baseUrl + 'api/contact'

  private url = environment.baseUrl+'api/contact'
  constructor(

    private http: HttpClient,
    private auth: AuthService

  ) { }
  getHttpOptions() {
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }

 index(): Observable<Contact[]> {
  return this.http.get<Contact[]>(this.url, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(
        () => new Error('companyService.index(): error retrieving companies: ' + err)
      );
    })
  );
}

showForCompany(id:number):Observable<Contact[]>{
  console.log(id)
  return this.http.get<Contact[]>(this.url+'/company/'+ id, this.getHttpOptions() ).pipe(
    catchError((err: any)=>{
      console.error(err);
      return throwError(
        ()=> new Error('contactService.delete(): error getting contacts'+ id)
      )
    })

   );
}
















}

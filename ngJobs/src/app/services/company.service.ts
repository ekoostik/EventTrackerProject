import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Company } from '../models/company';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  //private baseUrl = 'http://localhost:8086/';
 // private url = this.baseUrl + 'api/company'
 private url = environment.baseUrl+'api/company'
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

  index(): Observable<Company[]> {
    return this.http.get<Company[]>(this.url, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('companyService.index(): error retrieving companies: ' + err)
        );
      })
    );
  }

  create(company: Company): Observable<Company>{
    company.active= true;
    return this.http.post<Company>(this.url, company).pipe(
      catchError((err: any)=>{
        console.error(err);
        return throwError(
          ()=> new Error('companyService.create(): error creating Company'+ company)
        )
      })
    );
  }

  update(company: Company): Observable<Company>{
    return this.http.post<Company>(this.url, company).pipe(
      catchError((err: any)=>{
        console.error(err);
        return throwError(
          ()=> new Error('companyService.update): error updating Company'+ company)
        )
      })
    );
  }


  destroy(id:number): Observable<void> {
    return this.http.delete<void>(this.url+"/"+ id).pipe(
     catchError((err: any)=>{
       console.error(err);
       return throwError(
         ()=> new Error('companyService.delete(): error deleting Company'+ id)
       )
     })

    );


 }
 show(id:number): Observable<Company>{
  console.log(id)
  return this.http.get<Company>(this.url+"/"+ id).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(
        () => new Error('companyService.index(): error retrieving Company: '+ id + err)
      );
    })
  );
}





}

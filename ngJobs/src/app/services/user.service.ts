import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { Observable, catchError, throwError } from 'rxjs';
import { Offer } from '../models/offer';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private url = environment.baseUrl;




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

getUserOffers(id:number):Observable<Offer[]>{
  return this.http.get<Offer[]>(this.url + +'api/user/offer'+id, this.getHttpOptions() ).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(
        () => new Error('companyService.index(): error retrieving offers: ' + err)
      );
    })
  );


}






}

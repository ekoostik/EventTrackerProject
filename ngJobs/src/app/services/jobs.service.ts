import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Company } from '../models/company';

@Injectable({
  providedIn: 'root'
})
export class JobsService {

  private baseUrl = 'http://localhost:8086/';
  private url = this.baseUrl + 'api/companies'
  constructor(

    private http: HttpClient

  ) { }


  index(): Observable<Company[]> {
    return this.http.get<Company[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('PokemonService.index(): error retrieving pokemon: ' + err)
        );
      })
    );
  }











}

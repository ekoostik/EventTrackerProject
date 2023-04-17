import { Pipe, PipeTransform } from '@angular/core';
import { Company } from '../models/company';

@Pipe({
  name: 'active'
})
export class ActivePipe implements PipeTransform {

  transform(companies: Company[], showActive: boolean): Company[] {
     let results: Company[]=[];

       companies.forEach((company)=>{
         if(company.active){
           results.push(company)
         }
       })



     return results;
    }


}

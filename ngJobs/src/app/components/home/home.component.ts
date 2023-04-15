import { Component } from '@angular/core';
import { Company } from 'src/app/models/company';
import { JobsService } from 'src/app/services/jobs.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  companies: Company[]=[];

constructor( private jobServ: JobsService){

}

ngOnInit(): void {
  this.reload();
}


reload(){
  this.jobServ.index().subscribe({

    next:(compList)=>{
      this.companies=compList;
    },
    error:(fail)=>{
      console.log('ohh no');
    }
  })
}






}

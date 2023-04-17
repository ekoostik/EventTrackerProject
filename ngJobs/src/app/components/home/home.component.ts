import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Company } from 'src/app/models/company';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {



constructor( private compServ: CompanyService, private route: ActivatedRoute,
  private router: Router ){}


selected: Company | null = null;
newCompany: Company = new Company();
companies: Company[]=[];
editCompany: Company | null = null;
showActive = false;
addCompany = false;

ngOnInit(): void {
  this.reload();
}


reload(){
  this.compServ.index().subscribe({

    next:(compList)=>{
      this.companies=compList;
    },
    error:(fail)=>{
      console.log('ohh no');
    }
  })
}

selectCompany(comp: Company){
  this.selected = comp;
}

createCompany(company: Company){
  this.compServ.create(company).subscribe({
    next:(comp)=>{
      this.newCompany= new Company();
      this.reload()
    }
  })

}




 updateCompany(company:Company){
  this.compServ.update(company).subscribe({
    next:(comp)=>{
      this.reload();
    },
    error: (failure) => {
      console.error('Error getting company list');
      console.error(failure);
    }
  })
 }

 deleteCompany(id: number){
  this.compServ.destroy(id).subscribe({
    next:()=>{
      this.reload();
    },
    error: (failure) => {
      console.error('Error getting company list');
      console.error(failure);
    }
  })
 }

 showCompany(id:number){
  this.compServ.show(id).subscribe({
    next:(company)=>{
      if(company === null){
        this.router.navigateByUrl('opps')
      }else{
        this.selected=company;
      }
    },
    error: (failure) => {
      console.error('Error getting company');
      console.error(failure);

    }

  })

 }

 loadAddCompForm(){
  this.addCompany=true;
 }

 setEditCompany(){
  this.editCompany = Object.assign({}, this.selected)
 }



}

import { Observable } from 'rxjs';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Company } from 'src/app/models/company';
import { CompanyService } from 'src/app/services/company.service';
import { ContactService } from 'src/app/services/contact.service';
import { ActivePipe } from '../../pipes/active.pipe';
import { UserCompanies } from 'src/app/models/userCompanies';
@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent {



constructor( private compServ: CompanyService, private contactSrvc: ContactService ,private route: ActivatedRoute,
  private router: Router, private active: ActivePipe ){}


selected: Company | null  = null;
newCompany: Company = new Company();
companies: Company[]=[];
editCompany: Company | null = null;
showActive = false;
addCompany = false;
hideButton = false;
compList: UserCompanies []=[];

ngOnInit(): void {
  let selectedCompany = Number(
    this.route.snapshot.paramMap.get('id')
  );
  if(selectedCompany){
    this.compServ.show(selectedCompany).subscribe({
      next:(comp)=>{
        this.selectCompany(comp)
      }
    })
  }else{
  this.reload();
  }
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

usersCompanies(id: number){
this.compServ.getForUser(id).subscribe({
  next:(compList)=>{
    this.compList = compList;
  }

})





}

selectCompany(comp: Company){
  this.selected = comp;
  // console.log(comp.id)
  this.contactSrvc.showForCompany(comp.id).subscribe({
    next:(contacts)=>{
      if(this.selected != null)
      this.selected.contacts=contacts;
    }

  })
}

createCompany(company: Company){
  this.compServ.create(company).subscribe({
    next:(comp)=>{

      this.addCompany=false;
      this.newCompany= new Company();
      this.reload();
    }
  })

}




 updateCompany(company:Company){

  this.compServ.update(company).subscribe({
    next:(comp)=>{

      this.cancel();
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
      this.selected=null;
      this.reload();
    },
    error: (failure) => {
      console.error('Error getting company list');
      console.error(failure);
    }
  })
 }



 loadAddCompForm(){
  this.addCompany=true;
 }

 setEditCompany(){
  this.hideButton=true;
  this.editCompany = Object.assign({}, this.selected)
  console.log(this.editCompany);
 }

 cancel(){
  this.editCompany=null;
  this.selected=null;
  this.addCompany=false;
  this.newCompany=new Company();
  this.hideButton=false;
  this.reload();

}

companyContacts(id: number){
  this.contactSrvc.showForCompany(id).subscribe({
    next:(contacts)=>{
      if(this.selected != null)
      this.selected.contacts=contacts;
    }

  })

}

companyCount(){
  return this.active.transform(this.companies, this.showActive).length
}




}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Contact } from 'src/app/models/contact';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  constructor(private contactSrvc: ContactService ,private route: ActivatedRoute,
    private router: Router) { }


    contacts: Contact[]=[];

  ngOnInit() {
  }


  companyContacts(id: number){
    this.contactSrvc.showForCompany(id).subscribe({
      next:(contacts)=>{
        this.contacts=contacts;
      }

    })

  }

}

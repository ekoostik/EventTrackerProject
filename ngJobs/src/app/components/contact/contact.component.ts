import { AuthService } from 'src/app/services/auth.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Contact } from 'src/app/models/contact';
import { User } from 'src/app/models/user';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  constructor(private contactSrvc: ContactService ,private route: ActivatedRoute,
    private router: Router, private auth: AuthService,) { }


    contacts: Contact[]=[];
    user: User = new User();



  ngOnInit() {
    this.getLoggedInUser();
    this.userContacts();
  }


  companyContacts(id: number){
    this.contactSrvc.showForCompany(id).subscribe({
      next:(contacts)=>{
        this.contacts=contacts;
      }

    })

  }

  userContacts(){

    this.contactSrvc.findForUser(this.user).subscribe({
      next:(contacts)=>{
        this.contacts=contacts;
      }
    })
  }

  getLoggedInUser(){
    this.auth.getLoggedInUser().subscribe({
      next:(foundUser) =>{
        this.user = foundUser;


      }


  })
  }

}

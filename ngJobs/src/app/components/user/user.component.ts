import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Offer } from 'src/app/models/offer';
import { User } from 'src/app/models/user';
import { UserCompanies } from 'src/app/models/userCompanies';
import { AuthService } from 'src/app/services/auth.service';
import { CompanyService } from 'src/app/services/company.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user: User = new User();
  selected: User | null = null;
  editUser: User | null = null;
  compList: UserCompanies []=[];
  offerList: Offer []=[];
  constructor(
    private auth: AuthService,
    private compSrvc: CompanyService,
    private userSrvc: UserService,
  ) { }

  ngOnInit() {
    this.getLoggedInProfile();

  }







getLoggedInProfile(){
  this.auth.getLoggedInUser().subscribe({
    next:(foundUser) =>{
      this.selected = foundUser;
      this.compSrvc.getForUser(foundUser.id).subscribe({
        next:(companies)=>{
          this.compList=companies
        }
      })

    }
    
    
})
}




}

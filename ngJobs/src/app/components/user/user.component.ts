import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user: User = new User();
  selected: User | null = null;
  editUser: User | null = null;
  constructor(
    private auth: AuthService,
  ) { }

  ngOnInit() {
    this.getLoggedInProfile();

  }







getLoggedInProfile(){
  this.auth.getLoggedInUser().subscribe({
    next:(foundUser) =>{
      this.selected = foundUser;

    }
})
}




}

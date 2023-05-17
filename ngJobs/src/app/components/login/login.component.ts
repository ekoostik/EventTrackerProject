import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  constructor(private auth: AuthService,
     private router: Router,
     private route: ActivatedRoute,) {}



  loginUser: User = new User();

  newUser: User = new User();



  ngOnInit() {

    }





  login(user: User) {
    console.log('Loggin in:');
    console.log(user);

    this.auth.login(user.username, user.password).subscribe({
      next: (loggedInUser) => {
        this.router.navigateByUrl('user');

      },
      error: (problem) => {
        console.error('RegisterComponent.register(): Error logging in user:');
        console.error(problem);
      },
    });
  }



















}

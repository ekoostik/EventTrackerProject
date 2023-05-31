import { Company } from "./company";

export class Contact {

  id: number;
  firstName: string;
  lastName: string;
  phone: string;
  email: string;
  title: string;
  company: Company;
  users: any[] | undefined;

  constructor(
    id: number =0,
    firstName: string ='',
    lastName: string = '',
    phone: string='',
    email: string ='',
    title: string ='',
    company: Company,
    users: any []=[],


  ){

   this.id = id;
  this.firstName = firstName ;
  this.lastName = lastName ;
  this.phone=phone ;
  this.email=email;
  this.title=title ;
  this.company=company;
  this.users=users;
  }

}

import { Company } from "./company";

export class Contact {

  id: number;
  firstName: string;
  lastName: string;
  phone: string;
  email: string;
  title: string;
  company: Company;

  constructor(
    id: number =0,
    firstName: string ='',
    lastName: string = '',
    phone: string='',
    email: string ='',
    title: string ='',
    company: Company

  ){

   this.id = id;
  this.firstName = firstName ;
  this.lastName = lastName ;
  this.phone=phone ;
  this.email=email;
  this.title=title ;
  this.company=company;
  }

}

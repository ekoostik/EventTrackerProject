import { Company } from 'src/app/models/company';
import { Questions } from "./questions";
import { Offer } from './offer';

export class User {

id: number;
firstName: string;
lastName: string;
username: string;
photo: string;
createDate: string;
enabled: boolean;
password: string;
role: string;
questions: any[] | null;
companies: any[] | null;
offers: Offer [] | null;
contacts: any[] | null;

constructor(

  id: number=0,
  firstName: string='',
  lastName: string='',
  username: string='',
  photo: string='',
  createDate: string='',
  enabled: boolean=true,
  password: string='',
  role: string='',
  questions: any[] =[],
  companies: any[] =[],
  offers: Offer[] =[],
  contacts: any []=[]

){

  this.id=id;
  this.firstName =firstName;
  this.lastName = lastName;
  this.username =username;
  this.photo =photo;
  this.createDate = createDate;
  this.enabled=enabled;
  this.password =password;
  this.role =role;
  this.questions =questions ;
  this.companies =companies ;
  this.offers =offers;
  this.contacts=contacts





}




}

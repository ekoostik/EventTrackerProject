import { Company } from "./company";
import { User } from "./user";

export class Offer {

id: number;
salary: number;
health: string;
dental: string;
overtime: string;
holidays: string;
company: Company | null;
user: User | null;

constructor(
  id: number=0,
salary: number=0,
health: string='',
dental: string='',
overtime: string='',
holidays: string='',
company: Company | null= null,
user: User | null = null,

){

this.id=id;
this.salary=salary;
this.health=health;
this.dental=dental;
this.overtime=overtime;
this.holidays=holidays;
this.company=company;
this.user=user;


}







}

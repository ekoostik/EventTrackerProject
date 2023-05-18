import { Company } from "./company";
import { User } from "./user";

export class UserCompanies {


applyDate: string;
user: User | null;
company: Company | null;
active: boolean;

constructor(
applyDate: string ='',
user: User | null =null,
company: Company | null=null,
active: boolean = false,

){
this.applyDate=applyDate;
this.user=user;
this.company=company;
this.active=active;


}









}

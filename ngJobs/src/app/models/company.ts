export class Company {

id: number;
name: string;
website: string;
applyDate: string;
active: boolean;
remote: boolean;
contacts: any[] | undefined;
users: any[] | undefined;
offers: any[] | undefined;
questions: any[] | undefined
constructor(
id: number =0,
name: string ='',
website: string ='',
applyDate: string ='',
active: boolean = false,
remote: boolean = false,
contacts: any[]=[],
users: any []=[],
offers: any [] = [],
questions: any []=[]
){

this.id=id;
this.name=name;
this.website=website;
this.applyDate=applyDate;
this.active=active;
this.remote=remote;
this.contacts=contacts;
this.users=users;
this.offers=offers;
this.questions=questions;
}


}

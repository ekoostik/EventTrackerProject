export class Company {

id: number;
name: string;
website: string;
applyDate: string;
active: boolean;
remote: boolean;
contacts: any[] | undefined;

constructor(
id: number =0,
name: string ='',
website: string ='',
applyDate: string ='',
active: boolean = false,
remote: boolean = false,
contacts: any[]=[]
){

this.id=id;
this.name=name;
this.website=website;
this.applyDate=applyDate;
this.active=active;
this.remote=remote;
this.contacts=contacts;
}


}

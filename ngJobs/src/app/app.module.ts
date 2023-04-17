import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './components/home/home.component';
import { ContactComponent } from './components/contact/contact.component';
import { ActivePipe } from './pipes/active.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ContactComponent,
    ActivePipe

   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ActivePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }

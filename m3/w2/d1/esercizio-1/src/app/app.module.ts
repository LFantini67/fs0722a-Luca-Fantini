import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PrimoComponentComponent } from './components/primo-component/primo-component.component';
import { SecondComponentComponent } from './components/second-component/second-component.component';
import { TerzoComponentComponent } from './components/terzo-component/terzo-component.component';

@NgModule({
  declarations: [
    AppComponent,
    PrimoComponentComponent,
    SecondComponentComponent,
    TerzoComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

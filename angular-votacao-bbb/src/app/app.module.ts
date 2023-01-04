import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from "@angular/common/http"

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VotacaoComponent } from './votacao/votacao.component';
import { RegistrarVotacaoComponent } from './registrar-votacao/registrar-votacao.component';

@NgModule({
  declarations: [
    AppComponent,
    VotacaoComponent,
    RegistrarVotacaoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

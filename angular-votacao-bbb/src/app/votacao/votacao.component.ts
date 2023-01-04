import { Component, OnInit } from '@angular/core';
import { Participante } from '../model/participante';
import { RestService } from '../service/restService';

@Component({
  selector: 'app-votacao',
  templateUrl: './votacao.component.html',
  styleUrls: ['./votacao.component.css']
})
export class VotacaoComponent implements OnInit {

  title = 'Votação BBB'
  participantes: Participante[] | undefined
 
  constructor(private restService : RestService) {}

  ngOnInit(): void {
    this.getParticipantes();
  }

  getParticipantes() {
     this.restService.getData('/participants').subscribe((participantes) => {
       this.participantes = participantes;
     })
  }

}

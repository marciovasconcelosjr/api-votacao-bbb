import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestService } from '../service/restService';

@Component({
  selector: 'app-registrar-votacao',
  templateUrl: './registrar-votacao.component.html',
  styleUrls: ['./registrar-votacao.component.css']
})
export class RegistrarVotacaoComponent implements OnInit {

  title = 'Voto computado!';
  id = '';

  constructor(private activetedRoute : ActivatedRoute,
    private restService : RestService) { }

  ngOnInit(): void {
    this.activetedRoute.queryParams.subscribe(params => {
      this.enviarVoto(params['id'])
    })
  }

  enviarVoto(id: string) {
    this.id = id;
  }

}

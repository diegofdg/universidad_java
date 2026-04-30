import { Component } from '@angular/core';
import { Persona } from '../persona.model';
import { PersonaService } from '../persona-service';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-personas',
  imports: [RouterModule],
  templateUrl: './personas.component.html'
})
export class PersonasComponent {
  personas: Persona[] = [];

  constructor(private personaService: PersonaService,
              private router: Router,
              private route: ActivatedRoute
    ) { }

  ngOnInit(): void{
    this.personaService.obtenerPersonas()
      .subscribe(
        (personasObtenidas: Persona[]) => {
          //cargamos los datos de persona obtenidos en el arreglo local
          this.personas = personasObtenidas;
          this.personaService.setPersonas(this.personas);
          console.log('personas obtenidas del subscriber:' + this.personas);
        }
      );
  }

  irAgregar(){
    console.log('nos vamos a agregar');
    this.router.navigate(['./personas/agregar']);
  }


}

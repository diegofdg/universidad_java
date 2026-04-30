import { Component } from '@angular/core';
import { PersonaService } from '../persona-service';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from '../persona.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  imports: [FormsModule],
  templateUrl: './formulario.component.html',
  styles: ``
})
export class FormularioComponent {
  idPersona?: number;
  nombreInput?: string;

  constructor(private personaService: PersonaService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.idPersona = Number(this.route.snapshot.params['idPersona']);
    console.log('recuperamos el parametro idPersona:' + this.idPersona);
    if (this.idPersona != null) {
      const persona = this.personaService.encontrarPersona(this.idPersona);
      if (persona != null) {
        this.nombreInput = persona.nombre;
      }
    }

  }

  onGuardarPersona() {
    const personaAGuardar = new Persona(this.idPersona ?? 0, this.nombreInput ?? '');
    if (this.idPersona != null) {
      this.personaService.modificarPersona(this.idPersona, personaAGuardar);
    }
    else {
      this.personaService.agregarPersona(personaAGuardar);
    }
    this.router.navigate(['personas']);
  }

  onEliminarPersona(){
    if(this.idPersona != null){
      console.log('persona a eliminar:' + this.idPersona);
      this.personaService.eliminarPersona(this.idPersona);
    }
    this.router.navigate(['personas']);
  }

}

import { Injectable } from '@angular/core';
import { Persona } from './persona.model';
import { DataService } from './data-service';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  personas: Persona[] = [];

  constructor(private dataService: DataService) {}

  setPersonas(personas: Persona[]) {
    this.personas = personas;
  }

  agregarPersona(persona: Persona) {
    console.log('persona a agregar:' + persona.nombre);
    this.dataService.agregarPersona(persona)
      .subscribe({
        next: (persona: Persona) => {
          console.log('se agrega al arreglo la persona recien insertada suscriber:' + persona.idPersona);
          this.personas.push(persona);
        },
        error: (error) => {
          console.error('Error al agregar persona:', error);
        }
      });
  }

  encontrarPersona(id: number){
    const persona = this.personas.find(p => p.idPersona == id);
    console.log('persona encontrada:' + persona?.idPersona + ' ' + persona?.nombre);
    return persona;
  }

  modificarPersona(id: number, persona: Persona) {
    console.log('persona a modificar:' + persona.idPersona);
    this.dataService.modificarPersona(id, persona);
  }

  eliminarPersona(id: number) {
    console.log('eliminar persona con id:' + id);
    const index = this.personas.findIndex(p => p.idPersona == id);
    this.personas.splice(index, 1);
    this.dataService.eliminarPersona(id);
  }

}

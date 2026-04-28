import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Persona } from './persona.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private httpClient: HttpClient) {}

  urlBase = 'http://localhost:8080/personas-backend-java/webservice/personas';

  cargarPersonas() {
    return this.httpClient.get(this.urlBase);
  }

  agregarPersona(persona: Persona): Observable<Persona> {
    return this.httpClient.post<Persona>(this.urlBase, persona);
  }

  modificarPersona(idPersona: number, persona: Persona) {
    const url = `${this.urlBase}/${idPersona}`;
    this.httpClient.put(url, persona)
      .subscribe({
        next: (response) => {
          console.log('resultado modificar persona:', response);
        },
        error: (error) => {
          console.log('Error en modificar persona:', error);
        }
      });
  }

  eliminarPersona(idPersona: number) {
    const url = `${this.urlBase}/${idPersona}`;
    this.httpClient.delete(url)
      .subscribe({
        next: (response) => {
          console.log('resultado eliminar persona:', response);
        },
        error: (error) => {
          console.log('Error en eliminar persona:', error);
        }
      });
  }

}

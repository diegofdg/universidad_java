import { Routes } from '@angular/router';
import { PersonasComponent } from './personas/personas.component';
import { FormularioComponent } from './formulario/formulario.component';

export const routes: Routes = [
    { path: '', component: PersonasComponent },
    {path: 'personas', component: PersonasComponent, children:[
      {path: 'agregar', component: FormularioComponent},
      {path: ':idPersona', component: FormularioComponent}
    ]}
];

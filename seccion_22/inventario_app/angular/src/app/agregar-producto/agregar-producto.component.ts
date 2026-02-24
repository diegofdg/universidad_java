import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { FormsModule } from '@angular/forms'; 

@Component({
  selector: 'app-agregar-producto',
  imports: [FormsModule],
  templateUrl: './agregar-producto.component.html'
})
export class AgregarProductoComponent {
  producto: Producto = new Producto();

  private productoServcio = inject(ProductoService);
  private enrutador = inject(Router);
  
  onSubmit() {
    this.guardarProducto();
  }

  guardarProducto() {
    this.productoServcio.agregarProducto(this.producto).subscribe(
      {
        next: (datos) => {
          this.irListaProductos();
        },
        error: (error: any) => { console.log(error) }
      }
    );
  }

  irListaProductos() {
    this.enrutador.navigate(['/productos']);
  }
}

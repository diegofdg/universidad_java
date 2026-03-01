package ejemploconversionobjetos;

public class Escritor extends Empleado {

    //Utilizamos una enumeracion para las opciones de tipo de escritura
    final TipoEscritura tipoEscritura;

    public Escritor(String nombre, double sueldo, TipoEscritura tipoEscritura) {
        super(nombre, sueldo);
        this.tipoEscritura = tipoEscritura;
    }

    public String obtenerDetalles(){
        //Observamos que para no repetir codigo, podemos utilizar 
        //el metodo del padre y solo agregar a este metodo lo de la clase hija
        //esto es invocar un metodo sobreescrito
        return super.obtenerDetalles() + ", tipoEscritura: " + tipoEscritura.getDescripcion();
    }

    public TipoEscritura getTipoEscritura() {
        return tipoEscritura;
    }

    public String getTipoDeEscrituraEnTexto() {
        return tipoEscritura.getDescripcion();
    }

}

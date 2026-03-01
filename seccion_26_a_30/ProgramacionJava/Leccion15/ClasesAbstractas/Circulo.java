package abstracto.domain;

public class Circulo extends FiguraGeometrica {

    public Circulo(String tipoFigura) {
        super(tipoFigura);
    }

    public void dibujar() {
        //Comportamiento de la subclase
        System.out.println("Aquí debería dibujar un:" + this.getClass().getSimpleName());
    }
}


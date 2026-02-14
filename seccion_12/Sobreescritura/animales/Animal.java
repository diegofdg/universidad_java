package Sobreescritura.animales;

public class Animal {
    protected void comer(){
        System.out.println("Como muchas veces al día");
    }

    protected void dormir(){
        System.out.println("Duermo muchas horas");
    }
}

class Perro extends Animal{
    public void hacerSonido(){
        System.out.println("Puedo ladrar");
    }

    @Override
    protected void dormir(){
        System.out.println("Duermo 15 horas al dia");
    }

}

class PruebaAnimal{
    public static void main(String[] args) {
        System.out.println("*** Ejemplo de Herencia ***");
        System.out.println("Clase Padre, soy un Animal");
        var animal1 = new Animal();
        animal1.comer();
        animal1.dormir();
        // animal1.hacerSonido(); // este metodo no existe en la clase padre

        System.out.println("\nClase Hija, soy un Perro");
        var perro1 = new Perro();
        perro1.comer();
        perro1.dormir();
        perro1.hacerSonido();
    }
}
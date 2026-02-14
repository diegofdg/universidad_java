package MetodosEstaticos.animales;

public class Animal {
    public void hacerSonido(){
        System.out.println("El animal hace un sonido");
    }
} // fin Clase Animal

class Perro extends Animal{
    @Override
    public void hacerSonido(){
        System.out.println("El perro hace wauf");
    }
}

class Gato extends Animal{
    @Override
    public void hacerSonido(){
        System.out.println("El gato hace miau");
    }
}

class PruebaAnimal{
    public static void main(String[] args) {
        System.out.println("*** Ejemplo Polimorfismo ***");
        //var animal = new Animal();
        Animal animal = new Gato();//polimorfismo
        animal.hacerSonido();

    }
}

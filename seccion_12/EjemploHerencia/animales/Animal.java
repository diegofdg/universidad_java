package EjemploHerencia.animales;

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
}
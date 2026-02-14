package Paquetes.aritmetica;

public class Aritmetica {
    int operando1;
    int operando2;

    // Constructor vacio
    public Aritmetica(){
    }

    public Aritmetica(int operando1, int operando2){
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    public void sumar(){
        var resultado = this.operando1 + this.operando2;
        System.out.println("Resultado Suma: " + resultado);
    }

    public void restar(){
        var resultado = this.operando1 - this.operando2;
        System.out.println("Resultado Resta: " + resultado);
    }


}

package aritmetica;

public class Aritmetica {
    
    //Atributos de la clase
    int a;
    int b;
    
    //Constructor Vacio
    //Recordar que si agregamos un constructor distinto al vacio
    //ya no se crea este constructor y nosotros debemos crearlo si lo necesitamos
    Aritmetica(){}
    
    //Constructor con 2 argumentos
    Aritmetica( int arg1 , int arg2){
        a = arg1;
        b = arg2;
    }
    
    //Este metodo toma nuevos valores, no los atributos de la clase
    int sumar(int a, int b){
        return a + b;
    }
    
    //Este metodo toma los atributos de la clase para hacer la suma
    //Agregar mas de un metodo con el mismo nombre se le conoce como
    //sobrecarga de metodos, esto lo estudiaremos mas adelante
    int sumar(){
        return a + b;
    }
    
}

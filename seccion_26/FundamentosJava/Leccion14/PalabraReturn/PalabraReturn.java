package palabrareturn;

public class PalabraReturn {

    public static void main(String[] args) {
        int resultado = sumar(3,6);
        System.out.println("Resultado:" + resultado);
        
    }
    
    public static int sumar(int a, int b){
        return a + b;
    }
}

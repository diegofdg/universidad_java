import java.util.ArrayList;
import java.util.List;

public class Genericos {
    public static void main(String[] args) {
        List<String> miLista = new ArrayList<>();
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sabado");
        miLista.add("Domingo");

        for(String elemento: miLista){
            System.out.println("Dia de la semana: " + elemento );
        }


    }
}

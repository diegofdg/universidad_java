package manejocoleccionesgenericas;

import java.util.*;

public class ManejoColeccionesGenericas {

    public static void main(String[] args) {
        List<String> miLista = new ArrayList<>();
        miLista.add("1");
        miLista.add("2");
        miLista.add("3");
        miLista.add("4");
        miLista.add("4");
        imprimir(miLista);

        Set<String> miSet = new HashSet<>();
        miSet.add("100");
        miSet.add("200");
        miSet.add("300");
        miSet.add("300");
        imprimir(miSet);

        Map<String, String> miMapa = new HashMap<>();
        miMapa.put("1", "Juan");
        miMapa.put("2", "Carlos");
        miMapa.put("3", "Rosario");
        miMapa.put("4", "Esperanza");
        imprimir(miMapa.keySet());
        imprimir(miMapa.values());
    }

    static void imprimir(Collection<String> col) {
        for (String elemento : col) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}

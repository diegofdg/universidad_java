package concursantes;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Audiencia {

    public void monitorearShow(ProceedingJoinPoint joinpoint) {
        try {
            System.out.println("El show esta por comenzar, favor de tomar asiento...");
            System.out.println("Favor de apagar celulares...");

            //Anotamos la hora de inicio
            long horaInicio = System.currentTimeMillis();

            //Se llama al metodo de negocio (metodo objetivo)
            joinpoint.proceed();

            Thread.sleep(1000); //1 segundo
            //Este delay en milisegundos es opcional y se puede poner en los metodos
            //de negocio para simular la duracion del metodo

            long horaTermino = System.currentTimeMillis();

            System.out.println("El show ha termiado, aplausos");
            System.out.println("El show tuvo una duracion:" + (horaTermino - horaInicio));
        } catch (Throwable t) {
            System.out.println("El show fue terrible, se devolveran las entradas");
        }
    }
}
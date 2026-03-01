package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.assertEquals;

import concursantes.Concursante;
import concursantes.Malabarista;

public class TestConcursoTalentos {

    private final Logger log = LogManager.getRootLogger();
    private Concursante malabarista1;
    private Concursante malabarista2;

    @Before
    public void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        malabarista1 = (Concursante) ctx.getBean("solei");
        malabarista2 = (Concursante) ctx.getBean("soleiRecitador");
    }

    @Test
    public void testMalabarista() {
        log.info("Inicio de ejecutar Malabarista");

        int noPelotas = 10;
        malabarista1.ejecutar();
        assertEquals(noPelotas, ((Malabarista) malabarista1).getPelotas());

        log.info("Fin de Ejecutar Malabarista");

        log.info("Inicio de ejecutar MalabaristaRecitador");

        noPelotas = 15;
        malabarista2.ejecutar();
        assertEquals(noPelotas, ((Malabarista) malabarista2).getPelotas());

        log.info("Fin de Ejecutar MalabaristaRecitador");
    }
}

package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import concursantes.Adivinador;
import concursantes.Pensador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMago {

    private final Logger logger = LogManager.getRootLogger();

    @Autowired
    private Pensador voluntario;

    @Autowired
    private Adivinador mago;

    @Test
    public void testMagoAdivinador() {
        String pensamiento = "Hoy ganare la loteria";
        logger.info("Inicio de la adivinacion");
        voluntario.pensarEnAlgo(pensamiento);
        assertEquals(pensamiento, mago.getPensamientos());
        logger.info("Fin de Adivinacion");
    }
}
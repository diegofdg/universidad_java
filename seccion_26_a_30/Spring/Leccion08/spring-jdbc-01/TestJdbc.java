package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:datasource-test.xml"})
public class TestJdbc {

    private final Logger logger = LogManager.getRootLogger();
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbc() {
        logger.info("Inicio del test Jdbc");
        String sql = "select count(*) from persona";
        int noPersonas = jdbcTemplate.queryForObject(sql, Integer.class);

        logger.info("Numero de personas:" + noPersonas);

        assertEquals(3, noPersonas);

        logger.info("Fin del test Jdbc");

    }
}


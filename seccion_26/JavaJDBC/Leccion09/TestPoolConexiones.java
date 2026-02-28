package poolconexiones;

import capadatos.pool.PoolConexionesMySql;
import capadatos.pool.PoolConexionesOracle;
import java.sql.*;

public class TestPoolConexiones {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            //Probamos el pool de MySql
            //y ejecutamos una consulta
            conn = PoolConexionesMySql.getConexion();
            System.out.println("Utilizamos el pool de conexiones de MySql");
            stmt = conn.prepareStatement("SELECT * FROM persona");
            rs = stmt.executeQuery();
            while(rs.next()){
                System.out.print(" " + rs.getInt(1));//id_persona
                System.out.print(" " + rs.getString(2));//nombre
                System.out.println(" " + rs.getString(3));//apellido
            }
            //Cerramos la conexion para regresarla al pool
            conn.close();
            
             //Probamos el pool de Oracle
            //y ejecutamos una consulta
            conn = PoolConexionesOracle.getConexion();
            System.out.println("Utilizamos el pool de conexiones de Oracle");
            stmt = conn.prepareStatement("SELECT * FROM employees WHERE employee_id in(100,101,102)");
            rs = stmt.executeQuery();
            while(rs.next()){
                System.out.print(" " + rs.getInt(1));//empleado_id
                System.out.print(" " + rs.getString(2));//nombre
                System.out.println(" " + rs.getString(3));//apellido
            }
                        //Cerramos la conexion para regresarla al pool
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}

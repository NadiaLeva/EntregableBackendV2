package BD;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Conexion {

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");

    }
}

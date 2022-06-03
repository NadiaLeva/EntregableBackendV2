package DAO;

import BD.Conexion;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAO implements IDao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDAO.class);
    private Connection connection = null;

    private final static String SQL_INSERT = "INSERT INTO ODONTOLOGOS (nombre, apellido ,matricula)" +
            " VALUES (?,?,?)";
    private final static String SQL_SELECT = "SELECT * FROM ODONTOLOGOS";

    public OdontologoDAO(){
        File log4jProperties = new File("src/Test/log4j.properties");
        PropertyConfigurator.configure(log4jProperties.getAbsolutePath());
    }

    public Odontologo guardar(Odontologo odontologo) throws SQLException {

        try{
            connection = Conexion.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getMatricula());

            preparedStatement.executeUpdate();
            preparedStatement.close();

            logger.debug("Se guardaron los datos del odontologo en la base de datos");

        } catch (Exception exception) {
            logger.error("Error: ", exception);
        }finally {
            connection.close();
        }
        return odontologo;
    }

    public List<Odontologo> listar() throws SQLException {

        List<Odontologo> ODONTOLOGOS = new ArrayList<>();

        try{

            connection = Conexion.getConnection();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT);

            while (rs.next())
            {

                Long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String matricula = rs.getString("matricula");

                Odontologo odontologo = new Odontologo();
                odontologo.setId(id);
                odontologo.setNombre(nombre);
                odontologo.setApellido(apellido);
                odontologo.setMatricula(matricula);

                ODONTOLOGOS.add(odontologo);
            }

            st.close();
            logger.debug("Listado de odontologos encontrados");
        }catch(Exception exception){
            logger.error("Error: ", exception);
        }finally {
            connection.close();
        }

        return ODONTOLOGOS;
    }
}

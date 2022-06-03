package Test;

import DAO.IDao;
import DAO.OdontologoDAO;
import model.Odontologo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import service.OdontologoServicio;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OdontologoServicioTest {

    @Test
    // Se verifica que al ingresar un nuevo odontologo, el campo apellido esté bien cargado
    public void testPositivoBuscaEnBD() throws SQLException {
        OdontologoServicio ingresarOdonto = new OdontologoServicio();

        Odontologo odontologo4 = new Odontologo();
        odontologo4.setNombre("Pepito");
        odontologo4.setApellido("Martinez");
        odontologo4.setMatricula("889955");

        OdontologoServicio odontologoServicio = new OdontologoServicio();
        odontologoServicio.setOdontologoIDao(new OdontologoDAO());
        odontologoServicio.guardar(odontologo4);

        assertEquals(odontologo4.getApellido(),"Martinez");
    }


    @Test
    // Se verifica que al ingresar un nuevo odontologo, el campo apellido no sea el del test anterior
    public void testNegativoBuscaEnBD() throws SQLException {
        OdontologoServicio ingresarOdonto = new OdontologoServicio();

        Odontologo odontologo5 = new Odontologo();
        //odontologo.setId(4);
        odontologo5.setNombre("Michael");
        odontologo5.setApellido("Fox");
        odontologo5.setMatricula("845678");

        OdontologoServicio odontologoServicio = new OdontologoServicio();
        odontologoServicio.setOdontologoIDao(new OdontologoDAO());
        odontologoServicio.guardar(odontologo5);

        assertNotEquals(odontologo5.getApellido(), "Martinez");

    }
}
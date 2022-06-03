package Test;

import DAO.IDao;
import DAO.OdontologoDAO;
import model.Odontologo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import service.OdontologoServicio;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OdontologoServicioTest {

    @Test
    public void buscaEnBD(){
        OdontologoServicio ingresarOdonto = new OdontologoServicio();
        Odontologo miOdontologo = ingresarOdonto.guardar(1,"Pepito", "Martinez","334455");
        assertEquals(miOdontologo.getApellido(),"Martinez");
    }

    //@org.junit.jupiter.api.Test
    //void guardar() {
    //}

    //@org.junit.jupiter.api.Test
    //void listar() {
    //}
}
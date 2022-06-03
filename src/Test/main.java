package Test;

import model.Odontologo;
import service.OdontologoServicio;
import DAO.OdontologoDAO;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.sql.SQLException;
import java.util.List;


public class main {

    public static void main(String[] args) throws SQLException {

        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("Sabrina");
        odontologo.setApellido("Lerman");
        odontologo.setMatricula("889955");

        OdontologoServicio odontologoServicio = new OdontologoServicio();
        odontologoServicio.setOdontologoIDao(new OdontologoDAO());
        odontologoServicio.guardar(odontologo);

        Odontologo odontologo2 = new Odontologo();
        odontologo2.setNombre("Arik");
        odontologo2.setApellido("Lerman");
        odontologo2.setMatricula("556677");

        OdontologoServicio odontologoServicio2 = new OdontologoServicio();
        odontologoServicio2.setOdontologoIDao(new OdontologoDAO());
        odontologoServicio2.guardar(odontologo2);

        Odontologo odontologo3 = new Odontologo();
        odontologo3.setNombre("Pablo");
        odontologo3.setApellido("Carrascal");
        odontologo3.setMatricula("667788");

        OdontologoServicio odontologoServicio3 = new OdontologoServicio();
        odontologoServicio3.setOdontologoIDao(new OdontologoDAO());
        odontologoServicio3.guardar(odontologo3);

        // Genera el listado de la tabla ODONTOLOGOS a partir del servicio

        List<Odontologo> odontologoList = odontologoServicio.listar();

        for(Odontologo odt : odontologoList){
            System.out.println(odt.getNombre() + " " + odt.getApellido() + " " + odt.getMatricula());
        }

    }

}


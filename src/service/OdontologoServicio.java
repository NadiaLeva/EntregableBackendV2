package service;

import DAO.IDao;
import model.Odontologo;

import java.sql.SQLException;
import java.util.List;

public class OdontologoServicio {

    private IDao<Odontologo> odontologoIDao;

    private IDao<Odontologo> getOdontologoIDao(){
        return odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao){
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardar(Odontologo odontologo) throws SQLException{
        return this.odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listar() throws SQLException {
        return this.odontologoIDao.listar();
    }
}

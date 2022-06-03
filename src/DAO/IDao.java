package DAO;

import java.sql.SQLException;
import java.util.List;

public interface IDao <T> {
    public T guardar(T t) throws SQLException;
    public List<T> listar() throws SQLException;
}

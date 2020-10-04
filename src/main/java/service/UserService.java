package service;

import exception.DBException;
import model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> getAllUsers() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(User user);

    User getUser(int id);

    void createTable() throws DBException, SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException;
}

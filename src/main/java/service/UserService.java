package service;

import exception.DBException;
import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public List<User> getAllUsers() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(User user);

    public User getUser(int id);

    public void createTable() throws DBException, SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException;
}

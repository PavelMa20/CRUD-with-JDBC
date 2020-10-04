package service;

import dao.UserDAO;
import exception.DBException;
import model.User;

import java.sql.SQLException;
import java.util.List;

import static util.DBhelper.getMysqlConnection;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl() {
        try {
            userDAO = new UserDAO(getMysqlConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public boolean addUser(User user) {
        try {
            userDAO.addUser(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateUser(User user) {

        try {
            userDAO.updateUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(User user) {
        try {
            userDAO.deleteUser(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User getUser(int id) {
        try {
            return userDAO.getUserById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cleanUp() throws DBException, SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        try {
            userDAO.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void createTable() throws DBException, SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        try {
            userDAO.createTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}

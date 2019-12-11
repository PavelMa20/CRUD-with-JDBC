package service;

import dao.UserDAO;
import exception.DBException;
import model.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    public List<User> getAllUsers() {
        try {
            return getUserDAO().getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }

    public boolean addUser(User user){
        try{
            getUserDAO().addUser(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean updateUser(String login,String name,String password){

        try {
          getUserDAO().updateUser(login,name,password);
          return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteUser(String login) {
        try {
            getUserDAO().deleteUser(login);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean validateUser(String login){
        try {
            if (getUserDAO().getUserByLogin(login)!=null);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public void cleanUp() throws DBException {
        UserDAO dao = getUserDAO();
        try {
            dao.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
    public void createTable() throws DBException{
        UserDAO dao = getUserDAO();
        try {
            dao.createTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("crudproject?").          //db name
                    append("user=root&").          //login
                    append("password=root");       //password

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static UserDAO getUserDAO() {

        return new UserDAO( getMysqlConnection());
    }
}

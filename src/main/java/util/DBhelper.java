package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBhelper {
    public static Connection getMysqlConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

        StringBuilder url = new StringBuilder();
        url.
                append(PropertyReader.getProperty("db.type")).
                append("://").
                append(PropertyReader.getProperty("db.host")).
                append(":").
                append(PropertyReader.getProperty("db.port")).
                append("/").
                append(PropertyReader.getProperty("db.name")).
                append("?").
                append("user=").
                append(PropertyReader.getProperty("db.user")).
                append("&").
                append("password=").
                append(PropertyReader.getProperty("db.password")).
                append("&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");               //password


        System.out.println("URL: " + url + "\n");

        Connection connection = DriverManager.getConnection(url.toString());
        return connection;
    }
}

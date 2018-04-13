/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnx;

/**
 *
 * @author user
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    String url = "jdbc:mysql://localhost:3306/pidev1";
    String login = "root";
    String password = "";
    private Connection connection;
    private static DataSource insatance;

    public DataSource() {
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DataSource getInsatance() {
        if (insatance == null) {
            insatance = new DataSource();
        }
        return insatance;
    }

}

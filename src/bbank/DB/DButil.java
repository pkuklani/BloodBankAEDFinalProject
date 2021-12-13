package bbank.DB;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akhil
 */
public class DButil implements DBConnection {

    //private String dburl = "jdbc:sqlserver://localhost:1433;databaseName=bank";
    private String dburl = "jdbc:sqlserver://localhost:1433;databaseName=master";
    private String user = "SA";
    private String pass = "Mypass@word1";

    public DButil() {

        this.dburl = dburl;
        this.pass = pass;
        this.user = user;

    }

    public Connection getConnection() {

        try {
            Connection conn = DriverManager.getConnection(dburl, user, pass);
            System.out.println(" dbutil Connected to database !");
            return conn;
        } catch (SQLException ex) {
            System.out.println(" dbutil catch not Connected to database !");
            Logger.getLogger(DButil.class.getName()).log(Level.SEVERE, null, ex);

        }

        return null;
    }

}

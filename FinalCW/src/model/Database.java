//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private Connection conn;
    private static Database db = null;
    private final String USER = "postgres";
    private final String PASSWORD = "apple";
    private final String DBNAME = "exampleOOP";
    private final String PORT = "5432";
    private final String HOST = "localhost";

    private Database() {
        try {
            this.setConn(DriverManager.getConnection("jdbc:postgresql://"+HOST+":"+PORT+"/"+DBNAME,USER,PASSWORD));
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

    }

    public static Database getInstance() {
        return db != null ? db : new Database();
    }

    public ResultSet query(String query) {
        ResultSet rs = null;

        try {
            rs = this.getConn().createStatement().executeQuery(query);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return rs;
    }

    public Connection getConn() {
        return this.conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}

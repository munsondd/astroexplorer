package engine.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAdapter {

    private String path;
    private String jdbc;

    public DatabaseAdapter(String filename) {
        this.path = filename;
        this.jdbc = "jdbc:sqlite:" + filename;

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            // could not find a JDBC adapter
            // warn user that sessions will not be saved
        }
    }

    public void save() {

    }

    public void load() {

    }

    private Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(this.jdbc);
        } catch(SQLException e) {

        }
    }

}

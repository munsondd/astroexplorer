package engine.database;

import java.sql.*;

public class DatabaseAdapter {

    private String path;
    private String jdbc;

    public DatabaseAdapter(String filename) {
        this.path = filename;
        this.jdbc = "jdbc:sqlite:" + filename;

        try {
            Class.forName("org.sqlite.JDBC");

            Statement statement = this.createStatement();
            // attempt to create a table regardless of if one exists or not
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS jsonmap (id integer, json string)");
        } catch (SQLException | ClassNotFoundException e) {
            // could not find a JDBC adapter
            // warn user that sessions will not be saved
            System.out.print("WARNING: SQLite driver failed to load. Game state will not be saved.");
            e.printStackTrace();
        }
    }

    /**
     * Update a keyed row with a new value.
     *
     * @param key the key to find a row by
     * @param value the value to update to
     * @return whether or not the update succeeded
     */
    public boolean set(KeySpecifier key, String value) {
        try {
            Statement statement = this.createStatement();
            statement.executeUpdate("DELETE FROM jsonmap WHERE id=" + key.ordinal());
            statement.executeUpdate("INSERT INTO jsonmap VALUES(" + key.ordinal() + ", '" + value + "')");
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Obtain a value from a row using a specified key.
     *
     * @param key the key to lookup the value by
     * @return the value stored in the row
     */
    public String get(KeySpecifier key) {
        try {
            Statement statement = this.createStatement();
            ResultSet rs = statement.executeQuery("SELECT json FROM jsonmap WHERE id=" + key.ordinal());
            // we only care about the first entry, because they are unique
            rs.next();
            return rs.getString("json");
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Statement createStatement() throws SQLException {
        return this.getConnection().createStatement();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.jdbc);
    }

    public String getPath() {
        return this.path;
    }

}

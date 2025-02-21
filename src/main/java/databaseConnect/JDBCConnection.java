package databaseConnect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
public class JDBCConnection {
    private static final String HOST = "86.57.161.116";
    private static final String DB_NAME = "register_office";
    private static final String URL = "jdbc:postgresql://" + HOST + ":50432/" + DB_NAME;
    private static final String USER = "user";
    private static final String PASSWORD = "user_senla";
    private static Connection con = null;
    private static final Logger log = LogManager.getLogger(JDBCConnection.class);

    public static Connection connectToDB() {
        log.info("Connecting to DB at " + URL + " with user " + USER);

        try {
            if (con == null || con.isClosed()) {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(URL, USER, PASSWORD);
                log.info("Connection to DB successful!");
            }
        } catch (ClassNotFoundException e) {
            log.error("PostgreSQL driver not found: " + e.getMessage());
        } catch (SQLException sqlEx) {
            log.error("Connection to DB failed!\n" + sqlEx.getMessage());
        }
        return con;
    }
    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                log.info("Connection to DB closed successfully!");
            }
        } catch (SQLException se) {
            log.error("Failed to close the connection. Reason:\n " + se.getMessage());
        }
    }
    public static ResultSet selectFromTable(String query) {
        try (Statement stmt = connectToDB().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            log.info("Sending request to DB: " + query);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs;
            }
        } catch (SQLException se) {
            log.error("Error during select operation: " + se.getMessage());
        }
        return null;
    }
    public static void insertIntoTable(String query) {
        try (Statement stmt = connectToDB().createStatement()) {
            log.info("Sending request to DB: " + query);
            stmt.executeUpdate(query);
            log.info("New data inserted into the table successfully");
        } catch (SQLException se) {
            log.error("Data was not inserted into the table. Reason:\n " + se.getMessage());
        }
    }
    public static void updateInTable(String query) {
        try (Statement stmt = connectToDB().createStatement()) {
            log.info("Sending request to DB: " + query);
            stmt.executeUpdate(query);
            log.info("Data in the table updated successfully");
        } catch (SQLException se) {
            log.error("Data in the table was not updated. Reason:\n " + se.getMessage());
        }
    }
    public static void deleteFromTable(String query) {
        try (Statement stmt = connectToDB().createStatement()) {
            log.info("Sending request to DB: " + query);
            stmt.executeUpdate(query);
            log.info("Data deleted from the table successfully");
        } catch (SQLException se) {
            log.error("Data was not deleted from the table. Reason:\n " + se.getMessage());
        }
    }
}

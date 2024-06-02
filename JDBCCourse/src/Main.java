import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Import package
        Load and register
        Create connection
        Create statement
        Execute connection
        Process the results
        */
        String url = "jdbc:postgresql://localhost:5432/DemoDB";
        String uname= "postgres";
        String pass= "Nath";

        // Class.forName("org.postgresql.Driver"); // No need for this in newer JDBC versions

        // Select query
        String selectSQL = "SELECT sname FROM student WHERE rnumber = 1";

        // Insert query with a unique value for rnumber
        String insertSQL = "INSERT INTO student (rnumber, sname) VALUES (6, 'Arjun')";

        // Establish connection
        Connection con = DriverManager.getConnection(url, uname, pass);

        // Execute select query
        Statement selectStmt = con.createStatement();
        ResultSet result = selectStmt.executeQuery(selectSQL);

        // Execute insert statement
        Statement insertStmt = con.createStatement();
        int rowsAffected = insertStmt.executeUpdate(insertSQL);

        // Process the result of the select query
        while (result.next()) {
            System.out.println("Student Name: " + result.getString("sname"));
        }

        System.out.println("Insert operation successful, rows affected: " + rowsAffected);
        System.out.println("Connection established");

        // Close resources
        result.close();
        selectStmt.close();
        insertStmt.close();
        con.close();
    }
}

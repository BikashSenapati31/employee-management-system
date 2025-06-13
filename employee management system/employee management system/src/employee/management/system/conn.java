package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

 class Conn {

    Connection connection;
    Statement statement;

    public Conn() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeemanagement",
                    "root",
                    "Bikashsenapati2004@"
            );

            // Create statement object
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconfig
{
    public static final String url = "jdbc:sqlserver://localhost:1433;databaseName=GARAGE;integratedSecurity=true;encrypt=true;trustServerCertificate=true";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url);
    }
}

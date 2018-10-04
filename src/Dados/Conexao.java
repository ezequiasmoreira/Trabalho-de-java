package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException{
        if (connection==null){
            connection=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/trabalho_java", 
                    "root", 
                    "root");
        }
        return connection;
    }
}

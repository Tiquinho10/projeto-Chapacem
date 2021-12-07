package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private short port;
    private String hostname;
    private String database;
    private String username;
    private String password;
    
    private Connection connection;

    public DataSource(){
        try{
       this.port = 3306;
       this.database = "chapaCem";
       this.hostname = "localhost";
       this.username = "root";
       this.password = "root";

       String URL = "jdbc:mysql://"+hostname+":"+port+"/"+database;

       DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

       connection = DriverManager.getConnection(URL, username, password);

       System.out.println("deu certo...");
        }catch(SQLException e){

            System.err.println("erro ao connectar " + e.getMessage());
        }catch(Exception e){
            System.err.println("erro geral");
        }

        
    }

    public Connection getConnection(){
        return this.connection;
   }
    
   public void closeDataSource(){
    try{
    connection.close();
    }catch(Exception ex){
         System.err.println("erro ao desconectar " + ex.getMessage());
    }
}
}

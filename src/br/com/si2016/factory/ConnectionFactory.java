package br.com.si2016.factory;


 
// faz as importações de classes necessárias para o funcionamento do programa 
import java.sql.Connection; 
// conexão SQL para Java 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
// driver de conexão SQL para Java 
import java.sql.SQLException; 
// classe para tratamento de exceções 
public class ConnectionFactory {
     private static Connection con = null;
    
    public static Connection getConnection() 
     {
        try 
        {
               return DriverManager.getConnection("jdbc:mysql://localhost/sistemasdistribuidos","newuser","root");
        }         
        catch(SQLException excecao) 
        {
           throw new RuntimeException(excecao);
        }
     }
    
     
    public static PreparedStatement getPreparedStatement(String sql){
        // testo se a conexão já foi criada
        if (con == null){
            // cria a conexão
            con = getConnection();
        }
        try {
            // retorna um objeto java.sql.PreparedStatement
            return con.prepareStatement(sql);
        } catch (SQLException e){
            System.out.println("Erro de sql: "+
                    e.getMessage());
        }
        return null;
    }
}
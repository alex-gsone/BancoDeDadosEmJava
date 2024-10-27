/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.SQLException;

/**
 *
 * @author alex
 */
public class Conexao {
    
    public Connection getConnection() throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/cursojava";
        String user = "postgres";
        String password = "777888";
        
 //     Estabelece a conexão com o banco de dados
        Connection conexao = DriverManager.getConnection(url, user, password);       
        return conexao;        
    } 
}

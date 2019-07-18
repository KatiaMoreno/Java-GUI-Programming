/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.collegeit.dal;
import java.sql.*;
/**
 *
 * @author Katia Moreno Student Number 2015255
 * @since July 2018
 */
public class ModuloConexao {
    // method responsible for establishing a connection to the database
    public static Connection conector(){
        java.sql.Connection conexao = null;
        //the line below calls the drive
        String db ="dbcollege" ;
        
        //storing information about the database
        String url = "jdbc:mysql://localhost/"+db+"?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "";
        // establishing a database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //the next line use to check the error
            //System.out.println(e);
            return null;
        }
    }
}

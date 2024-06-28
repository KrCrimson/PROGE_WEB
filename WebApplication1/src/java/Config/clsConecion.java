/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.*; 

/**
 *
 * @author HP
 */
public class clsConecion {

   Connection con=null;
    
    public clsConecion(){
        
    try{
        Class.forName("com.mysql.jdbc.Driver");
         //con=DriverManager.getConnection("jdbc:mysql://172.30.106.17/mesa_de_partes","usuario1","1234");
         con = DriverManager.getConnection("jdbc:mysql://localhost/dbagencia", "root", "");
    }catch(ClassNotFoundException | SQLException e){
        
    }
}
    public Connection getConnection(){
        return con;
    }
    
}

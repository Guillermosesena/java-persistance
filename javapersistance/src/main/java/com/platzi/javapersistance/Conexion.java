/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.javapersistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//jdbc:mysql://localhost:3307/mensajes_app
//root

/**
 *
 * @author g.sesena.pascacio
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3307/mensajes_app";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public Connection get_Connection(){
          
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(SQLException e){
            System.out.println(e);
        }
        return connection; 
    }
    
}

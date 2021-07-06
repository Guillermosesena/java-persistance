/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.javapersistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author g.sesena.pascacio
 */
public class MensajesDAO {
    
    public static void crearMensajesDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_Connection()){
            PreparedStatement ps = null;
            try{
               String query = "INSERT INTO mensajes "
                       + "(mensaje, autor_mensaje) "
                       + "VALUES (?,?)";
               ps=conexion.prepareStatement(query);
               ps.setString(1, mensaje.getMensaje());
               ps.setString(2, mensaje.getAutor_mensaje());
               ps.executeUpdate();
               System.out.println("Message created");
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void leerMensajesDB(){
        Conexion db_connect = new Conexion();
        
        PreparedStatement ps=null;
        ResultSet rs= null;
 
        try(Connection conexion = db_connect.get_Connection()){
            String query="SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id_mensaje"));
                System.out.println("Mensajes: " + rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println("");
            }
            
        }catch(SQLException e){
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(e);
        }
    }
    
    public static void borrarMensajesDB(int id_mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_Connection()){
        PreparedStatement ps=null;  
            try{
                String query="DELETE FROM mensajes WHERE id_mensaje = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("The message was deleted");
            }catch(SQLException e){
                System.out.println(e);
                System.out.println("I wasnt possible to delete that message");
            }
        }catch(SQLException e){
        
        }
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        
        ResultSet rs= null;
 
        try(Connection conexion = db_connect.get_Connection()){
            PreparedStatement ps=null;
                  
            try{
                String query="UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Message was update");
            }catch(SQLException ex){
                System.out.print(ex);
                System.out.println("It wansn't possible to update the message");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}

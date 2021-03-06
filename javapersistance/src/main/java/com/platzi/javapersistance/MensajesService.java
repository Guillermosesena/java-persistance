/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.javapersistance;

import java.util.Scanner;

/**
 *
 * @author g.sesena.pascacio
 */
public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your message");
        String mensaje = sc.nextLine();
        
        System.out.println("Your name");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        
        MensajesDAO.crearMensajesDB(registro);
        
        
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
    
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write ID of message tha you want to delete");
        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensajesDB(id_mensaje);
    }
    
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the message again");
        String mensaje = sc.nextLine();
        
        System.out.println("Write the id of the message to update");
       int id_mensaje = sc.nextInt();
        
        Mensajes actualizacion = new Mensajes();
        actualizacion.setMensaje(mensaje);
        actualizacion.setId_mensaje(id_mensaje);
        MensajesDAO.actualizarMensajeDB(actualizacion);   
    }
    
}

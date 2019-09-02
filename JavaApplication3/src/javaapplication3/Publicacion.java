/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Publicacion {
    public static final String TABLA = "Publicacion";
    private int id;
    private String publicacion;
    private int idUsuario;
    private String fecha;
   
    public Publicacion(){
    
}
  public Publicacion(int id, String publicacion, int idUsuario, String fecha ) {
        this.id = id;
        this.publicacion= publicacion;
        this.idUsuario=idUsuario;
        this.fecha=fecha;
  }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPublicacion(){
        return publicacion;
    }
    public void setPublicacion(String publicacion){
        this.publicacion=publicacion;
    }
    public int getIdUsuario(){
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario){
        this.idUsuario=idUsuario;
    }
    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha=fecha;
    }
    public int create() throws ClassNotFoundException, SQLException{
       String query = "INSERT INTO " + Publicacion.TABLA + "(publicacion, idUsuarios) " +
                "value(?,?)"; 
        Connection connection = DB.getConnection(); 
        PreparedStatement sp = connection.prepareStatement(query);
        
        sp.setString(1, this.getPublicacion());
        sp.setInt(2, VLogin.usuarioLogin);
        
        int result = sp.executeUpdate();
        connection.close();
        return result; 
    }
    public static ArrayList<Publicacion> publicasiones(int idUsuario) throws ClassNotFoundException, SQLException{
        //String query = "SELECT publicacion, hora "+ Publicacion.TABLA + " WHERE "+ "(publicacion.idUsuario= " + VPerfil.perfilVisto + ") " +
         //       "value(?,?)"; 
        String query = "SELECT * FROM publicacion WHERE idUsuarios = ?;";
        Connection connection = DB.getConnection(); 
        PreparedStatement sp = connection.prepareStatement(query);
        
        sp.setInt(1, idUsuario);
        
        ResultSet result = sp.executeQuery();
        ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
        while(result.next()) {
            Publicacion publicacion = new Publicacion();
            publicacion.setId(result.getInt("id"));
            publicacion.setPublicacion(result.getString("publicacion"));
            publicacion.setFecha(result.getString("hora"));
            publicaciones.add(publicacion);
        }
        connection.close();
        return publicaciones; 
    }
}

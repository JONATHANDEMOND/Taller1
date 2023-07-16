/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class ConexionBDD {
     private static final String JDBC_URL="jdbc:mysql://localhost:3306/proyectoviajes?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="admin";
    
    //metodo para obtener el objeto de conexion
    public static Connection getConnection() throws SQLException{  //metodo return de tipo Connection  //extender la excepcion
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); //driveManager para obtner el objeto de tipo Connection
    }
    
    //metodo que cierra los objetos de conexion
    //sobrecarga de constructores
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(PreparedStatement stmt) throws SQLException{
        stmt.close();
        
    }
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}


package com.mycompany.modelo;

import java.sql.*;
import java.util.ArrayList;




public class ClienteEmpDAOimpl  implements ClienteEmpDAO{
    
    private static final String SQL_INSERT = "INSERT INTO CLIENTES (nombre, apellido, correo, cedula, destino, fecha_salida, fecha_regreso, transporte_aprox, num_adultos, num_kids, num_mayores, hotel,  alimentacion, transporte_local, guia, lugares_recreacion, precio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM CLIENTES";

    @Override
    public ArrayList<ClienteEmpDTO> select() {
        ArrayList<ClienteEmpDTO> clientes= new ArrayList();
        try {
            Connection conn = ConexionBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
            ResultSet rs =stmt.executeQuery(); //el registro o los registros que se hayan creado
            //verifica si el objeto tiene registros // -> apuntador
             while(rs.next()){
                 int id=rs.getInt(1);
                 String nombre=rs.getString(2);
                 String apellido=rs.getString(3);
                 String correo=rs.getString(4);
                 String cedula=rs.getString(5);
                 String destino=rs.getString(6);
                 Date fechaSalida=rs.getDate(7);
                 Date fechaRegreso=rs.getDate(8);
                 String transporteAprox=rs.getString(9);
                 int numAdultos=rs.getInt(10);
                 int numKids=rs.getInt(11);
                 int numMayores=rs.getInt(12);
                 String hotel=rs.getString(13);
                 boolean alimentacion=rs.getBoolean(14);
                 boolean transporteLocal=rs.getBoolean(15);
                 boolean guia=rs.getBoolean(16);
                 String lugaresRecreacion=rs.getString(17);
                 double precio=rs.getDouble(18);
                 //Generar Objeto
                 ClienteEmpDTO cliente= new ClienteEmpDTO(id, nombre, apellido, correo, cedula, destino, fechaSalida, fechaRegreso, transporteAprox, numAdultos, numKids, numMayores, hotel, alimentacion, transporteLocal, guia, lugaresRecreacion, precio);
                 //Añadir dentro de la Coleccion
                clientes.add(cliente);
                               
                
             }
             ConexionBDD.close(rs);
             ConexionBDD.close(stmt);
             ConexionBDD.close(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return clientes;
    }

    @Override
    public int insert(ClienteEmpDTO cliente) {
        int registros = 0;
        try {
            Connection conn = ConexionBDD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getCorreo());
            stmt.setString(4, cliente.getCedula());
            stmt.setString(5, cliente.getDestino());
            stmt.setDate(6, cliente.getFechaSalida());
            stmt.setDate(7, cliente.getFechaRegreso());
            stmt.setString(8, cliente.getTransporteAprox());
            stmt.setInt(9, cliente.getNumAdultos());
            stmt.setInt(10, cliente.getNumKids());
            stmt.setInt(11, cliente.getNumMayores());
            stmt.setString(12, cliente.getHotel());
            stmt.setBoolean(13, cliente.isAlimentacion());
            stmt.setBoolean(14, cliente.isTransporteLocal());
            stmt.setBoolean(15, cliente.isGuia());
            stmt.setString(16, cliente.getLugaresRecreacion());
            stmt.setDouble(17, cliente.getPrecio());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace(System.out);
        }
        return registros;
    }
        
    
}

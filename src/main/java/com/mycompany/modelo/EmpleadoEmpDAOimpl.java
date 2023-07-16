
package com.mycompany.modelo;

import java.sql.*;



public class EmpleadoEmpDAOimpl implements EmpleadoEmpDAO{
    
    private static final String SQL_INSERT="INSERT INTO EMPLEADOS (nombre, apellido, usuario, correo, cedula, password) VALUES(?,?,?,?,?,SHA1(?))";
    private static final String SQL_SELECT="SELECT * FROM EMPLEADOS WHERE usuario=? AND password=SHA1(?)";

    @Override
    public boolean select(EmpleadoEmpDTO empleado) {
        try {
            //1. Crear el objeto de conexion
            Connection conn=ConexionBDD.getConnection();
            //2. Crear el objeto que prepare la query
            PreparedStatement stmt=conn.prepareStatement(SQL_SELECT);
            //REEMPLAZAR el valor de las interrogantes
            stmt.setString(1, empleado.getUsuario());
            stmt.setString(2, empleado.getPassword());
            //3. Ejecutar la query
            ResultSet rs= stmt.executeQuery();  //Devolver los registros consultados
            //verificacion si eiste el registro
            if(rs.next()){  //si existe el registro con el usuario y contraseña
                return true;
            }
            //4. Cerrar objetos de conexion
            ConexionBDD.close(rs);
            ConexionBDD.close(stmt);
            ConexionBDD.close(conn);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
         return false;
    }

    @Override
    public int insert(EmpleadoEmpDTO empleado) {
        int registros = 0;
    
        try {
            //1. Crear el objeto de conexion
            Connection conn = ConexionBDD.getConnection();
             //2. Crear el objeto que prepare la query
            PreparedStatement stmt=conn.prepareStatement(SQL_INSERT);
            //Reemplazar el valor de las interrogantes
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(3, empleado.getUsuario());
            stmt.setString(4, empleado.getCorreo());
            stmt.setString(5, empleado.getCedula());
            stmt.setString(6, empleado.getPassword());
          
            //3. Ejecutar la query
            registros=stmt.executeUpdate(); // retorna 1-> si se ejecuto todo bien
            //4. Cerrar objetos de conexion
            ConexionBDD.close(stmt);
            ConexionBDD.close(conn);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return registros;
     }       
    
    
}

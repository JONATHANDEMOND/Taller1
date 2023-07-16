/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlador;

import com.mycompany.modelo.*;

/**
 *
 * @author ASUS
 */
public class ControladorEmpleadoEmp {
    private EmpleadoEmpDAO datos=new EmpleadoEmpDAOimpl();
    public int insertarEmpleado(String nombre, String apellido, String usuario, String correo, String cedula, String password){
         int registros;
         //Generar el objeto
         EmpleadoEmpDTO empleado=new EmpleadoEmpDTO(nombre, apellido, usuario, correo, cedula, password);
         registros=datos.insert(empleado);
        return registros;
    }
    public boolean iniciarSesion(String usuario, String password){
        boolean verificar;
        EmpleadoEmpDTO empleado= new EmpleadoEmpDTO(usuario, password);
        verificar=datos.select(empleado);
        return verificar;
    }
}

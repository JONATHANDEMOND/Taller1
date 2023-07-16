/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.company.controlador;

import com.mycompany.modelo.*;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class ControladorClienteEmp {
    
    ClienteEmpDAO datos =new ClienteEmpDAOimpl();
    public int insertarCliente(String nombre, String apellido, String correo, String cedula, String destino, Date fechaActualSalida, Date fechaActualRegreso, String trasporteAprox, int numAdultos, int numKids, int numMayores, String hotel, boolean alimentacion, boolean transporteLocal, boolean guia, String lugarRecreacion){
        int registros;
        double precio=50;
        //Generar objeto
        ClienteEmpDTO cliente=new ClienteEmpDTO(nombre, apellido, correo, cedula, destino, fechaActualSalida, fechaActualRegreso, trasporteAprox, numAdultos, numKids, numMayores, hotel, alimentacion, transporteLocal, guia, lugarRecreacion, precio);
         registros = datos.;
        return registros;
    }
    
}

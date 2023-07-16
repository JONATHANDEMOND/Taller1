/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlador;

import com.mycompany.modelo.*;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class ControladorClienteEmp {
    
    ClienteEmpDAO datos =new ClienteEmpDAOimpl();
    public int insertarCliente(String nombre, String apellido, String correo, String cedula, String destino, Date fechaActualSalida, Date fechaActualRegreso, String trasporteAprox, int numAdultos, int numKids, int numMayores, String hotel, boolean alimentacion, boolean transporteLocal, boolean guia, String lugarRecreacion, double precio){
        int registros;
        //Generar objeto
        ClienteEmpDTO cliente=new ClienteEmpDTO(nombre, apellido, correo, cedula, destino, fechaActualSalida, fechaActualRegreso, trasporteAprox, numAdultos, numKids, numMayores, hotel, alimentacion, transporteLocal, guia, lugarRecreacion, precio);
         registros = datos.insert(cliente);
        return registros;
    }
     public void listarClientes(DefaultTableModel modelo){
      ArrayList<ClienteEmpDTO> clientes=datos.select(); //registtros objeto
        for (int i = 0; i < clientes.size(); i++) {
            modelo.addRow(new Object[]{
                clientes.get(i).getId(),
                clientes.get(i).getNombre(),
                clientes.get(i).getApellido(),
                clientes.get(i).getCorreo(),
                clientes.get(i).getCedula(),
                clientes.get(i).getDestino(),
                clientes.get(i).getFechaSalida(),
                clientes.get(i).getFechaRegreso(),
                clientes.get(i).getTransporteAprox(),
                clientes.get(i).getNumAdultos(),
                clientes.get(i).getNumKids(),
                clientes.get(i).getNumMayores(),
                clientes.get(i).getHotel(),
                clientes.get(i).isAlimentacion()?"SI":"NO",
                clientes.get(i).isTransporteLocal()?"SI":"NO",
                clientes.get(i).isGuia()?"SI":"NO",
                clientes.get(i).getLugaresRecreacion(),
                clientes.get(i).getPrecio(),
            });
        }
     }
    
}

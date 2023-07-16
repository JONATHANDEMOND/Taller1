
package com.mycompany.modelo;


public class EmpleadoEmpDTO extends PersonaDTO{
    
    private int id;
    private String usuario;
    private String password;
    
    
     //SELECT - EMPLEADOS - INICIO DE SESION
     public EmpleadoEmpDTO(String usuario, String password){
        this.usuario = usuario;
        this.password = password;
    }

    // ISERT EMPLEADO
    public EmpleadoEmpDTO(String nombre, String apellido, String usuario, String correo, String cedula,  String password ) {
        super(nombre, apellido, correo, cedula);
        this.usuario = usuario;
        this.password = password;
    }
    
   
   
    

    public int getId() {
        return id;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
    
    
}

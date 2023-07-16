
package com.mycompany.modelo;


public class PersonaDTO {
    
    private String nombre;
    private String apellido;
    private String correo;
    private String cedula;
    
    public PersonaDTO(){}

    public PersonaDTO(String nombre, String apellido, String correo, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.cedula = cedula;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
    
    
    
}

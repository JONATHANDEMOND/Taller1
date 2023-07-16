
package com.mycompany.modelo;

import java.sql.Date;




public class ClienteEmpDTO extends PersonaDTO{
    
    private int id;
    private String destino;
    private Date fechaSalida;
    private Date fechaRegreso;
    private String transporteAprox;
    private int numAdultos;
    private int numKids;
    private int numMayores;
    private String hotel;
    private boolean alimentacion;
    private boolean transporteLocal;
    private boolean guia;
    private String lugaresRecreacion;
    private double precio;
    
    // constructor 
    public ClienteEmpDTO(){}

    public ClienteEmpDTO(String nombre, String apellido, String correo, String cedula, String destino, Date fechaSalida, Date fechaRegreso, String transporteAprox, int numAdultos, int numKids, int numMayores, String hotel, boolean alimentacion, boolean transporteLocal, boolean guia, String lugaresRecreacion, double precio) {
        super(nombre, apellido, correo, cedula);
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.transporteAprox = transporteAprox;
        this.numAdultos = numAdultos;
        this.numKids = numKids;
        this.numMayores = numMayores;
        this.hotel = hotel;
        this.alimentacion = alimentacion;
        this.transporteLocal = transporteLocal;
        this.guia = guia;
        this.lugaresRecreacion = lugaresRecreacion;
        this.precio = precio;
    }
    
     // SELECT CLIENTE

    public ClienteEmpDTO(int id, String nombre, String apellido, String correo, String cedula, String destino, Date fechaSalida, Date fechaRegreso, String transporteAprox, int numAdultos, int numKids, int numMayores, String hotel, boolean alimentacion, boolean transporteLocal, boolean guia, String lugaresRecreacion, double precio) {
        super(nombre, apellido, correo, cedula);
        this.id = id;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.transporteAprox = transporteAprox;
        this.numAdultos = numAdultos;
        this.numKids = numKids;
        this.numMayores = numMayores;
        this.hotel = hotel;
        this.alimentacion = alimentacion;
        this.transporteLocal = transporteLocal;
        this.guia = guia;
        this.lugaresRecreacion = lugaresRecreacion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }


    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(Date fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public String getTransporteAprox() {
        return transporteAprox;
    }

    public void setTransporteAprox(String transporteAprox) {
        this.transporteAprox = transporteAprox;
    }

    public int getNumAdultos() {
        return numAdultos;
    }

    public void setNumAdultos(int numAdultos) {
        this.numAdultos = numAdultos;
    }

    public int getNumKids() {
        return numKids;
    }

    public void setNumKids(int numKids) {
        this.numKids = numKids;
    }

    public int getNumMayores() {
        return numMayores;
    }

    public void setNumMayores(int numMayores) {
        this.numMayores = numMayores;
    }

    public boolean isAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(boolean alimentacion) {
        this.alimentacion = alimentacion;
    }

    public boolean isTransporteLocal() {
        return transporteLocal;
    }

    public void setTransporteLocal(boolean transporteLocal) {
        this.transporteLocal = transporteLocal;
    }

    public boolean isGuia() {
        return guia;
    }

    public void setGuia(boolean guia) {
        this.guia = guia;
    }

    public String getLugaresRecreacion() {
        return lugaresRecreacion;
    }

    public void setLugaresRecreacion(String lugaresRecreacion) {
        this.lugaresRecreacion = lugaresRecreacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
    
    
}

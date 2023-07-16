
package com.mycompany.modelo;


public interface EmpleadoEmpDAO {
    public abstract boolean select(EmpleadoEmpDTO empleado); //inicio de sesion
    public abstract int insert(EmpleadoEmpDTO empleado);  //insertar empleados
    
}

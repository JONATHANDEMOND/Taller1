
package com.mycompany.modelo;

import java.util.ArrayList;


public interface ClienteEmpDAO {
    
    public abstract ArrayList<ClienteEmpDTO> select();
    
    public abstract int insert(ClienteEmpDTO cliente);
    
}

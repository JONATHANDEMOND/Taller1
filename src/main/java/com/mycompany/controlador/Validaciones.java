
package com.mycompany.controlador;

import java.awt.event.KeyEvent;


public class Validaciones {
    
    public void validarNumeros(KeyEvent evt){
        char caracter=evt.getKeyChar();
        if (Character.isLetter(caracter) ){
            evt.consume(); //deshabilitar caracter que se presione 
        }
        
    }
    
    public void validarLetras(KeyEvent evt){
        char caracter=evt.getKeyChar();
        if(caracter>=33 && caracter<=64
                || caracter>=91 && caracter<=96 
                || caracter>=123 && caracter<=126 ){
            evt.consume(); //deshabilitar caracter que se presione 
        }
    }
    
}

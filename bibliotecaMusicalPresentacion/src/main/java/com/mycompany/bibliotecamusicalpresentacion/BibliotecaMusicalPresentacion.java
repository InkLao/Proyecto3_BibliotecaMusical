/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bibliotecamusicalpresentacion;

import Pantallas.FrmInicio;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author eduar
 */
public class BibliotecaMusicalPresentacion {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        
        String plainPassword = "A";
        String storedHash = "$2a$10$1uk0VEN8pj8De9YRq0HDIuHG0486UN6pqpf.wMq4w/Rv5AjwonIxG";

        boolean isMatch = BCrypt.checkpw(plainPassword, storedHash);
        System.out.println("¿La contraseña coincide?: " + isMatch);
        
        FrmInicio inicio = new FrmInicio();
        inicio.setVisible(true);
    }
}

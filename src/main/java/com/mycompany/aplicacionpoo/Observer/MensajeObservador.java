/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Observer;

/**
 *
 * @author nicol
 */
public class MensajeObservador implements Observer {

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Notificación: " + mensaje);
    }
    
}

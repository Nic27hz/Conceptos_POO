/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Observer.Impl;

import com.mycompany.aplicacionpoo.Observer.Observer;

/**
 *
 * @author nicol
 */
public class EstudianteObserver implements Observer {
    private String nombreObservador;

    public EstudianteObserver(String nombreObservador) {
        this.nombreObservador = nombreObservador;
    }
    
    @Override
    public void actualizar(String mensaje) {
        System.out.println("[" + nombreObservador + "] " + mensaje);
    }
}

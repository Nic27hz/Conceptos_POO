/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo;

import com.mycompany.aplicacionpoo.View.VentanaPrincipal;

public class Escritorio extends Thread {
    
    @Override
    public void run(){
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);
        vp.setLocationRelativeTo(null);
    }
}

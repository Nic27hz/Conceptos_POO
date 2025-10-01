/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl;

import com.mycompany.aplicacionpoo.Factory.Factory;
import com.mycompany.aplicacionpoo.Model.Facultad;
import com.mycompany.aplicacionpoo.Model.Programa;
import java.util.Date;

/**
 *
 * @author nicol
 */
public class ProgramaFactory implements Factory{
    
    @Override
    public Object crearVacio(){
        return new Programa();
    }
    
    public Programa crear(double id, String nombre, double duracion, Date registro, Facultad facultad){
        return new Programa(id, nombre, duracion, registro, facultad);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl;

import com.mycompany.aplicacionpoo.Factory.Factory;
import com.mycompany.aplicacionpoo.Model.Curso;
import com.mycompany.aplicacionpoo.Model.Programa;

/**
 *
 * @author nicol
 */
public class CursoFactory implements Factory{
    
    @Override
    public Object crearVacio(){
        return new Curso();
    }
    
    public Curso crear(int id, String nombre, Programa programa, boolean activo){
        return new Curso(id, nombre, programa, activo);
    }
}

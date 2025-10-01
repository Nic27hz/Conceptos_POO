/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl;

import com.mycompany.aplicacionpoo.Factory.Factory;
import com.mycompany.aplicacionpoo.Model.Curso;
import com.mycompany.aplicacionpoo.Model.Estudiante;
import com.mycompany.aplicacionpoo.Model.Inscripcion;

/**
 *
 * @author nicol
 */
public class InscripcionFactory implements Factory{
    
    @Override
    public Object crearVacio(){
        return new Inscripcion();
    }
    
    public Inscripcion crear(Curso curso, int año, int semestre, Estudiante estudiante){
        return new Inscripcion(curso, año, semestre, estudiante);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl;

import com.mycompany.aplicacionpoo.Factory.Factory;
import com.mycompany.aplicacionpoo.Model.Curso;
import com.mycompany.aplicacionpoo.Model.CursoProfesor;
import com.mycompany.aplicacionpoo.Model.Profesor;

/**
 *
 * @author nicol
 */
public class CursoProfesorFactory implements Factory{
    
    @Override
    public Object crearVacio(){
        return new CursoProfesor();
    }
    
    public CursoProfesor crear(Profesor profesor, int año, int semestre, Curso curso){
        return new CursoProfesor(profesor, año, semestre, curso);
    }
}

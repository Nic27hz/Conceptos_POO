/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl.DTO;

import com.mycompany.aplicacionpoo.DTO.CursoDTO;
import com.mycompany.aplicacionpoo.DTO.CursoProfesorDTO;
import com.mycompany.aplicacionpoo.DTO.ProfesorDTO;
import com.mycompany.aplicacionpoo.Factory.Factory;

/**
 *
 * @author nicol
 */
public class CursoProfesorFactoryDTO implements Factory{
    
    @Override
    public Object crearVacio(){
        return new CursoProfesorDTO();
    }
    
    public CursoProfesorDTO crear(ProfesorDTO profesor, int año, int semestre, CursoDTO curso){
        return new CursoProfesorDTO(profesor, año, semestre, curso);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl.DTO;

import com.mycompany.aplicacionpoo.DTO.CursoDTO;
import com.mycompany.aplicacionpoo.DTO.EstudianteDTO;
import com.mycompany.aplicacionpoo.DTO.InscripcionDTO;
import com.mycompany.aplicacionpoo.Factory.Factory;

/**
 *
 * @author nicol
 */
public class InscripcionFactoryDTO implements Factory{
    
    @Override
    public Object crearVacio(){
        return new InscripcionDTO();
    }
    
    public InscripcionDTO crear(CursoDTO curso, int año, int semestre, EstudianteDTO estudiante){
        return new InscripcionDTO(curso, año, semestre, estudiante);
    }
}

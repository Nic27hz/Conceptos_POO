/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl.DTO;

import com.mycompany.aplicacionpoo.DTO.EstudianteDTO;
import com.mycompany.aplicacionpoo.DTO.ProgramaDTO;
import com.mycompany.aplicacionpoo.Factory.Factory;

/**
 *
 * @author nicol
 */
public class EstudianteFactoryDTO implements Factory {
    
    @Override
    public Object crearVacio(){
        return new EstudianteDTO();
    }
    
    public EstudianteDTO crear(double codigo, ProgramaDTO programa, boolean activo, double promedio){
        return new EstudianteDTO(codigo, programa, activo, promedio);
    }
}

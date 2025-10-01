/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl.DTO;

import com.mycompany.aplicacionpoo.DTO.FacultadDTO;
import com.mycompany.aplicacionpoo.DTO.ProgramaDTO;
import com.mycompany.aplicacionpoo.Factory.Factory;
import java.util.Date;

/**
 *
 * @author nicol
 */
public class ProgramaFactoryDTO implements Factory{
    
    @Override
    public Object crearVacio(){
        return new ProgramaDTO();
    }
    
    public ProgramaDTO crear(double id, String nombre, double duracion, Date registro, FacultadDTO facultad){
        return new ProgramaDTO(id, nombre, duracion, registro, facultad);
    }
}

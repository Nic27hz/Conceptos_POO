/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl.DTO;

import com.mycompany.aplicacionpoo.DTO.FacultadDTO;
import com.mycompany.aplicacionpoo.DTO.PersonaDTO;
import com.mycompany.aplicacionpoo.Factory.Factory;

/**
 *
 * @author nicol
 */
public class FacultadFactoryDTO implements Factory {
    
    @Override
    public Object crearVacio(){
        return new FacultadDTO();
    }
    
    public FacultadDTO crear(double id, String nombre, PersonaDTO decano){
        return new FacultadDTO(id, nombre, decano);
    }
}

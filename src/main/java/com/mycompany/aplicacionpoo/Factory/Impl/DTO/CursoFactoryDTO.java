/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl.DTO;

import com.mycompany.aplicacionpoo.DTO.CursoDTO;
import com.mycompany.aplicacionpoo.DTO.ProgramaDTO;
import com.mycompany.aplicacionpoo.Factory.Factory;

/**
 *
 * @author nicol
 */
public class CursoFactoryDTO implements Factory {
    
    @Override
    public Object crearVacio(){
        return new CursoDTO();
    }
    
    public CursoDTO crear(int id, String nombre, ProgramaDTO programa, boolean activo){
        return new CursoDTO(id, nombre, programa, activo);
    }
}

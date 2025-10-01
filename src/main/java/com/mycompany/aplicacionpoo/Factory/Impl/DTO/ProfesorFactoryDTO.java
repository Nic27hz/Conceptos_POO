/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl.DTO;

import com.mycompany.aplicacionpoo.DTO.ProfesorDTO;
import com.mycompany.aplicacionpoo.Factory.Factory;

/**
 *
 * @author nicol
 */
public class ProfesorFactoryDTO implements Factory {
    
    @Override
    public Object crearVacio(){
        return new ProfesorDTO();
    }
    
    public ProfesorDTO crear(){
        return new ProfesorDTO();
    }
}

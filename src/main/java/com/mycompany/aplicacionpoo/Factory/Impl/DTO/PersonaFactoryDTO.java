/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl.DTO;

import com.mycompany.aplicacionpoo.DTO.PersonaDTO;
import com.mycompany.aplicacionpoo.Factory.Factory;

/**
 *
 * @author nicol
 */
public class PersonaFactoryDTO implements Factory {
    
    @Override
    public Object crearVacio(){
        return new PersonaDTO();
    }
    
    public PersonaDTO crear(double id, String nombres, String apellidos, String email, String tipo){
        return new PersonaDTO(id, nombres, apellidos, email, tipo);
    }
}

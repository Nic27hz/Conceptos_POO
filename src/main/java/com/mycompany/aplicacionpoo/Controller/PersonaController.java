package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.DTO.PersonaDTO;
import com.mycompany.aplicacionpoo.Service.Impl.PersonaDaoImpl;
import com.mycompany.aplicacionpoo.Service.PersonaDao;
import com.mycompany.aplicacionpoo.Factory.Impl.PersonaFactory;
import com.mycompany.aplicacionpoo.Model.Persona;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author nicol
 */
public class PersonaController {
    private final PersonaDao personaDao;
    private final PersonaFactory personaFactory;

    public PersonaController() {
        this.personaDao = new PersonaDaoImpl();
        this.personaFactory = new PersonaFactory();
    }

    public void guardarPersona(int id, String nombre, String apellido, String correo, String tipo){
        
        Persona persona = (Persona) personaFactory.crear();
            persona.setId(id);
            persona.setNombres(nombre);
            persona.setApellidos(apellido);
            persona.setEmail(correo);
            persona.setTipo(tipo);
            
        personaDao.guardarPersona(persona);
    }
    
    public void actualizarPersona(int id, String nombre, String apellido, String correo, String tipo){
        Persona persona = (Persona) personaFactory.crear();
            persona.setId(id);
            persona.setNombres(nombre);
            persona.setApellidos(apellido);
            persona.setEmail(correo);
            persona.setTipo(tipo);
        personaDao.actualizarPersona(persona);
    }
    
    public void eliminarPersona(int id){
        personaDao.eliminarPersona(id);
    }
    
    public ArrayList<Persona> mostrarPersona(){
        return personaDao.mostrarPersona();
    }
    
    public Persona buscarPersona(int id){
        return personaDao.buscarPersona(id);
    }
}

package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.DTO.Mapper.PersonaMapper;
import com.mycompany.aplicacionpoo.DTO.PersonaDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.PersonaFactoryDTO;
import com.mycompany.aplicacionpoo.Service.Impl.PersonaDaoImpl;
import com.mycompany.aplicacionpoo.Service.PersonaDao;

import com.mycompany.aplicacionpoo.Model.Persona;
import com.mycompany.aplicacionpoo.Observer.Impl.PersonaObserver;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
    private final PersonaFactoryDTO personaFactory;

    public PersonaController() {
        this.personaDao = new PersonaDaoImpl();
        this.personaFactory = new PersonaFactoryDTO();
    }

    public void guardarPersona(int id, String nombre, String apellido, String correo, String tipo){
        
        PersonaDTO personaDTO = personaFactory.crear(id, nombre, apellido, tipo, tipo);
        Persona persona = PersonaMapper.toEntity(personaDTO);
            
        personaDao.guardarPersona(persona);
        persona.agregarObservador(new PersonaObserver("Observador Persona"));
        persona.notificar("Se agregó nueva Persona: " + persona.getId() + persona.getNombres() );
    }
    
    public void actualizarPersona(int id, String nombre, String apellido, String correo, String tipo){
        
        PersonaDTO personaDTO = personaFactory.crear(id, nombre, apellido, correo, tipo);
        Persona persona = PersonaMapper.toEntity(personaDTO);
            
        personaDao.actualizarPersona(persona);
        persona.agregarObservador(new PersonaObserver("Observador Persona"));
        persona.notificar("Se actualizó persona con ID: " + persona.getId());
    }
    
    public void eliminarPersona(int id){
        PersonaDTO personaDTO = (PersonaDTO) personaFactory.crearVacio();
        personaDTO.setId(id);
        
        Persona persona = PersonaMapper.toEntity(personaDTO);
        
        personaDao.eliminarPersona(persona);
        persona.agregarObservador(new PersonaObserver("Observador Persona"));
        persona.notificar("Se eliminó persona con ID: " + persona.getId());
    }
    
    public ArrayList<PersonaDTO> mostrarPersona() {
        return personaDao.mostrarPersona()
                .stream()
                .map(PersonaMapper::toDTO)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public PersonaDTO buscarPersona(int id){
        Persona persona = personaDao.buscarPersona(id);
        return PersonaMapper.toDTO(persona);
    }
}

package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.DTO.Mapper.PersonaMapper;
import com.mycompany.aplicacionpoo.DTO.PersonaDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.PersonaFactoryDTO;
import com.mycompany.aplicacionpoo.Service.Impl.PersonaDaoImpl;
import com.mycompany.aplicacionpoo.Service.PersonaDao;
import com.mycompany.aplicacionpoo.Factory.Impl.PersonaFactory;
import com.mycompany.aplicacionpoo.Model.Persona;
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
    }
    
    public void actualizarPersona(int id, String nombre, String apellido, String correo, String tipo){
        
        PersonaDTO personaDTO = personaFactory.crear(id, nombre, apellido, tipo, tipo);
        Persona persona = PersonaMapper.toEntity(personaDTO);
            
        personaDao.actualizarPersona(persona);
    }
    
    public void eliminarPersona(int id){
        personaDao.eliminarPersona(id);
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

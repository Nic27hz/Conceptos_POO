/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO.Mapper;

import com.mycompany.aplicacionpoo.DTO.PersonaDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.PersonaFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.PersonaFactory;
import com.mycompany.aplicacionpoo.Model.Persona;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nicol
 */
public class PersonaMapper {

    private static final PersonaFactory personaFactory = new PersonaFactory();
    private static final PersonaFactoryDTO personaFactoryDTO = new PersonaFactoryDTO();

    public static Persona toEntity(PersonaDTO dto) {
        if (dto == null) return null;

        Persona persona = (Persona) personaFactory.crear();
        persona.setId(dto.getId());
        persona.setNombres(dto.getNombres());
        persona.setApellidos(dto.getApellidos());
        persona.setEmail(dto.getEmail());
        persona.setTipo(dto.getTipo());

        return persona;
    }

    public static PersonaDTO toDTO(Persona persona) {
        if (persona == null) return null;
        PersonaDTO dto = (PersonaDTO) personaFactoryDTO.crearVacio();
        dto.setId(persona.getId());
        dto.setNombres(persona.getNombres());
        dto.setApellidos(persona.getApellidos());
        dto.setEmail(persona.getEmail());
        dto.setTipo(persona.getTipo());
        
        return dto;
    }
    
    public static List<PersonaDTO> toDTOList(List<Persona> personas) {
        if (personas == null) return null;
        return personas.stream()
                .map(PersonaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Persona> toEntityList(List<PersonaDTO> dtos) {
        if (dtos == null) return null;
        return dtos.stream()
                .map(PersonaMapper::toEntity)
                .collect(Collectors.toList());
    }
    
}


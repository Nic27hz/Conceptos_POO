/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO.Mapper;

import com.mycompany.aplicacionpoo.DTO.ProfesorDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.ProfesorFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.ProfesorFactory;
import com.mycompany.aplicacionpoo.Model.Profesor;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nicol
 */

public class ProfesorMapper {

    private static final ProfesorFactory profesorFactory = new ProfesorFactory();
    private static final ProfesorFactoryDTO profesorFactoryDTO = new ProfesorFactoryDTO();

    // DTO → Entity
    public static Profesor toEntity(ProfesorDTO dto) {
        if (dto == null) return null;

        Profesor profesor = (Profesor) profesorFactory.crearVacio();
        profesor.setId(dto.getId());
        profesor.setNombres(dto.getNombres());
        profesor.setApellidos(dto.getApellidos());
        profesor.setEmail(dto.getEmail());
        profesor.setTipo(dto.getTipo());
        profesor.setTipoContrato(dto.getTipoContrato());

        return profesor;
    }

    // Entity → DTO
    public static ProfesorDTO toDTO(Profesor profesor) {
        if (profesor == null) return null;

        ProfesorDTO dto = (ProfesorDTO) profesorFactoryDTO.crearVacio();
        dto.setId(profesor.getId());
        dto.setNombres(profesor.getNombres());
        dto.setApellidos(profesor.getApellidos());
        dto.setEmail(profesor.getEmail());
        dto.setTipo(profesor.getTipo());
        dto.setTipoContrato(profesor.getTipoContrato());

        return dto;
    }

    // List<Entity> → List<DTO>
    public static List<ProfesorDTO> toDTOList(List<Profesor> profesores) {
        if (profesores == null) return null;
        return profesores.stream()
                .map(ProfesorMapper::toDTO)
                .collect(Collectors.toList());
    }

    // List<DTO> → List<Entity>
    public static List<Profesor> toEntityList(List<ProfesorDTO> dtos) {
        if (dtos == null) return null;
        return dtos.stream()
                .map(ProfesorMapper::toEntity)
                .collect(Collectors.toList());
    }
}


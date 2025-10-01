/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO.Mapper;

import com.mycompany.aplicacionpoo.DTO.FacultadDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.FacultadFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.FacultadFactory;
import com.mycompany.aplicacionpoo.Model.Facultad;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nicol
 */

public class FacultadMapper {
    
    private final static FacultadFactory facultadFactory = new FacultadFactory();
    private final static FacultadFactoryDTO facultadFactoryDTO = new FacultadFactoryDTO();

    public static Facultad toEntity(FacultadDTO dto) {
        if (dto == null) return null;

        Facultad facultad = (Facultad) facultadFactory.crearVacio();
        facultad.setId(dto.getId());
        facultad.setNombre(dto.getNombre());
        facultad.setDecano(PersonaMapper.toEntity(dto.getDecano()));
        return facultad;
    }

    public static FacultadDTO toDTO(Facultad entity) {
        if (entity == null) return null;

        FacultadDTO dto = (FacultadDTO) facultadFactoryDTO.crearVacio();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDecano(PersonaMapper.toDTO(entity.getDecano()));
        return dto;
    }

    public static List<FacultadDTO> toDTOList(List<Facultad> entidades) {
        if (entidades == null) return null;
        return entidades.stream()
                        .map(FacultadMapper::toDTO)
                        .collect(Collectors.toList());
    }

    public static List<Facultad> toEntityList(List<FacultadDTO> dtos) {
        if (dtos == null) return null;
        return dtos.stream()
                   .map(FacultadMapper::toEntity)
                   .collect(Collectors.toList());
    }
}


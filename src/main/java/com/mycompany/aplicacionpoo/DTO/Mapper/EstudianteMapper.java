/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO.Mapper;

import com.mycompany.aplicacionpoo.DTO.EstudianteDTO;

import com.mycompany.aplicacionpoo.DTO.ProgramaDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.EstudianteFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.EstudianteFactory;
import com.mycompany.aplicacionpoo.Factory.Impl.ProgramaFactory;
import com.mycompany.aplicacionpoo.Model.Estudiante;

import com.mycompany.aplicacionpoo.Model.Programa;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nicol
 */

public class EstudianteMapper {

    private static final EstudianteFactory estudianteFactory = new EstudianteFactory();
    private static final EstudianteFactoryDTO estudianteFactoryDTO = new EstudianteFactoryDTO();

    public static Estudiante toEntity(EstudianteDTO dto) {
        if (dto == null) return null;

        Estudiante estudiante = (Estudiante) estudianteFactory.crearVacio();
        estudiante.setId(dto.getId());
        estudiante.setCodigo(dto.getCodigo());
        estudiante.setPromedio(dto.getPromedio());
        estudiante.setActivo(dto.isActivo());
        estudiante.setPrograma(ProgramaMapper.toEntity(dto.getPrograma()));

        return estudiante;
    }


    public static EstudianteDTO toDTO(Estudiante entity) {
        if (entity == null) return null;

        EstudianteDTO dto = (EstudianteDTO) estudianteFactoryDTO.crearVacio();
        dto.setId(entity.getId());
        dto.setCodigo(entity.getCodigo());
        dto.setPromedio(entity.getPromedio());
        dto.setActivo(entity.isActivo());
        dto.setPrograma(ProgramaMapper.toDTO(entity.getPrograma()));

        return dto;
    }

    public static List<EstudianteDTO> toDTOList(List<Estudiante> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(EstudianteMapper::toDTO)
                .collect(Collectors.toList());
    }


    public static List<Estudiante> toEntityList(List<EstudianteDTO> dtos) {
        if (dtos == null) return null;
        return dtos.stream()
                .map(EstudianteMapper::toEntity)
                .collect(Collectors.toList());
    }
}

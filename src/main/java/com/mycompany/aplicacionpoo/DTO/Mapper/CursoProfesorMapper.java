/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO.Mapper;

import com.mycompany.aplicacionpoo.DTO.CursoProfesorDTO;
import com.mycompany.aplicacionpoo.DTO.InscripcionDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.CursoProfesorFactory;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.CursoProfesorFactoryDTO;
import com.mycompany.aplicacionpoo.Model.CursoProfesor;
import com.mycompany.aplicacionpoo.Model.Inscripcion;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nicol
 */
public class CursoProfesorMapper {
    
    private static final CursoProfesorFactory cursoProfesorFactory = new CursoProfesorFactory();
    private static final CursoProfesorFactoryDTO cursoProfesorFactoryDTO = new CursoProfesorFactoryDTO();
    
    public static CursoProfesor toEntity(CursoProfesorDTO dto){
        
        CursoProfesor cursoprofesor = (CursoProfesor) cursoProfesorFactory.crearVacio();
        cursoprofesor.setAño(dto.getAño());
        cursoprofesor.setSemestre(dto.getSemestre());
        cursoprofesor.setCurso(CursoMapper.toEntity(dto.getCurso()));
        cursoprofesor.setProfesor(ProfesorMapper.toEntity(dto.getProfesor()));
        
        return cursoprofesor;
    }
    
    public static CursoProfesorDTO toDto(CursoProfesor entity){
        CursoProfesorDTO dto = (CursoProfesorDTO) cursoProfesorFactoryDTO.crearVacio();
        dto.setAño(entity.getAño());
        dto.setSemestre(entity.getSemestre());
        dto.setCurso(CursoMapper.toDTO(entity.getCurso()));
        dto.setProfesor(ProfesorMapper.toDTO(entity.getProfesor()));
        
        return dto;
    }
    
    public static List<CursoProfesorDTO> toDTOList(List<CursoProfesor> entidades) {
        if (entidades == null) return null;
        return entidades.stream()
                        .map(CursoProfesorMapper::toDto)
                        .collect(Collectors.toList());
    }
    
    public static List<CursoProfesor> toEntityList(List<CursoProfesorDTO> dtos) {
        if (dtos == null) return null;
        return dtos.stream()
                   .map(CursoProfesorMapper::toEntity)
                   .collect(Collectors.toList());
    }
}

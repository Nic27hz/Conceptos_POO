/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO.Mapper;

import com.mycompany.aplicacionpoo.DTO.InscripcionDTO;
import com.mycompany.aplicacionpoo.DTO.ProgramaDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.InscripcionFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.InscripcionFactory;
import com.mycompany.aplicacionpoo.Model.Inscripcion;
import com.mycompany.aplicacionpoo.Model.Programa;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nicol
 */
public class InscripcionMapper {
    
    private static final InscripcionFactory inscripcionFactory = new InscripcionFactory();
    private static final InscripcionFactoryDTO inscripcionFactoryDTO = new InscripcionFactoryDTO();
    
    public static Inscripcion toEntity(InscripcionDTO dto){
        
       Inscripcion inscripcion = (Inscripcion) inscripcionFactory.crearVacio();
       inscripcion.setAño(dto.getAño());
       inscripcion.setSemestre(dto.getSemestre());
       inscripcion.setCurso(CursoMapper.toEntity(dto.getCurso()));
       inscripcion.setEstudiante(EstudianteMapper.toEntity(dto.getEstudiante()));
       
       return inscripcion;
    }
    
    public static InscripcionDTO toDto(Inscripcion entity){
        
        InscripcionDTO inscripcion = (InscripcionDTO) inscripcionFactoryDTO.crearVacio();
        inscripcion.setAño(entity.getAño());
        inscripcion.setSemestre(entity.getSemestre());
        inscripcion.setEstudiante(EstudianteMapper.toDTO(entity.getEstudiante()));
        inscripcion.setCurso(CursoMapper.toDTO(entity.getCurso()));
        
        return inscripcion;
    }
    
    public static List<InscripcionDTO> toDTOList(List<Inscripcion> entidades) {
        if (entidades == null) return null;
        return entidades.stream()
                        .map(InscripcionMapper::toDto)
                        .collect(Collectors.toList());
    }
    
    public static List<Inscripcion> toEntityList(List<InscripcionDTO> dtos) {
        if (dtos == null) return null;
        return dtos.stream()
                   .map(InscripcionMapper::toEntity)
                   .collect(Collectors.toList());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO.Mapper;

import com.mycompany.aplicacionpoo.DTO.ProgramaDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.ProgramaFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.ProgramaFactory;
import com.mycompany.aplicacionpoo.Model.Programa;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nicol
 */
public class ProgramaMapper {
    
    private static final ProgramaFactory programaFactory = new ProgramaFactory();
    private static final ProgramaFactoryDTO programaFactoryDTO = new ProgramaFactoryDTO();
    
    public static Programa toEntity(ProgramaDTO dto){
        if(dto == null) return null;
        
        Programa programa = (Programa) programaFactory.crearVacio();
        
        programa.setId(dto.getId());
        programa.setNombre(dto.getNombre());
        programa.setDuracion(dto.getDuracion());
        programa.setRegistro(dto.getRegistro());
        programa.setFacultad(FacultadMapper.toEntity(dto.getFacultad()));
        
        return programa;
    }
    
    public static ProgramaDTO toDTO(Programa entity){
        if(entity == null) return null;
        
        ProgramaDTO programadto = (ProgramaDTO) programaFactoryDTO.crearVacio();
        programadto.setId(entity.getId());
        programadto.setNombre(entity.getNombre());
        programadto.setDuracion(entity.getDuracion());
        programadto.setRegistro(entity.getRegistro());
        
        programadto.setFacultad(FacultadMapper.toDTO(entity.getFacultad()));
        
        return programadto;
    }
    
    public static List<ProgramaDTO> toDTOList(List<Programa> entidades) {
        if (entidades == null) return null;
        return entidades.stream()
                        .map(ProgramaMapper::toDTO)
                        .collect(Collectors.toList());
    }
    
    public static List<Programa> toEntityList(List<ProgramaDTO> dtos) {
        if (dtos == null) return null;
        return dtos.stream()
                   .map(ProgramaMapper::toEntity)
                   .collect(Collectors.toList());
    }
}

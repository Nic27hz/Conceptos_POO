/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO.Mapper;

import com.mycompany.aplicacionpoo.DTO.CursoDTO;

import com.mycompany.aplicacionpoo.Factory.Impl.CursoFactory;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.CursoFactoryDTO;

import com.mycompany.aplicacionpoo.Model.Curso;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */

public class CursoMapper {
    
    private static final CursoFactory cursoFactory = new CursoFactory();
    private static final CursoFactoryDTO cursoFactoryDTO = new CursoFactoryDTO();

    
    public static Curso toEntity(CursoDTO dto) {
        if (dto == null) return null;

        Curso curso = (Curso) cursoFactory.crearVacio();
        curso.setId(dto.getId());
        curso.setNombre(dto.getNombre());
        curso.setPrograma(ProgramaMapper.toEntity(dto.getPrograma()));
        curso.setActivo(dto.isActivo());
        
        return curso;
    }

   
    public static CursoDTO toDTO(Curso curso) {
        if (curso == null) return null;

        CursoDTO dto = (CursoDTO) cursoFactoryDTO.crearVacio() ;
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        
        dto.setPrograma(ProgramaMapper.toDTO(curso.getPrograma()));
        dto.setActivo(curso.isActivo());

        return dto;
    }

    public static List<CursoDTO> toDTOList(List<Curso> cursos) {
        List<CursoDTO> lista = new ArrayList<>();
        if (cursos != null) {
            for (Curso curso : cursos) {
                lista.add(toDTO(curso));
            }
        }
        return lista;
    }

    public static List<Curso> toEntityList(List<CursoDTO> cursosDTO) {
        List<Curso> lista = new ArrayList<>();
        if (cursosDTO != null) {
            for (CursoDTO dto : cursosDTO) {
                lista.add(toEntity(dto));
            }
        }
        return lista;
    }
}

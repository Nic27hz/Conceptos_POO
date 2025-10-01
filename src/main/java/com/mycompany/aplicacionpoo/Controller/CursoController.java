/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.DTO.Mapper.CursoMapper;
import com.mycompany.aplicacionpoo.DTO.ProgramaDTO;
import com.mycompany.aplicacionpoo.Service.CursoDao;
import com.mycompany.aplicacionpoo.Service.Impl.CursoDaoImpl;
import com.mycompany.aplicacionpoo.Model.Curso;
import com.mycompany.aplicacionpoo.DTO.CursoDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.CursoFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.ProgramaFactoryDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */

public class CursoController {
    private final CursoDao cursoDao;
    private final ProgramaFactoryDTO programaFactoryDTO;
    private final CursoFactoryDTO cursoFactoryDTO;

    public CursoController() {
        this.cursoDao = new CursoDaoImpl();
        this.programaFactoryDTO = new ProgramaFactoryDTO();
        this.cursoFactoryDTO = new CursoFactoryDTO();
    }

    public void agregarCurso(int id, String nombre, boolean estado, double idPrograma) {
               
        ProgramaDTO dtop = (ProgramaDTO) programaFactoryDTO.crearVacio();
        dtop.setId(idPrograma);
        
        CursoDTO dto = cursoFactoryDTO.crear(id, nombre, dtop, estado);
                
        Curso curso = CursoMapper.toEntity(dto);

        cursoDao.agregarCurso(curso);
    }

    public void actualizarCurso(int id, String nombre, boolean estado, double idPrograma) {
        ProgramaDTO dtop = (ProgramaDTO) programaFactoryDTO.crearVacio();
        dtop.setId(idPrograma);
        
        CursoDTO dto = cursoFactoryDTO.crear(id, nombre, dtop, estado);
                
        Curso curso = CursoMapper.toEntity(dto);

        cursoDao.actualizarCurso(curso);
    }

    public void eliminarCurso(int id) {
        cursoDao.eliminarCurso(id);
    }

    public CursoDTO buscarCurso(int id) {
        Curso curso = cursoDao.buscarCurso(id);
        return CursoMapper.toDTO(curso);
    }

    public List<CursoDTO> mostrarCurso() {
        ArrayList<Curso> cursos = cursoDao.mostrarCurso();
        return CursoMapper.toDTOList(cursos);
    }
}


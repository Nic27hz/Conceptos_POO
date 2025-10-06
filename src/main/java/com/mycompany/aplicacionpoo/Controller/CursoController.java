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
import com.mycompany.aplicacionpoo.Observer.Impl.CursoObserver;
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
        curso.agregarObservador(new CursoObserver("obserador de curso: "));
        curso.notificar("nuevo curso agregado: " + nombre);
    }

    public void actualizarCurso(int id, String nombre, boolean estado, double idPrograma) {
        ProgramaDTO dtop = (ProgramaDTO) programaFactoryDTO.crearVacio();
        dtop.setId(idPrograma);
        
        CursoDTO dto = cursoFactoryDTO.crear(id, nombre, dtop, estado);
                      
        Curso curso = CursoMapper.toEntity(dto);

        cursoDao.actualizarCurso(curso);
        curso.agregarObservador(new CursoObserver("observador Curso: "));
        curso.notificar("curso con Id: " + id + " actualizado");
    }

    public void eliminarCurso(int id) {
        
        CursoDTO dto = (CursoDTO) cursoFactoryDTO.crearVacio();
        dto.setId(id);
               
        Curso curso = CursoMapper.toEntity(dto);
        
        cursoDao.eliminarCurso(curso.getId());
        curso.agregarObservador(new CursoObserver("observador Curso: "));
        curso.notificar("Curso con Id: " + id + " eliminado");
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


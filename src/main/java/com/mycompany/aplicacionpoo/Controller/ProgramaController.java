package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.DTO.FacultadDTO;
import com.mycompany.aplicacionpoo.DTO.Mapper.ProgramaMapper;
import com.mycompany.aplicacionpoo.DTO.ProgramaDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.FacultadFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.ProgramaFactoryDTO;
import com.mycompany.aplicacionpoo.Service.ProgramaDao;
import com.mycompany.aplicacionpoo.Service.Impl.ProgramaDaoImpl;

import com.mycompany.aplicacionpoo.Model.Programa;
import com.mycompany.aplicacionpoo.Observer.Impl.ProgramaObserver;
import java.sql.Date;

import java.util.List;

public class ProgramaController {
    private final ProgramaDao programaDao;
    private final ProgramaFactoryDTO programaFactory;
    private final FacultadFactoryDTO facultadFactory;

    public ProgramaController() {
        this.programaDao = new ProgramaDaoImpl();
        this.programaFactory = new ProgramaFactoryDTO();
        this.facultadFactory = new FacultadFactoryDTO();
    }

    public void guardarPrograma(double id, String nombre, double duracion, Date registro, double idFacultad) {
        
        FacultadDTO facultad = (FacultadDTO) facultadFactory.crearVacio();
        facultad.setId(idFacultad);
        
        ProgramaDTO dto = programaFactory.crear(id, nombre, duracion, registro, facultad);
        Programa programa = ProgramaMapper.toEntity(dto);
        
        programaDao.guardarPrograma(programa);
        programa.agregarObservador(new ProgramaObserver("Observador Pragrama: "));
        programa.notificar("Se agregó un nuevo programa: " + programa.getNombre() + " a la facultad: " + programa.getFacultad().getId());
    }

    public void actualizarPrograma(double id, String nombre, double duracion, Date registro, double idFacultad) {
        
        FacultadDTO facultad = (FacultadDTO) facultadFactory.crearVacio();
        facultad.setId(idFacultad);
        
        ProgramaDTO dto = programaFactory.crear(id, nombre, duracion, registro, facultad);
        Programa programa = ProgramaMapper.toEntity(dto);
        
        programaDao.actualizarPrograma(programa);
        programa.agregarObservador(new ProgramaObserver("Observador Pragrama: "));
        programa.notificar("Se actualizó un programa con ID: " + programa.getId());
    }

    public void eliminarPrograma(int id) {
        ProgramaDTO dto = (ProgramaDTO) programaFactory.crearVacio();
        dto.setId(id);
        Programa programa = ProgramaMapper.toEntity(dto);
        programaDao.eliminarPrograma(programa);
        programa.agregarObservador(new ProgramaObserver("Observador Pragrama: "));
        programa.notificar("Se eliminó programa on ID: " + programa.getId());
    }

    public ProgramaDTO buscarPrograma(int id) {
        Programa programa = programaDao.buscarPrograma(id);
        return ProgramaMapper.toDTO(programa);
    }

    public List<ProgramaDTO> mostrarProgramas() {
        List<Programa> programa = programaDao.mostrarProgramas();
        return ProgramaMapper.toDTOList(programa);
    }
}

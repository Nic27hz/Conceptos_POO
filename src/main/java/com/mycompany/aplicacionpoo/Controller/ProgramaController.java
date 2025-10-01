package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.DTO.FacultadDTO;
import com.mycompany.aplicacionpoo.DTO.Mapper.ProgramaMapper;
import com.mycompany.aplicacionpoo.DTO.ProgramaDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.FacultadFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.ProgramaFactoryDTO;
import com.mycompany.aplicacionpoo.Service.ProgramaDao;
import com.mycompany.aplicacionpoo.Service.Impl.ProgramaDaoImpl;

import com.mycompany.aplicacionpoo.Model.Programa;
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
    }

    public void actualizarPrograma(double id, String nombre, double duracion, Date registro, double idFacultad) {
        
        FacultadDTO facultad = (FacultadDTO) facultadFactory.crearVacio();
        facultad.setId(idFacultad);
        
        ProgramaDTO dto = programaFactory.crear(id, nombre, duracion, registro, facultad);
        Programa programa = ProgramaMapper.toEntity(dto);
        
        programaDao.actualizarPrograma(programa);
    }

    public void eliminarPrograma(int id) {
        programaDao.eliminarPrograma(id);
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

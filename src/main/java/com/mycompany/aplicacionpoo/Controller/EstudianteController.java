/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.DTO.EstudianteDTO;
import com.mycompany.aplicacionpoo.DTO.Mapper.EstudianteMapper;
import com.mycompany.aplicacionpoo.DTO.PersonaDTO;
import com.mycompany.aplicacionpoo.DTO.ProgramaDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.EstudianteFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.PersonaFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.ProgramaFactoryDTO;
import com.mycompany.aplicacionpoo.Service.EstudianteDao;
import com.mycompany.aplicacionpoo.Service.Impl.EstudianteDaoImpl;
import com.mycompany.aplicacionpoo.Model.Estudiante;
import com.mycompany.aplicacionpoo.Observer.Impl.EstudianteObserver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class EstudianteController {

    private final EstudianteDao estudianteDao;
    private final EstudianteFactoryDTO estudianteFactory;
    private final ProgramaFactoryDTO programaFactory;
    private final PersonaFactoryDTO personaFactory;

    public EstudianteController() {
        this.estudianteDao = new EstudianteDaoImpl();
        this.estudianteFactory = new EstudianteFactoryDTO();
        this.programaFactory = new ProgramaFactoryDTO();
        this.personaFactory = new PersonaFactoryDTO();
    }


    public void agregarEstudiante(double id, double codigo, double promedio, boolean estado, double idPrograma) {
        
        ProgramaDTO programaDTO = (ProgramaDTO) programaFactory.crearVacio();
        programaDTO.setId(idPrograma);
        
        PersonaDTO p = (PersonaDTO) personaFactory.crearVacio();
        p.setId(id);
        
        EstudianteDTO dto = estudianteFactory.crear(p, codigo, programaDTO, estado, promedio);

        Estudiante estudiante = EstudianteMapper.toEntity(dto);
        estudianteDao.agregarEstudiante(estudiante);
        estudiante.agregarObservador(new EstudianteObserver("Observador Estudiante: "));
        estudiante.notificar("Se Agrego un nuevo estudiante " + estudiante.getNombres() + "Con programa: " + estudiante.getPrograma().getNombre());
    }


    public void actualizarEstudiante(double id, double codigo, double promedio, boolean estado, double idPrograma) {
       ProgramaDTO programaDTO = (ProgramaDTO) programaFactory.crearVacio();
        programaDTO.setId(idPrograma);
        
        PersonaDTO p = (PersonaDTO) personaFactory.crearVacio();
        p.setId(id);
        
        EstudianteDTO dto = estudianteFactory.crear(p, codigo, programaDTO, estado, promedio);

        Estudiante estudiante = EstudianteMapper.toEntity(dto);
        estudianteDao.actualizarEstudiante(estudiante);
        estudiante.agregarObservador(new EstudianteObserver("Observador Estudiante: "));
        estudiante.notificar("Se actualizó un estudiante con Id: " + estudiante.getId());
    }

   
    public void eliminarEstudiante(double id) {
                
        EstudianteDTO dto = (EstudianteDTO) estudianteFactory.crearVacio();
        dto.setId(id); 
        Estudiante estudiante = EstudianteMapper.toEntity(dto);
        
        estudianteDao.eliminarEstudiante(estudiante);
        estudiante.agregarObservador(new EstudianteObserver("Observador Estudiante: "));
        estudiante.notificar("Se elimino un estudiante con Id: " + estudiante.getId());
    }

    public EstudianteDTO buscarEstudiante(double id) {
        Estudiante estudiante = estudianteDao.buscarEstudiante(id);
        return EstudianteMapper.toDTO(estudiante);
    }

    public List<EstudianteDTO> mostrarEstudiante() {
        ArrayList<Estudiante> estudiantes = estudianteDao.mostrarEstudiante();
        return EstudianteMapper.toDTOList(estudiantes);
    }
}


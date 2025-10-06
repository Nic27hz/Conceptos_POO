package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.DTO.CursoDTO;
import com.mycompany.aplicacionpoo.DTO.EstudianteDTO;
import com.mycompany.aplicacionpoo.DTO.InscripcionDTO;
import com.mycompany.aplicacionpoo.DTO.Mapper.InscripcionMapper;
import com.mycompany.aplicacionpoo.Service.InscripcionDao;
import com.mycompany.aplicacionpoo.Service.Impl.InscripcionDaoImpl;

import com.mycompany.aplicacionpoo.Factory.Impl.DTO.CursoFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.EstudianteFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.InscripcionFactoryDTO;

import com.mycompany.aplicacionpoo.Model.Inscripcion;
import com.mycompany.aplicacionpoo.Observer.Impl.InscripcionObserver;

import java.util.List;

/**
 *
 * @author nicol
 */
public class InscripcionController {
    private final InscripcionDao inscripcionDao;
    private final InscripcionFactoryDTO inscripcionFactory;
    private final EstudianteFactoryDTO estudianteFactory;
    private final CursoFactoryDTO cursoFactory;

    public InscripcionController() {
        this.inscripcionDao = new InscripcionDaoImpl();
        this.inscripcionFactory = new InscripcionFactoryDTO();
        this.cursoFactory = new CursoFactoryDTO();
        this.estudianteFactory = new EstudianteFactoryDTO();
    }
    
    public void agregarInscripcion(int año, int semestre, double idEstudiante, int idCurso) {
        EstudianteDTO estudiante = (EstudianteDTO) estudianteFactory.crearVacio();
        estudiante.setId(idEstudiante);
        
        CursoDTO curso = (CursoDTO) cursoFactory.crearVacio();
        curso.setId(idCurso);
        
        InscripcionDTO inscripciondto = inscripcionFactory.crear(curso, año, semestre, estudiante);
        Inscripcion inscripcion = InscripcionMapper.toEntity(inscripciondto);
        
        inscripcionDao.agregarInscripcion(inscripcion);
        inscripcion.agregarObservador(new InscripcionObserver("Observador Inscripcion: "));
        inscripcion.notificar("Se inscribio Estudiante " + inscripcion.getEstudiante().getNombres() + " al curso " + inscripcion.getCurso().getNombre());
    }

    public void actualizarInscripcion(int año, int semestre, double idEstudiante, int idCurso) {
        EstudianteDTO estudiante = (EstudianteDTO) estudianteFactory.crearVacio();
        estudiante.setId(idEstudiante);
        
        CursoDTO curso = (CursoDTO) cursoFactory.crearVacio();
        curso.setId(idCurso);
        
        InscripcionDTO inscripciondto = inscripcionFactory.crear(curso, año, semestre, estudiante);
        Inscripcion inscripcion = InscripcionMapper.toEntity(inscripciondto);
        
        inscripcionDao.actualizarInscripcion(inscripcion);
        inscripcion.agregarObservador(new InscripcionObserver("Observador Inscripcion: "));
        inscripcion.notificar("Se actualizó la inscripción");
    }
    
    public void eliminarInscripcion(double idEstudiante, int idCurso){
        EstudianteDTO estudiante = (EstudianteDTO) estudianteFactory.crearVacio();
        estudiante.setId(idEstudiante);
        
        CursoDTO curso = (CursoDTO) cursoFactory.crearVacio();
        curso.setId(idCurso);
        
        InscripcionDTO inscripciondto = (InscripcionDTO) inscripcionFactory.crearVacio();
        inscripciondto.setEstudiante(estudiante);
        inscripciondto.setCurso(curso);
        
        Inscripcion inscripcion = InscripcionMapper.toEntity(inscripciondto);
        
        inscripcionDao.eliminarInscripcion(inscripcion);
        inscripcion.agregarObservador(new InscripcionObserver("Observador Inscripcion: "));
        inscripcion.notificar("Se eliminó Inscripcion de estudiante " + inscripcion.getEstudiante().getNombres() + " del curso " + inscripcion.getCurso().getNombre());
    }
    
    public InscripcionDTO buscarInscripcion(double idEstudiante, int idCurso){
        Inscripcion inscripcion = inscripcionDao.buscarInscripcion(idEstudiante, idCurso); 
        return InscripcionMapper.toDto(inscripcion);
    }
    
    public List<InscripcionDTO> mostrarInscripciones(){
        List<Inscripcion> inscripcion = inscripcionDao.mostrarInscripciones();
        return InscripcionMapper.toDTOList(inscripcion);
    }
}

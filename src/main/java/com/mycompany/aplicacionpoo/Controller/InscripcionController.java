package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Dao.InscripcionDao;
import com.mycompany.aplicacionpoo.Dao.Impl.InscripcionDaoImpl;
import com.mycompany.aplicacionpoo.Factory.Impl.CursoFactory;
import com.mycompany.aplicacionpoo.Factory.Impl.EstudianteFactory;
import com.mycompany.aplicacionpoo.Factory.Impl.InscripcionFactory;
import com.mycompany.aplicacionpoo.Model.Curso;
import com.mycompany.aplicacionpoo.Model.Estudiante;
import com.mycompany.aplicacionpoo.Model.Inscripcion;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class InscripcionController {
    private final InscripcionDao inscripcionDao;
    private final InscripcionFactory inscripcionFactory;
    private final EstudianteFactory estudianteFactory;
    private final CursoFactory cursoFactory;

    public InscripcionController() {
        this.inscripcionDao = new InscripcionDaoImpl();
        this.inscripcionFactory = new InscripcionFactory();
        this.cursoFactory = new CursoFactory();
        this.estudianteFactory = new EstudianteFactory();
    }
    
    public void agregarInscripcion(int año, int semestre, double idEstudiante, int idCurso) {
        Inscripcion inscripcion = (Inscripcion) inscripcionFactory.crear();
        inscripcion.setAño(año);
        inscripcion.setSemestre(semestre);
        
        Estudiante estudiante = (Estudiante) estudianteFactory.crear();
        estudiante.setId(idEstudiante);
        
        Curso curso = (Curso) cursoFactory.crear();
        curso.setId(idCurso);
        
        inscripcion.setEstudiante(estudiante);
        inscripcion.setCurso(curso);
        
        inscripcionDao.agregarInscripcion(inscripcion);
    }

    public void actualizarInscripcion(int año, int semestre, double idEstudiante, int idCurso) {
        Inscripcion inscripcion = (Inscripcion) inscripcionFactory.crear();
        inscripcion.setAño(año);
        inscripcion.setSemestre(semestre);
        
        Estudiante estudiante = (Estudiante) estudianteFactory.crear();
        estudiante.setId(idEstudiante);
        
        Curso curso = (Curso) cursoFactory.crear();
        curso.setId(idCurso);
        
        inscripcion.setEstudiante(estudiante);
        inscripcion.setCurso(curso);
        
        inscripcionDao.actualizarInscripcion(inscripcion);
    }
    
    public void eliminarInscripcion(double idEstudiante, int idCurso){
        inscripcionDao.eliminarInscripcion(idEstudiante, idCurso);
    }
    
    public Inscripcion buscarInscripcion(double idEstudiante, int idCurso){
        return inscripcionDao.buscarInscripcion(idEstudiante, idCurso);
    }
    
    public ArrayList<Inscripcion> mostrarInscripciones(){
        return inscripcionDao.mostrarInscripciones();
    }
}

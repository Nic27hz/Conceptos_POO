package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Dao.InscripcionDao;
import com.mycompany.aplicacionpoo.Dao.Impl.InscripcionDaoImpl;
import com.mycompany.aplicacionpoo.Model.Curso;
import com.mycompany.aplicacionpoo.Model.Estudiante;
import com.mycompany.aplicacionpoo.Model.Inscripcion;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class InscripcionController {
    private InscripcionDao inscripcionDao;

    public InscripcionController() {
        this.inscripcionDao = new InscripcionDaoImpl();
    }
    
    public void agregarInscripcion(int año, int semestre, double idEstudiante, int idCurso) {
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAño(año);
        inscripcion.setSemestre(semestre);
        
        Estudiante estudiante = new Estudiante();
        estudiante.setId(idEstudiante);
        
        Curso curso = new Curso();
        curso.setId(idCurso);
        
        inscripcion.setEstudiante(estudiante);
        inscripcion.setCurso(curso);
        
        inscripcionDao.agregarInscripcion(inscripcion);
    }

    public void actualizarInscripcion(int año, int semestre, double idEstudiante, int idCurso) {
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAño(año);
        inscripcion.setSemestre(semestre);
        
        Estudiante estudiante = new Estudiante();
        estudiante.setId(idEstudiante);
        
        Curso curso = new Curso();
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

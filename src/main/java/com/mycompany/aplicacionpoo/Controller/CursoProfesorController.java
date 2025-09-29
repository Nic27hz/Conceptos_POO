package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Dao.CursoProfesorDao;
import com.mycompany.aplicacionpoo.Dao.Impl.CursoProfesorDaoImpl;
import com.mycompany.aplicacionpoo.Factory.Impl.CursoFactory;
import com.mycompany.aplicacionpoo.Factory.Impl.CursoProfesorFactory;
import com.mycompany.aplicacionpoo.Factory.Impl.ProfesorFactory;
import com.mycompany.aplicacionpoo.Model.Curso;
import com.mycompany.aplicacionpoo.Model.CursoProfesor;
import com.mycompany.aplicacionpoo.Model.Profesor;
import java.util.ArrayList;

public class CursoProfesorController {

    private final CursoProfesorDao cursoProfesorDao;
    private final CursoFactory cursoFactory;
    private final CursoProfesorFactory cursoProfesorFactory;
    private final ProfesorFactory profesorFactory;

    public CursoProfesorController() {
        this.cursoProfesorDao = new CursoProfesorDaoImpl();
        this.cursoFactory = new CursoFactory();
        this.cursoProfesorFactory = new CursoProfesorFactory();
        this.profesorFactory = new ProfesorFactory();
    }

    public void agregarCursoProfesor(int año, int semestre, double idProfesor, int idCurso) {
        CursoProfesor cp = (CursoProfesor) cursoProfesorFactory.crear();
        cp.setAño(año);
        cp.setSemestre(semestre);

        Profesor profesor = (Profesor) profesorFactory.crear();
        profesor.setId(idProfesor);
        
        cp.setProfesor(profesor);

        Curso curso = (Curso) cursoFactory.crear();
        curso.setId(idCurso);
        
        cp.setCurso(curso);

        cursoProfesorDao.agregarCursoProfesor(cp);
    }

    public void actualizarCursoProfesor(int año, int semestre, double idProfesor, int idCurso) {
        CursoProfesor cp = (CursoProfesor) cursoProfesorFactory.crear();
        cp.setAño(año);
        cp.setSemestre(semestre);

         Profesor profesor = (Profesor) profesorFactory.crear();
        profesor.setId(idProfesor);
        cp.setProfesor(profesor);

        Curso curso = (Curso) cursoFactory.crear();
        curso.setId(idCurso);
        cp.setCurso(curso);

        cursoProfesorDao.actualizarCursoProfesor(cp);
    }

    public void eliminarCursoProfesor(double idProfesor, int idCurso) {
        cursoProfesorDao.eliminarCursoProfesor((int) idProfesor, idCurso);
    }

    public CursoProfesor buscarCursoProfesor(double idProfesor, int idCurso) {
        return cursoProfesorDao.buscarCursoProfesor((int) idProfesor, idCurso);
    }

    public ArrayList<CursoProfesor> mostrarCursoProfesores() {
        return cursoProfesorDao.mostrarCursoProfesores();
    }

}

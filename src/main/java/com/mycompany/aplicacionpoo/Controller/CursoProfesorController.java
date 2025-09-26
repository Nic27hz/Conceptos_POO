package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Dao.CursoProfesorDao;
import com.mycompany.aplicacionpoo.Dao.Impl.CursoProfesorDaoImpl;
import com.mycompany.aplicacionpoo.Model.Curso;
import com.mycompany.aplicacionpoo.Model.CursoProfesor;
import com.mycompany.aplicacionpoo.Model.Persona;
import com.mycompany.aplicacionpoo.Model.Profesor;
import java.util.ArrayList;

public class CursoProfesorController {

    private CursoProfesorDao cursoProfesorDao;

    public CursoProfesorController() {
        this.cursoProfesorDao = new CursoProfesorDaoImpl();
    }

    public void agregarCursoProfesor(int año, int semestre, double idProfesor, int idCurso) {
        CursoProfesor cp = new CursoProfesor();
        cp.setAño(año);
        cp.setSemestre(semestre);

        Persona profesor = new Persona();
        profesor.setId(idProfesor);
        cp.setProfesor((Profesor) profesor);

        Curso curso = new Curso();
        curso.setId(idCurso);
        cp.setCurso(curso);

        cursoProfesorDao.agregarCursoProfesor(cp);
    }

    public void actualizarCursoProfesor(int año, int semestre, double idProfesor, int idCurso) {
        CursoProfesor cp = new CursoProfesor();
        cp.setAño(año);
        cp.setSemestre(semestre);

        Persona profesor = new Persona();
        profesor.setId(idProfesor);
        cp.setProfesor((Profesor) profesor);

        Curso curso = new Curso();
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

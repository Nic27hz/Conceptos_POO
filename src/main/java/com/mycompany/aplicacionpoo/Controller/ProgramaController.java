package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Dao.ProgramaDao;
import com.mycompany.aplicacionpoo.Dao.Impl.ProgramaDaoImpl;
import com.mycompany.aplicacionpoo.Model.Programa;
import java.sql.Date;
import java.util.ArrayList;

public class ProgramaController {
    private ProgramaDao programaDao;

    public ProgramaController() {
        this.programaDao = new ProgramaDaoImpl();
    }

    public void guardarPrograma(double id, String nombre, double duracion, Date registro, double idFacultad) {
        Programa programa = new Programa();
        programa.setId(id);
        programa.setNombre(nombre);
        programaDao.guardarPrograma(programa);
    }

    public void actualizarPrograma(double id, String nombre, double duracion, Date registro, double idFacultad) {
        Programa programa = new Programa();
        programa.setId(id);
        programa.setNombre(nombre);
        programaDao.actualizarPrograma(programa);
    }

    public void eliminarPrograma(int id) {
        programaDao.eliminarPrograma(id);
    }

    public Programa buscarPrograma(int id) {
        return programaDao.buscarPrograma(id);
    }

    public ArrayList<Programa> mostrarProgramas() {
        return programaDao.mostrarProgramas();
    }
}

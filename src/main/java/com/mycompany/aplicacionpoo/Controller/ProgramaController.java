package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Dao.ProgramaDao;
import com.mycompany.aplicacionpoo.Dao.Impl.ProgramaDaoImpl;
import com.mycompany.aplicacionpoo.Factory.Impl.FacultadFactory;
import com.mycompany.aplicacionpoo.Factory.Impl.ProgramaFactory;
import com.mycompany.aplicacionpoo.Model.Facultad;
import com.mycompany.aplicacionpoo.Model.Programa;
import java.sql.Date;
import java.util.ArrayList;

public class ProgramaController {
    private final ProgramaDao programaDao;
    private final ProgramaFactory programaFactory;
    private final FacultadFactory facultadFactory;

    public ProgramaController() {
        this.programaDao = new ProgramaDaoImpl();
        this.facultadFactory = new FacultadFactory();
        this.programaFactory = new ProgramaFactory();
    }

    public void guardarPrograma(double id, String nombre, double duracion, Date registro, double idFacultad) {
        
        Facultad facultad = (Facultad) facultadFactory.crear();
        facultad.setId(idFacultad);
        
        Programa programa = (Programa) programaFactory.crear();
        programa.setId(id);
        programa.setNombre(nombre);
        programa.setDuracion(duracion);
        programa.setRegistro(registro);
        programa.setFacultad(facultad);
        
        programaDao.guardarPrograma(programa);
    }

    public void actualizarPrograma(double id, String nombre, double duracion, Date registro, double idFacultad) {
        
        Facultad facultad = (Facultad) facultadFactory.crear();
        facultad.setId(idFacultad);
        
        Programa programa = (Programa) programaFactory.crear();
        programa.setId(id);
        programa.setNombre(nombre);
        programa.setDuracion(duracion);
        programa.setRegistro(registro);
        programa.setFacultad(facultad);
        
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

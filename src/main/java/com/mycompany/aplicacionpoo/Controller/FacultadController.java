/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Dao.FacultadDao;
import com.mycompany.aplicacionpoo.Dao.Impl.FacultadDaoImpl;
import com.mycompany.aplicacionpoo.Factory.Impl.FacultadFactory;
import com.mycompany.aplicacionpoo.Factory.Impl.ProfesorFactory;
import com.mycompany.aplicacionpoo.Model.Facultad;
import com.mycompany.aplicacionpoo.Model.Profesor;
import java.util.ArrayList;


/**
 *
 * @author nicol
 */
public class FacultadController {
    private final FacultadDao facultadDao;
    private final FacultadFactory facultadFactory;
    private final ProfesorFactory profesorFactory;

    public FacultadController() {
        this.facultadDao = new FacultadDaoImpl();
        this.facultadFactory = new FacultadFactory();
        this.profesorFactory = new ProfesorFactory();
    }
    
    public void agregarFacultad(int id, String nombre, int idDecano) {
        
        Facultad facultad = (Facultad) facultadFactory.crear();
        facultad.setId(id);
        facultad.setNombre(nombre);

        Profesor decano = (Profesor) profesorFactory.crear();
        decano.setId(idDecano);

        facultad.setDecano(decano);

        facultadDao.agregarFacultad(facultad);
    }

    public void actualizarFacultad(int id, String nombre, int idDecano) {
        
        Facultad facultad = (Facultad) facultadFactory.crear();
        facultad.setId(id);
        facultad.setNombre(nombre);

        Profesor decano = (Profesor) profesorFactory.crear();
        decano.setId(idDecano);

        facultad.setDecano(decano);

        facultadDao.actualizarFacultad(facultad);
    }
    
    public void eliminarFacultad(int id){
        facultadDao.eliminarFacultad(id);
    }
    
    public Facultad buscarFacultad(int id){
        return facultadDao.buscarFacultad(id);
    }
    
    public ArrayList<Facultad> mostrarFacultad(){
        return facultadDao.mostrarFacultad();
    }
}

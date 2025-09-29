/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Dao.Impl.ProfesorDaoImpl;
import com.mycompany.aplicacionpoo.Dao.ProfesorDao;
import com.mycompany.aplicacionpoo.Factory.Impl.ProfesorFactory;
import com.mycompany.aplicacionpoo.Model.Profesor;
import java.util.ArrayList;


/**
 *
 * @author nicol
 */
public class ProfesorController {
    private final ProfesorDao profesorDao;
    private final ProfesorFactory profesorFactory;
    
    public ProfesorController(){
        this.profesorDao = new ProfesorDaoImpl();
        this.profesorFactory = new ProfesorFactory();
    }
    
    public void agregarProfesor(int id, String tipoContrato){
        
        Profesor profe = (Profesor) profesorFactory.crear();
        profe.setTipoContrato(tipoContrato);
        profe.setId(id);
            
        profesorDao.agregarProfesor(profe);
    }
    
    public void actualizarProfesor(int id, String tipoContrato){
        Profesor profe = (Profesor) profesorFactory.crear();
        profe.setTipoContrato(tipoContrato);
        profe.setId(id);
        profesorDao.actualizarProfesor(profe);
    }
    
    public void eliminarProfesor(int id){
        profesorDao.eliminarProfesor(id);
    }
    
    public Profesor buscarProfesor(int id){
        return profesorDao.buscarProfesor(id);
    }
    
    public ArrayList<Profesor> mostrarProfesor(){
        return profesorDao.mostrarProfesor();
    }
}

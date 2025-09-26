/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Dao.Impl.ProfesorDaoImpl;
import com.mycompany.aplicacionpoo.Dao.ProfesorDao;
import com.mycompany.aplicacionpoo.Model.Profesor;
import java.util.ArrayList;


/**
 *
 * @author nicol
 */
public class ProfesorController {
    private ProfesorDao profesorDao;
    
    public ProfesorController(){
        this.profesorDao = new ProfesorDaoImpl();
    }
    
    public void agregarProfesor(Profesor profesor){
        profesorDao.agregarProfesor(profesor);
    }
    
    public void actualizarProfesor(Profesor Profesor){
        profesorDao.actualizarProfesor(Profesor);
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

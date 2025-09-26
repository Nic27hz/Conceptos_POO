/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Dao.EstudianteDao;
import com.mycompany.aplicacionpoo.Dao.Impl.EstudianteDaoImpl;
import com.mycompany.aplicacionpoo.Model.Estudiante;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class EstudianteController {
    private EstudianteDao estudianteDao;

    public EstudianteController() {
        this.estudianteDao = new EstudianteDaoImpl();
    }
    
    public void agregarEstudiante(Estudiante estudiante){
        estudianteDao.agregarEstudiante(estudiante);
    }
    
    public void actualizarEstduiante(Estudiante estudiante){
        estudianteDao.actualizarEstudiante(estudiante);
    }
    
    public void eliminarEstudiante(double id){
        estudianteDao.eliminarEstudiante(id);
    }
    
    public Estudiante buscarEstudiante(double id){
        return estudianteDao.buscarEstudiante(id);
    }
    
    public ArrayList<Estudiante> mostrarEstudiante(){
        return estudianteDao.mostrarEstudiante();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Dao.EstudianteDao;
import com.mycompany.aplicacionpoo.Dao.Impl.EstudianteDaoImpl;
import com.mycompany.aplicacionpoo.Factory.Impl.EstudianteFactory;
import com.mycompany.aplicacionpoo.Factory.Impl.ProgramaFactory;
import com.mycompany.aplicacionpoo.Model.Estudiante;
import com.mycompany.aplicacionpoo.Model.Programa;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class EstudianteController {
    private final EstudianteDao estudianteDao;
    private final ProgramaFactory programaFactory;
    private final EstudianteFactory estudianteFactory;

    public EstudianteController() {
        this.estudianteDao = new EstudianteDaoImpl();
        this.estudianteFactory = new EstudianteFactory();
        this.programaFactory = new ProgramaFactory();
    }
    
    public void agregarEstudiante(double id, double codigo, double promedio, boolean estado, double idPrograma){
        
        Programa programa = (Programa) programaFactory.crear();
        programa.setId(idPrograma);

        Estudiante estudiante = (Estudiante) estudianteFactory.crear();
        estudiante.setId(id);
        estudiante.setCodigo(codigo);
        estudiante.setPromedio(promedio);
        estudiante.setActivo(estado);
        estudiante.setPrograma(programa);
        
        estudianteDao.agregarEstudiante(estudiante);
    }
    
    public void actualizarEstudiante(double id, double codigo, double promedio, boolean estado, double idPrograma) {
        
        Programa programa = (Programa) programaFactory.crear();
        programa.setId(idPrograma);
        
        Estudiante estudiante = (Estudiante) estudianteFactory.crear();
        estudiante.setId(id);
        estudiante.setCodigo(codigo);
        estudiante.setPromedio(promedio);
        estudiante.setActivo(estado);
        estudiante.setPrograma(programa);

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Service.CursoDao;
import com.mycompany.aplicacionpoo.Service.Impl.CursoDaoImpl;
import com.mycompany.aplicacionpoo.Factory.Impl.CursoFactory;
import com.mycompany.aplicacionpoo.Factory.Impl.ProgramaFactory;
import com.mycompany.aplicacionpoo.Model.Curso;
import com.mycompany.aplicacionpoo.Model.Programa;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class CursoController {
    private final CursoDao cursoDao;
    private final ProgramaFactory programaFactory;
    private final CursoFactory cursoFactory;

     
    public CursoController(){
        this.cursoDao = new CursoDaoImpl();
        this.cursoFactory = new CursoFactory();
        this.programaFactory = new ProgramaFactory();
    }
    
    
    public void agregarCurso(int id, String nombre, boolean estado, double idPrograma){
        
        Programa p = (Programa) programaFactory.crear();
        p.setId(idPrograma);
        
        Curso curso = (Curso) cursoFactory.crear();
        curso.setId(id);
        curso.setNombre(nombre);
        curso.setActivo(estado);
        curso.setPrograma(p);
        
        cursoDao.agregarCurso(curso);
    }
    
    public void actualizarCurso(int id, String nombre, boolean estado, double idPrograma){
        
        Programa p = (Programa) programaFactory.crear();
        p.setId(idPrograma);
        
        Curso curso = (Curso) cursoFactory.crear();
        curso.setId(id);
        curso.setNombre(nombre);
        curso.setActivo(estado);
        curso.setPrograma(p);
        
        cursoDao.actualizarCurso(curso);
    }
    
    public void eliminarCurso(int id){
        cursoDao.eliminarCurso(id);
    }
    
    public Curso buscarCurso(int id){
        return cursoDao.buscarCurso(id);
    }
    
    public ArrayList<Curso> mostrarCurso(){
        return cursoDao.mostrarCurso();
    }
}

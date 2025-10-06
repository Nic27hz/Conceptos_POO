/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Model;

import com.mycompany.aplicacionpoo.Observer.Observable;
import com.mycompany.aplicacionpoo.Observer.Observer;
import java.util.ArrayList;


/**
 *
 * @author nicol
 */
public class Inscripcion implements Observable{
    private Curso curso;
    private int año;
    private int semestre;
    private Estudiante estudiante;
    
    private ArrayList<Observer> observadores = new ArrayList<>();

    public Inscripcion(Curso curso, int año, int semestre, Estudiante estudiante) {
        this.curso = curso;
        this.año = año;
        this.semestre = semestre;
        this.estudiante = estudiante;
    }

    public Inscripcion() {
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }   
    
    @Override
    public String toString() {
        return String.format(
            "Inscripcion{curso='%s', año=%d, semestre=%d, estudiante='%s (%s)'}",
            curso.getNombre(), año, semestre,
            estudiante.getNombres() + " " + estudiante.getApellidos(),
            estudiante.getCodigo()
        );
    }
    
    @Override
    public void agregarObservador(Observer o) {
        observadores.add(o);
    }

    @Override
    public void notificar(String mensaje) {
        for (Observer o : observadores) {
            o.actualizar(mensaje);
        }
    }

    @Override
    public void eliminarObservador(Observer observer) {
        observadores.remove(observer);
    }
}

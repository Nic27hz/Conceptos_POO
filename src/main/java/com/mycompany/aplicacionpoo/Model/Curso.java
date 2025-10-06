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
public class Curso implements Observable{
    private int id;
    private String nombre;
    private Programa programa;
    private boolean activo;
    
    private ArrayList<Observer> observadores = new ArrayList<>();

    public Curso(int id, String nombre, Programa programa, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.programa = programa;
        this.activo = activo;
    }

    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return String.format(
            "Curso{id=%d, nombre='%s', programa=%s, activo=%b}",
            id, nombre, programa, activo
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

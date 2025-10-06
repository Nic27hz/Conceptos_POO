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
public class Persona implements Observable{
    private double id;
    private String nombres;
    private String apellidos;
    private String email;
    private String tipo;
    
    ArrayList<Observer> observadores = new ArrayList<>();
    
    public Persona(double id, String nombres, String apellidos, String email, String tipo){
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.tipo = tipo;
    }

    public Persona() {
    }
    
    public double getId(){
        return id;
    }
    public void setId(double id){
        this.id = id;
    }
        public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + ", tipo=" + tipo + '}';
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

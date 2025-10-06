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
public class Profesor extends Persona implements Observable{
    
    private String tipoContrato;
    private ArrayList<Observer> observadores = new ArrayList<>();

    public Profesor(double id, String nombres, String apellidos, String email, String tipoContrato) {
        super(id, nombres, apellidos, email, "profesor");
        this.tipoContrato = tipoContrato;
    }

    public Profesor() {
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    @Override
    public String toString() {
        return String.format(
            "Profesor{%s, tipoContrato='%s'}",
            super.toString(), tipoContrato
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

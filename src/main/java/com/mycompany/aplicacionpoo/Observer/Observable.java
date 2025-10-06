/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aplicacionpoo.Observer;

/**
 *
 * @author nicol
 */
public interface Observable {
    void agregarObservador(Observer observer);
    void eliminarObservador(Observer observer);
    void notificar(String mensaje);
}

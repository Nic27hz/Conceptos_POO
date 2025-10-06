/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aplicacionpoo.Service;

import com.mycompany.aplicacionpoo.Model.Profesor;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public interface ProfesorDao {
    public void agregarProfesor(Profesor profesor);
    public void actualizarProfesor(Profesor profesor);
    public void eliminarProfesor(Profesor profesor);
    public Profesor buscarProfesor(int id);
    public ArrayList<Profesor> mostrarProfesor();
}

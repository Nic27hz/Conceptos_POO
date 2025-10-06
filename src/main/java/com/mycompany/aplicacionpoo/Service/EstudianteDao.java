/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aplicacionpoo.Service;

import com.mycompany.aplicacionpoo.Model.Estudiante;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public interface EstudianteDao {
    public void agregarEstudiante(Estudiante estudiante);
    public void actualizarEstudiante(Estudiante estudiante);
    public void eliminarEstudiante(Estudiante estudiante);
    public Estudiante buscarEstudiante(double id);
    public ArrayList<Estudiante> mostrarEstudiante();
}

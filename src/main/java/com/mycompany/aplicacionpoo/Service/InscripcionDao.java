/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aplicacionpoo.Service;
import com.mycompany.aplicacionpoo.Model.Inscripcion;
import java.util.ArrayList;

/**
 *
 * @author alexi
 */
public interface InscripcionDao {
    void agregarInscripcion(Inscripcion inscripcion);
    void actualizarInscripcion(Inscripcion inscripcion);
    void eliminarInscripcion(Inscripcion inscripcion);
    Inscripcion buscarInscripcion(double idEstudiante, int id);
    ArrayList<Inscripcion> mostrarInscripciones();
}

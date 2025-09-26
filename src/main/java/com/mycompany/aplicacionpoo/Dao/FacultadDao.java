/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aplicacionpoo.Dao;

import com.mycompany.aplicacionpoo.Model.Facultad;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public interface FacultadDao {
    void agregarFacultad(Facultad facultad);
    void actualizarFacultad(Facultad facultad);
    void eliminarFacultad(int id);
    Facultad buscarFacultad(int id);
    ArrayList<Facultad> mostrarFacultad();
}

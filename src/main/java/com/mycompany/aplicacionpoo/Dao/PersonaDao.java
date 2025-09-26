/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aplicacionpoo.Dao;

import com.mycompany.aplicacionpoo.Model.Persona;
import java.util.ArrayList;

public interface PersonaDao {
    void guardarPersona(Persona persona);
    void eliminarPersona(int id);
    void actualizarPersona(Persona persona);
    ArrayList<Persona> mostrarPersona();
    Persona buscarPersona(int id);
}

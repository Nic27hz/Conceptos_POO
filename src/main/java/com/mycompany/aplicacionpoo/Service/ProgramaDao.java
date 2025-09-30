/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aplicacionpoo.Service;

import com.mycompany.aplicacionpoo.Model.Programa;
import java.util.ArrayList;

/**
 *
 * @author alexi
 */
public interface ProgramaDao {
    void guardarPrograma(Programa programa);
    
    void actualizarPrograma(Programa programa);
    
    void eliminarPrograma(double id);
    
    Programa buscarPrograma(double id);
    
    ArrayList<Programa> mostrarProgramas();   
}

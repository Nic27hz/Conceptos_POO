/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aplicacionpoo.Service;

import com.mycompany.aplicacionpoo.Model.Curso;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public interface CursoDao {
    void agregarCurso(Curso curso);
    void actualizarCurso(Curso curso);
    void eliminarCurso(int id);
    Curso buscarCurso(int id);
    ArrayList<Curso> mostrarCurso();
}

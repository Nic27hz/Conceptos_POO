/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aplicacionpoo.Service;
import com.mycompany.aplicacionpoo.Model.CursoProfesor;
import java.util.ArrayList;
/**
 *
 * @author alexi
 */
public interface CursoProfesorDao {
    void agregarCursoProfesor(CursoProfesor cursoProfesor);
    void actualizarCursoProfesor(CursoProfesor cursoProfesor);
    void eliminarCursoProfesor(int idCurso, double idProfesor);
    CursoProfesor buscarCursoProfesor(int idCurso, double idProfesor);
    ArrayList<CursoProfesor> mostrarCursoProfesores();
}

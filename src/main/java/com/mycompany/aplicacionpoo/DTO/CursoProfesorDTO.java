/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.dto;

public class CursoProfesorDTO {
    private String nombreCurso;
    private String nombreProfesor;
    private int anio;
    private int semestre;

    public CursoProfesorDTO() {}

    public CursoProfesorDTO(String nombreCurso, String nombreProfesor, int anio, int semestre) {
        this.nombreCurso = nombreCurso;
        this.nombreProfesor = nombreProfesor;
        this.anio = anio;
        this.semestre = semestre;
    }

    public String getNombreCurso() { return nombreCurso; }
    public void setNombreCurso(String nombreCurso) { this.nombreCurso = nombreCurso; }

    public String getNombreProfesor() { return nombreProfesor; }
    public void setNombreProfesor(String nombreProfesor) { this.nombreProfesor = nombreProfesor; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }
}


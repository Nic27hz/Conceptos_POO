/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO;

import java.time.LocalDate;

public class InscripcionDTO {
    private String nombreEstudiante;
    private String nombreCurso;
    private LocalDate fechaInscripcion;

    public InscripcionDTO() {}

    public InscripcionDTO(String nombreEstudiante, String nombreCurso, LocalDate fechaInscripcion) {
        this.nombreEstudiante = nombreEstudiante;
        this.nombreCurso = nombreCurso;
        this.fechaInscripcion = fechaInscripcion;
    }

    // Getters y Setters
    public String getNombreEstudiante() { return nombreEstudiante; }
    public void setNombreEstudiante(String nombreEstudiante) { this.nombreEstudiante = nombreEstudiante; }

    public String getNombreCurso() { return nombreCurso; }
    public void setNombreCurso(String nombreCurso) { this.nombreCurso = nombreCurso; }

    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(LocalDate fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
}


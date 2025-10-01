/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO;


public class EstudianteDTO extends PersonaDTO {
    private double codigo;
    private ProgramaDTO programa;
    private boolean activo;
    private double promedio;

    public EstudianteDTO(double codigo, ProgramaDTO programa, boolean activo, double promedio) {
        this.codigo = codigo;
        this.programa = programa;
        this.activo = activo;
        this.promedio = promedio;
    }
    
    public EstudianteDTO(double id, String nombres, String apellidos, String email,
                         double codigo, ProgramaDTO programa, boolean activo, double promedio) {
        super(id, nombres, apellidos, email, "Estudiante");
        this.codigo = codigo;
        this.programa = programa;
        this.activo = activo;
        this.promedio = promedio;
    }
    
    public EstudianteDTO() {}

    public double getCodigo() { return codigo; }
    public void setCodigo(double codigo) { this.codigo = codigo; }

    public ProgramaDTO getPrograma() { return programa; }
    public void setPrograma(ProgramaDTO programa) { this.programa = programa; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }
}

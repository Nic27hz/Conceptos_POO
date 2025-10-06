/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO;

import com.mycompany.aplicacionpoo.Observer.Observable;
import com.mycompany.aplicacionpoo.Observer.Observer;
import java.util.ArrayList;


public class CursoDTO{
    private int id;
    private String nombre;
    private ProgramaDTO programa;
    private boolean activo;

    public CursoDTO(int id, String nombre, ProgramaDTO programa, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.programa = programa;
        this.activo = activo;
    }

    public CursoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProgramaDTO getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaDTO programa) {
        this.programa = programa;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}


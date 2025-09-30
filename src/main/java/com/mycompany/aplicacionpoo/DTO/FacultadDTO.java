/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO;

public class FacultadDTO {
    private double id;
    private String nombre;
    private PersonaDTO decano;

    public FacultadDTO() {}

    public FacultadDTO(double id, String nombre, PersonaDTO decano) {
        this.id = id;
        this.nombre = nombre;
        this.decano = decano;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PersonaDTO getDecano() {
        return decano;
    }

    public void setDecano(PersonaDTO decano) {
        this.decano = decano;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.DTO;

public class ProfesorDTO extends PersonaDTO {

    private String tipoContrato;

    public ProfesorDTO(double id, String nombres, String apellidos, String email, String tipoContrato) {
        super(id, nombres, apellidos, email, "profesor"); 
        this.tipoContrato = tipoContrato;
    }

    public ProfesorDTO() {
    }
    

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
}

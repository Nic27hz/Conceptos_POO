package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.Dao.Impl.PersonaDaoImpl;
import com.mycompany.aplicacionpoo.Dao.PersonaDao;
import com.mycompany.aplicacionpoo.Model.Persona;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author nicol
 */
public class PersonaController {
    private PersonaDao personaDao;

    public PersonaController() {
        this.personaDao = new PersonaDaoImpl();
    }

    public void guardarPersona(Persona persona){
        personaDao.guardarPersona(persona);
    }
    
    public void actualizarPersona(Persona persona){
        personaDao.actualizarPersona(persona);
    }
    
    public void eliminarPersona(int id){
        personaDao.eliminarPersona(id);
    }
    
    public ArrayList<Persona> mostrarPersona(){
        return personaDao.mostrarPersona();
    }
    
    public Persona buscarPersona(int id){
        return personaDao.buscarPersona(id);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Factory.Impl;

import com.mycompany.aplicacionpoo.Factory.Factory;
import com.mycompany.aplicacionpoo.Model.Curso;

/**
 *
 * @author nicol
 */
public class CursoFactory implements Factory{
    
    @Override
    public Object crear(){
        return new Curso();
    }
}

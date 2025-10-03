/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.DTO.Mapper.ProfesorMapper;
import com.mycompany.aplicacionpoo.DTO.ProfesorDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.ProfesorFactoryDTO;
import com.mycompany.aplicacionpoo.Service.Impl.ProfesorDaoImpl;
import com.mycompany.aplicacionpoo.Service.ProfesorDao;
import com.mycompany.aplicacionpoo.Model.Profesor;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author nicol
 */

public class ProfesorController {
    private final ProfesorDao profesorDao;
    private final ProfesorFactoryDTO profesorFactory;

    public ProfesorController() {
        this.profesorDao = new ProfesorDaoImpl();
        this.profesorFactory = new ProfesorFactoryDTO();
    }

    public void agregarProfesor(int id, String tipoContrato) {
        ProfesorDTO dto = (ProfesorDTO) profesorFactory.crearVacio();
        dto.setId(id);
        dto.setTipoContrato(tipoContrato);

        Profesor profesor = ProfesorMapper.toEntity(dto);
        profesorDao.agregarProfesor(profesor);
    }

    public void actualizarProfesor(int id, String tipoContrato) {
        ProfesorDTO dto = (ProfesorDTO) profesorFactory.crearVacio();
        dto.setId(id);
        dto.setTipoContrato(tipoContrato);

        Profesor profesor = ProfesorMapper.toEntity(dto);
        profesorDao.actualizarProfesor(profesor);
    }

    public void eliminarProfesor(int id) {
        profesorDao.eliminarProfesor(id);
    }

    public ProfesorDTO buscarProfesor(int id) {
        Profesor profesor = profesorDao.buscarProfesor(id);
        return ProfesorMapper.toDTO(profesor);
    }

    public List<ProfesorDTO> mostrarProfesor() {
        ArrayList<Profesor> lista = profesorDao.mostrarProfesor();
        return ProfesorMapper.toDTOList(lista);
    }
}

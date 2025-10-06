/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.DTO.FacultadDTO;
import com.mycompany.aplicacionpoo.DTO.Mapper.FacultadMapper;
import com.mycompany.aplicacionpoo.DTO.ProfesorDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.FacultadFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.ProfesorFactoryDTO;
import com.mycompany.aplicacionpoo.Service.FacultadDao;
import com.mycompany.aplicacionpoo.Service.Impl.FacultadDaoImpl;
import com.mycompany.aplicacionpoo.Model.Facultad;
import com.mycompany.aplicacionpoo.Observer.Impl.FacultadObserver;
import java.util.List;


/**
 *
 * @author nicol
 */
public class FacultadController {
    private final FacultadDao facultadDao;
    private final FacultadFactoryDTO facultadFactory;
    private final ProfesorFactoryDTO profesorFactory;


    public FacultadController() {
        this.facultadDao = new FacultadDaoImpl();
        this.profesorFactory = new ProfesorFactoryDTO();
        this.facultadFactory = new FacultadFactoryDTO();
    }
    
    public void agregarFacultad(int id, String nombre, int idDecano) {
              
        ProfesorDTO decano = (ProfesorDTO) profesorFactory.crearVacio();
        decano.setId(idDecano);
        
        FacultadDTO facultad = facultadFactory.crear(id, nombre, decano);
        
        Facultad facu = FacultadMapper.toEntity(facultad);

        facultadDao.agregarFacultad(facu);
        facu.agregarObservador(new FacultadObserver("Observador Facultad: "));
        facu.notificar("Se agregó una Facultad: " + facu.getNombre());
    }

    public void actualizarFacultad(int id, String nombre, int idDecano) {
        
        ProfesorDTO decano = (ProfesorDTO) profesorFactory.crearVacio();
        decano.setId(idDecano);
        
        FacultadDTO facultad = facultadFactory.crear(id, nombre, decano);
        
        Facultad facu = FacultadMapper.toEntity(facultad);

        facultadDao.agregarFacultad(facu);
        facu.agregarObservador(new FacultadObserver("Observador Facultad: "));
        facu.notificar("Se actualizó una Facultad con Id: " + facu.getId());
    }
    
    public void eliminarFacultad(int id){
        
        FacultadDTO facultad = (FacultadDTO) facultadFactory.crearVacio();
        facultad.setId(id);
        
        Facultad facul = FacultadMapper.toEntity(facultad);
        
        facultadDao.eliminarFacultad(facul);
        facul.agregarObservador(new FacultadObserver("Observador Facultad: "));
        facul.notificar("Se eliminó una Facultad con Id: " + facul.getId());
    }
    
    public FacultadDTO buscarFacultad(int id){
        Facultad facultad = facultadDao.buscarFacultad(id);
        return FacultadMapper.toDTO(facultad);
    }
    
    public List<FacultadDTO> mostrarFacultad(){
        List<Facultad> facultad = facultadDao.mostrarFacultad();
        return FacultadMapper.toDTOList(facultad);
    }
}

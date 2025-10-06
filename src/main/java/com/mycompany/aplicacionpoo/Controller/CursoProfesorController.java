package com.mycompany.aplicacionpoo.Controller;

import com.mycompany.aplicacionpoo.DTO.CursoDTO;
import com.mycompany.aplicacionpoo.DTO.CursoProfesorDTO;
import com.mycompany.aplicacionpoo.DTO.Mapper.CursoProfesorMapper;
import com.mycompany.aplicacionpoo.DTO.ProfesorDTO;
import com.mycompany.aplicacionpoo.Service.CursoProfesorDao;
import com.mycompany.aplicacionpoo.Service.Impl.CursoProfesorDaoImpl;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.CursoFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.CursoProfesorFactoryDTO;
import com.mycompany.aplicacionpoo.Factory.Impl.DTO.ProfesorFactoryDTO;
import com.mycompany.aplicacionpoo.Model.CursoProfesor;
import com.mycompany.aplicacionpoo.Observer.Impl.CursoProfesorObserver;
import java.util.List;

public class CursoProfesorController {

    private final CursoProfesorDao cursoProfesorDao;
    private final CursoFactoryDTO cursoFactory;
    private final CursoProfesorFactoryDTO cursoProfesorFactory;
    private final ProfesorFactoryDTO profesorFactory;

    public CursoProfesorController() {
        this.cursoProfesorDao = new CursoProfesorDaoImpl();
        this.cursoFactory = new CursoFactoryDTO();
        this.cursoProfesorFactory = new CursoProfesorFactoryDTO();
        this.profesorFactory = new ProfesorFactoryDTO();
    }

    public void agregarCursoProfesor(int año, int semestre, double idProfesor, int idCurso) {
        
        ProfesorDTO p = (ProfesorDTO) profesorFactory.crearVacio();
        p.setId(idProfesor);
        
        CursoDTO c = (CursoDTO) cursoFactory.crearVacio();
        c.setId(idCurso);
        
        CursoProfesorDTO cpd = cursoProfesorFactory.crear(p, año, semestre, c);
               
        CursoProfesor cp = CursoProfesorMapper.toEntity(cpd);
        
        cursoProfesorDao.agregarCursoProfesor(cp);
        cp.agregarObservador(new CursoProfesorObserver("Observador curso-Profesor"));
        cp.notificar("Se agrego un Curso-Profesor con ID profesor : " + idProfesor + " Curso ID: " + idCurso );
    }

    public void actualizarCursoProfesor(int año, int semestre, double idProfesor, int idCurso) {
        
        ProfesorDTO p = (ProfesorDTO) profesorFactory.crearVacio();
        p.setId(idProfesor);
        
        CursoDTO c = (CursoDTO) cursoFactory.crearVacio();
        c.setId(idCurso);
        
        CursoProfesorDTO cpd = cursoProfesorFactory.crear(p, año, semestre, c);
       
        CursoProfesor cp = CursoProfesorMapper.toEntity(cpd);
        
        cursoProfesorDao.actualizarCursoProfesor(cp);
        cp.agregarObservador(new CursoProfesorObserver("Observador curso-Profesor"));
        cp.notificar("Se actualizo un Curso-Profesor con ID profesor : " + idProfesor + " Curso ID: " + idCurso );

    }

    public void eliminarCursoProfesor(double idProfesor, int idCurso) {
        ProfesorDTO p = (ProfesorDTO) profesorFactory.crearVacio();
        p.setId(idProfesor);
        
        CursoDTO c = (CursoDTO) cursoFactory.crearVacio();
        c.setId(idCurso);
        
        CursoProfesorDTO cpd = (CursoProfesorDTO) cursoProfesorFactory.crearVacio();
        cpd.setProfesor(p);
        cpd.setCurso(c);
        
        CursoProfesor cp = CursoProfesorMapper.toEntity(cpd);
        
        cursoProfesorDao.eliminarCursoProfesor(cp);
        
        cp.agregarObservador(new CursoProfesorObserver("Observador curso-Profesor"));
        cp.notificar("Se eliminó la relación entre el profesor " + idProfesor + " y el curso " + idCurso);
    }

    public CursoProfesorDTO buscarCursoProfesor(double idProfesor, int idCurso) {
        CursoProfesor cp = cursoProfesorDao.buscarCursoProfesor((int) idProfesor, idCurso);
        return CursoProfesorMapper.toDto(cp); 
    }

    public List<CursoProfesorDTO> mostrarCursoProfesores() {
        List<CursoProfesor> cp = cursoProfesorDao.mostrarCursoProfesores();
        return CursoProfesorMapper.toDTOList(cp);
    }

}

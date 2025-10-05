/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Service.Impl;
import com.mycompany.aplicacionpoo.Config.Conexion;
import com.mycompany.aplicacionpoo.Config.ConexionFactory;
import com.mycompany.aplicacionpoo.Config.Singleton;
import com.mycompany.aplicacionpoo.Service.InscripcionDao;
import com.mycompany.aplicacionpoo.Model.Curso;
import com.mycompany.aplicacionpoo.Model.Estudiante;
import com.mycompany.aplicacionpoo.Model.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alexi
 */
public class InscripcionDaoImpl implements InscripcionDao {
    
    @Override
    public void agregarInscripcion(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripcion (anio, semestre, estudiante_id, curso_id) VALUES (?, ?, ?, ?)";
        
        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, inscripcion.getAño());
            stmt.setInt(2, inscripcion.getSemestre());
            stmt.setDouble(3, inscripcion.getEstudiante().getId());
            stmt.setInt(4, inscripcion.getCurso().getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inscripción agregada exitosamente.");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar Inscripción: " + ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
        }
    }

    @Override
    public void actualizarInscripcion(Inscripcion inscripcion) {
        String sql = "UPDATE inscripcion SET anio = ?, semestre = ? WHERE estudiante_id = ? AND curso_id = ?";
        
        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, inscripcion.getAño());
            stmt.setInt(2, inscripcion.getSemestre());
            stmt.setDouble(3, inscripcion.getEstudiante().getId());
            stmt.setInt(4, inscripcion.getCurso().getId());
            
            int filas = stmt.executeUpdate();
            
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Inscripción actualizada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe Inscripción con esos datos.");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Inscripción: " + ex.getMessage());
        }
    }

    @Override
    public void eliminarInscripcion(double idEstudiante, int idCurso) {
        String sql = "DELETE FROM inscripcion WHERE estudiante_id = ? AND curso_id = ?";
        
        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDouble(1, idEstudiante);
            stmt.setInt(2, idCurso);
            
            int filas = stmt.executeUpdate();
            
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Inscripción eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna Inscripción con esos datos.");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Inscripción: " + ex.getMessage());
        }
    }

    @Override
    public Inscripcion buscarInscripcion(double idEstudiante, int idCurso) {
        String sql = """
                     SELECT i.anio, i.semestre, 
                            e.id AS id_estudiante, p.nombre AS nombre_estudiante, 
                            c.id AS id_curso, c.nombre AS nombre_curso
                     FROM inscripcion i
                     INNER JOIN estudiante e ON i.estudiante_id = e.id
                     INNER JOIN persona p ON p.id = e.id
                     INNER JOIN curso c ON i.curso_id = c.id
                     WHERE i.estudiante_id = ? AND i.curso_id = ?
                     """;
        
        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDouble(1, idEstudiante);
            stmt.setInt(2, idCurso);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Inscripcion i = new Inscripcion();
                i.setAño(rs.getInt("anio"));
                i.setSemestre(rs.getInt("semestre"));
                
                Estudiante e = new Estudiante();
                e.setId(rs.getDouble("id_estudiante"));
                e.setNombres(rs.getString("nombre_estudiante"));
                
                Curso c = new Curso();
                c.setId(rs.getInt("id_curso"));
                c.setNombre(rs.getString("nombre_curso"));
                
                i.setEstudiante(e);
                i.setCurso(c);
                return i;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna Inscripción con esos datos.");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Inscripción: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Inscripcion> mostrarInscripciones() {
        ArrayList<Inscripcion> listaInscripcion = new ArrayList<>();
        String sql = """
                     SELECT i.anio, i.semestre, e.id AS id_estudiante, p.nombre AS nombre_estudiante, 
                            c.id AS id_curso, c.nombre AS nombre_curso
                     FROM inscripcion i
                     INNER JOIN estudiante e ON i.estudiante_id = e.id
                     INNER JOIN persona p ON p.id = e.id
                     INNER JOIN curso c ON i.curso_id = c.id
                     """;
        
        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            
            while(rs.next()){
                Inscripcion i = new Inscripcion();
                i.setAño(rs.getInt("anio"));
                i.setSemestre(rs.getInt("semestre"));
                
                Estudiante e = new Estudiante();
                e.setId(rs.getDouble("id_estudiante"));
                e.setNombres(rs.getString("nombre_estudiante"));
                
                Curso c = new Curso();
                c.setId(rs.getInt("id_curso"));
                c.setNombre(rs.getString("nombre_curso"));
                
                i.setEstudiante(e);
                i.setCurso(c);
                listaInscripcion.add(i);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo mostrar Inscripción: " + e.getMessage());
        }
        return listaInscripcion;
    }
}
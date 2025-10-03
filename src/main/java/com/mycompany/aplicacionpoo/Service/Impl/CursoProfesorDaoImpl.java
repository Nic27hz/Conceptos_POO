package com.mycompany.aplicacionpoo.Service.Impl;


import com.mycompany.aplicacionpoo.Config.Conexion;
import com.mycompany.aplicacionpoo.Config.ConexionFactory;
import com.mycompany.aplicacionpoo.Config.Singleton;
import com.mycompany.aplicacionpoo.Service.CursoProfesorDao;
import com.mycompany.aplicacionpoo.Model.Curso;
import com.mycompany.aplicacionpoo.Model.CursoProfesor;
import com.mycompany.aplicacionpoo.Model.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CursoProfesorDaoImpl implements CursoProfesorDao {

    @Override
    public void agregarCursoProfesor(CursoProfesor cp) {
        String sql = "INSERT INTO cursoprofesor (curso_id, profesor_id) VALUES (?, ?)";
        
        
        try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cp.getCurso().getId());
            stmt.setDouble(2, cp.getProfesor().getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Curso-Profesor agregado exitosamente.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar curso-profesor: " + ex.getMessage());
        }
    }

    @Override
    public void actualizarCursoProfesor(CursoProfesor cp) {
        String sql = "UPDATE cursoprofesor SET profesor_id = ? WHERE curso_id = ?";
        
        try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, cp.getProfesor().getId());
            stmt.setInt(2, cp.getCurso().getId());
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Curso-Profesor actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe relación curso-profesor con esos IDs.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar curso-profesor: " + ex.getMessage());
        }
    }

    @Override
    public void eliminarCursoProfesor(int idCurso, double idProfesor) {
        String sql = "DELETE FROM cursoprofesor WHERE curso_id = ? AND profesor_id = ?";
        
        
        try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCurso);
            stmt.setDouble(2, idProfesor);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Curso-Profesor eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe relación curso-profesor para esos IDs.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar curso-profesor: " + ex.getMessage());
        }
    }

    @Override
    public CursoProfesor buscarCursoProfesor(int idCurso, double idProfesor) {
        String sql = """
                     SELECT cp.curso_id, cp.profesor_id, 
                            c.nombre AS nombre_curso, 
                            p.nombre AS nombre_profesor
                     FROM cursoprofesor cp
                     INNER JOIN curso c ON cp.curso_id = c.id
                     INNER JOIN persona p ON cp.profesor_id = p.id
                     WHERE cp.curso_id = ? AND cp.profesor_id = ?
                     """;
        
        try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCurso);
            stmt.setDouble(2, idProfesor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                CursoProfesor cp = new CursoProfesor();
                Curso c = new Curso();
                c.setId(rs.getInt("curso_id"));
                c.setNombre(rs.getString("nombre_curso"));
                cp.setCurso(c);

                Profesor profesor = new Profesor();
                profesor.setId(rs.getDouble("profesor_id"));
                profesor.setNombres(rs.getString("nombre_profesor"));
                cp.setProfesor(profesor);

                return cp;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró relación curso-profesor.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar curso-profesor: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<CursoProfesor> mostrarCursoProfesores() {
        ArrayList<CursoProfesor> lista = new ArrayList<>();
        String sql = """
                     SELECT cp.curso_id, cp.profesor_id, 
                            c.nombre AS nombre_curso, 
                            p.nombre AS nombre_profesor
                     FROM cursoprofesor cp
                     INNER JOIN curso c ON cp.curso_id = c.id
                     INNER JOIN persona p ON cp.profesor_id = p.id
                     """;
        
        try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CursoProfesor cp = new CursoProfesor();

                Curso c = new Curso();
                c.setId(rs.getInt("curso_id"));
                c.setNombre(rs.getString("nombre_curso"));
                cp.setCurso(c);

                Profesor profesor = new Profesor();
                profesor.setId(rs.getDouble("profesor_id"));
                profesor.setNombres(rs.getString("nombre_profesor"));
                cp.setProfesor(profesor);

                lista.add(cp);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar curso-profesor: " + ex.getMessage());
        }
        return lista;
    }
}

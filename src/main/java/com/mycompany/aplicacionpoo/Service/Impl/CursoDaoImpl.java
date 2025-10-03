package com.mycompany.aplicacionpoo.Service.Impl;


import com.mycompany.aplicacionpoo.Config.Conexion;
import com.mycompany.aplicacionpoo.Config.ConexionFactory;
import com.mycompany.aplicacionpoo.Config.Singleton;
import com.mycompany.aplicacionpoo.Service.CursoDao;
import com.mycompany.aplicacionpoo.Model.Curso;
import com.mycompany.aplicacionpoo.Model.Programa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CursoDaoImpl implements CursoDao {

    @Override
    public ArrayList<Curso> mostrarCurso() {
        ArrayList<Curso> listaCurso = new ArrayList<>();

        String sql = """
                     SELECT c.id, c.nombre, c.activo, 
                            p.id AS id_programa, p.nombre AS nombre_programa
                     FROM curso c
                     INNER JOIN programa p ON c.programa_id = p.id;
                     """;

        
        try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso c = new Curso();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setActivo(rs.getBoolean("activo"));

                Programa p = new Programa();
                p.setId(rs.getDouble("id_programa"));
                p.setNombre(rs.getString("nombre_programa"));

                c.setPrograma(p);
                listaCurso.add(c);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar Curso: " + e.getMessage());
        }
        return listaCurso;
    }

    @Override
    public void agregarCurso(Curso curso) {
        String sql = "INSERT INTO curso (id, nombre, activo, programa_id) VALUES (?, ?, ?, ?)";

        
        try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, curso.getId());
            stmt.setString(2, curso.getNombre());
            stmt.setBoolean(3, curso.isActivo());
            stmt.setDouble(4, curso.getPrograma().getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Curso agregado exitosamente.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar Curso: " + ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
        }
    }

    @Override
    public void eliminarCurso(int id) {
        String sql = "DELETE FROM curso WHERE id = ?";

        try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Curso eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningún Curso con ese ID.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }

    @Override
    public Curso buscarCurso(int id) {
        String sql = """
                     SELECT c.id, c.nombre, c.activo, 
                            p.id AS id_programa, p.nombre AS nombre_programa
                     FROM curso c
                     INNER JOIN programa p ON p.id = c.programa_id
                     WHERE c.id = ?;
                     """;

        
        try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Curso c = new Curso();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setActivo(rs.getBoolean("activo"));

                Programa p = new Programa();
                p.setId(rs.getDouble("id_programa"));
                p.setNombre(rs.getString("nombre_programa"));

                c.setPrograma(p);
                return c;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna Información de curso.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar información: " + ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return null;
    }

    @Override
    public void actualizarCurso(Curso curso) {
        String sql = "UPDATE curso SET nombre = ?, activo = ?, programa_id = ? WHERE id = ?";

        Conexion adapter = ConexionFactory.getConexion();
        try(Connection conn = adapter.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, curso.getNombre());
            stmt.setBoolean(2, curso.isActivo());
            stmt.setDouble(3, curso.getPrograma().getId());
            stmt.setInt(4, curso.getId());

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Curso actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningún Curso con ese ID.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }
}

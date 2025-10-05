package com.mycompany.aplicacionpoo.Service.Impl;

import com.mycompany.aplicacionpoo.Config.Conexion;
import com.mycompany.aplicacionpoo.Config.ConexionFactory;
import com.mycompany.aplicacionpoo.Config.Singleton;
import com.mycompany.aplicacionpoo.Service.FacultadDao;
import com.mycompany.aplicacionpoo.Model.Facultad;
import com.mycompany.aplicacionpoo.Model.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FacultadDaoImpl implements FacultadDao {

    @Override
    public ArrayList<Facultad> mostrarFacultad() {
        ArrayList<Facultad> listaFacultad = new ArrayList<>();

        String sql = """
                     SELECT f.id, f.nombre, p.id as id_decano, p.nombre as nombre_decano
                     FROM persona p
                     INNER JOIN facultad f ON p.id = f.decano_id;
                     """;

        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Facultad f = new Facultad();
                f.setId(rs.getInt("id"));
                f.setNombre(rs.getString("nombre"));

                Persona decano = new Persona();
                decano.setId(rs.getInt("id_decano"));
                decano.setNombres(rs.getString("nombre_decano"));

                f.setDecano(decano);

                listaFacultad.add(f);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar Facultad: " + e.getMessage());
        }
        return listaFacultad;
    }

    @Override
    public void agregarFacultad(Facultad facultad) {
        String validarSql = "SELECT tipo FROM persona WHERE id = ?";
        String sql = "INSERT INTO facultad (id, nombre, decano_id) VALUES (?, ?, ?)";

        Connection conn = Singleton.getInstance().getConnection();

        try{            
            try (PreparedStatement stmtValidar = conn.prepareStatement(validarSql)) {
                stmtValidar.setInt(1, (int) facultad.getDecano().getId());
                try (ResultSet rs = stmtValidar.executeQuery()) {
                    if (rs.next()) {
                        String tipo = rs.getString("tipo");

                        if (!"profesor".equalsIgnoreCase(tipo)) {
                            JOptionPane.showMessageDialog(null,
                                    "El ID corresponde a una persona tipo " + tipo +
                                            ", no puede agregarse como decano.");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "No existe ninguna Persona con ese ID.");
                        return;
                    }
                }
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, (int) facultad.getId());
                stmt.setString(2, facultad.getNombre());
                stmt.setInt(3, (int) facultad.getDecano().getId());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Facultad agregada exitosamente.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar Facultad: " + ex.getMessage());
        }
    }

    @Override
    public void actualizarFacultad(Facultad facultad) {
        String sql = "UPDATE facultad SET decano_id = ?, nombre = ? WHERE id = ?";

        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, (int) facultad.getDecano().getId());
            stmt.setString(2, facultad.getNombre());
            stmt.setInt(3, (int) facultad.getId());

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Facultad actualizada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe Facultad con ese ID.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Facultad: " + ex.getMessage());
        }
    }

    @Override
    public void eliminarFacultad(int id) {
        String sql = "DELETE FROM facultad WHERE id = ?";

        
        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Facultad eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna Facultad con ese ID.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Facultad: " + ex.getMessage());
        }
    }

    @Override
    public Facultad buscarFacultad(int id) {
        String sql = """
                     SELECT p.id, p.nombre, p.apellido, p.correo, 
                            f.nombre as nombre_facultad, f.id as id_facultad
                     FROM persona p
                     INNER JOIN facultad f ON p.id = f.decano_id
                     WHERE f.id = ?;
                     """;

        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Facultad f = new Facultad();

                f.setId(rs.getInt("id_facultad"));
                f.setNombre(rs.getString("nombre_facultad"));

                Persona decano = new Persona();
                decano.setId(rs.getInt("id"));
                decano.setNombres(rs.getString("nombre"));
                decano.setApellidos(rs.getString("apellido"));
                decano.setEmail(rs.getString("correo"));

                f.setDecano(decano);

                return f;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Facultad: " + ex.getMessage());
        }
        return null;
    }
}

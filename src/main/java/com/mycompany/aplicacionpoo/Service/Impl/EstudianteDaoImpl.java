/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Service.Impl;


import com.mycompany.aplicacionpoo.Singleton.Singleton;
import com.mycompany.aplicacionpoo.Service.EstudianteDao;
import com.mycompany.aplicacionpoo.Model.Estudiante;
import com.mycompany.aplicacionpoo.Model.Programa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */

public class EstudianteDaoImpl implements EstudianteDao {

    @Override
    public ArrayList<Estudiante> mostrarEstudiante() {
        ArrayList<Estudiante> listaEstudiante = new ArrayList<>();
        String sql = """
                     SELECT pe.id, e.codigo, pe.nombre, e.promedio, e.activo, p.nombre AS nombre_programa
                     FROM estudiante e
                     INNER JOIN persona pe ON e.id = pe.id
                     INNER JOIN programa p ON e.programa_id = p.id
                     """;

        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estudiante e = new Estudiante();
                e.setId(rs.getDouble("id"));
                e.setCodigo(rs.getDouble("codigo"));
                e.setNombres(rs.getString("nombre"));
                e.setActivo(rs.getBoolean("activo"));
                e.setPromedio(rs.getDouble("promedio"));

                Programa p = new Programa();
                p.setNombre(rs.getString("nombre_programa"));

                e.setPrograma(p);
                listaEstudiante.add(e);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error al mostrar estudiantes", ex);
        }
        return listaEstudiante;
    }

    @Override
    public void agregarEstudiante(Estudiante estudiante) {
        String sql = "INSERT INTO estudiante (id, codigo, promedio, activo, programa_id) VALUES (?, ?, ?, ?, ?)";

        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, estudiante.getId());
            stmt.setDouble(2, estudiante.getCodigo());
            stmt.setDouble(3, estudiante.getPromedio());
            stmt.setBoolean(4, estudiante.isActivo());
            stmt.setDouble(5, estudiante.getPrograma().getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error al agregar estudiante", ex);
        }
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        String sql = "DELETE FROM estudiante WHERE id = ?";
        
        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, estudiante.getId());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error al eliminar estudiante", ex);
        }
    }

    @Override
    public Estudiante buscarEstudiante(double id) {
        String sql = """
                     SELECT pe.id, e.codigo, e.promedio, e.activo, pe.nombre, p.id AS id_programa, p.nombre AS nombre_programa
                     FROM estudiante e
                     INNER JOIN persona pe ON pe.id = e.id
                     INNER JOIN programa p ON p.id = e.programa_id
                     WHERE e.id = ?
                     """;

        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Estudiante e = new Estudiante();
                e.setId(rs.getDouble("id"));
                e.setCodigo(rs.getDouble("codigo"));
                e.setNombres(rs.getString("nombre"));
                e.setActivo(rs.getBoolean("activo"));
                e.setPromedio(rs.getDouble("promedio"));

                Programa p = new Programa();
                p.setId(rs.getDouble("id_programa"));
                p.setNombre(rs.getString("nombre_programa"));

                e.setPrograma(p);
                return e;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al buscar estudiante", ex);
        }
        return null;
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {
        String sql = "UPDATE estudiante SET codigo = ?, promedio = ?, activo = ?, programa_id = ? WHERE id = ?";

        Connection conn = Singleton.getInstance().getConnection();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, estudiante.getCodigo());
            stmt.setDouble(2, estudiante.getPromedio());
            stmt.setBoolean(3, estudiante.isActivo());
            stmt.setDouble(4, estudiante.getPrograma().getId());
            stmt.setDouble(5, estudiante.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error al actualizar estudiante", ex);
        }
    }
}


package com.mycompany.aplicacionpoo.Service.Impl;


import com.mycompany.aplicacionpoo.Config.Conexion;
import com.mycompany.aplicacionpoo.Config.ConexionFactory;
import com.mycompany.aplicacionpoo.Config.Singleton;
import com.mycompany.aplicacionpoo.Service.ProfesorDao;
import com.mycompany.aplicacionpoo.Model.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorDaoImpl implements ProfesorDao {

    @Override
    public void agregarProfesor(Profesor profesor) {
        String validarSql = "SELECT tipo FROM persona WHERE id = ?";
        String sql = "INSERT INTO profesor (id, tipo_contrato) VALUES (?, ?)";

         
        try(Connection conn = Singleton.getInstance().getConnection()) {
            
            try (PreparedStatement stmtValidar = conn.prepareStatement(validarSql)) {
                stmtValidar.setInt(1, (int) profesor.getId());
                try (ResultSet rs = stmtValidar.executeQuery()) {
                    if (rs.next()) {
                        String tipo = rs.getString("tipo");
                        if (!"profesor".equalsIgnoreCase(tipo)) {
                            
                        }
                    } else {
                        
                    }
                }
            }

            
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, (int) profesor.getId());
                stmt.setString(2, profesor.getTipoContrato());
                stmt.executeUpdate();
                
            }

        } catch (SQLException ex) {
            
        }
    }

    @Override
    public void actualizarProfesor(Profesor profesor) {
        String sql = "UPDATE profesor SET tipo_contrato = ? WHERE id = ?";

         
        try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, profesor.getTipoContrato());
            stmt.setInt(2, (int) profesor.getId());

            int filas = stmt.executeUpdate();

        } catch (SQLException ex) {
            
        }
    }

    @Override
    public void eliminarProfesor(int id) {
        String sql = "DELETE FROM profesor WHERE id = ?";

         try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            

        } catch (SQLException ex) {
            
        }
    }

    @Override
    public ArrayList<Profesor> mostrarProfesor() {
        ArrayList<Profesor> listaProfesor = new ArrayList<>();

        String sql = """
                     SELECT p.id, p.nombre, p.apellido, p.correo, pr.tipo_contrato
                     FROM persona p
                     INNER JOIN profesor pr ON p.id = pr.id
                     """;

         try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Profesor p = new Profesor();
                p.setId(rs.getInt("id"));
                p.setNombres(rs.getString("nombre"));
                p.setApellidos(rs.getString("apellido"));
                p.setEmail(rs.getString("correo"));
                p.setTipoContrato(rs.getString("tipo_contrato"));

                listaProfesor.add(p);
            }

        } catch (SQLException e) {
        }

        return listaProfesor;
    }

    @Override
    public Profesor buscarProfesor(int id) {
        String sql = """
                     SELECT p.id, p.nombre, p.apellido, p.correo, pr.tipo_contrato
                     FROM persona p
                     INNER JOIN profesor pr ON p.id = pr.id
                     WHERE p.id = ?
                     """;

         try(Connection conn = Singleton.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Profesor p = new Profesor();
                p.setId(rs.getInt("id"));
                p.setNombres(rs.getString("nombre"));
                p.setApellidos(rs.getString("apellido"));
                p.setEmail(rs.getString("correo"));
                p.setTipoContrato(rs.getString("tipo_contrato"));
                return p;
            }

        } catch (SQLException ex) {
        }

        return null;
    }
}

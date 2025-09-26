/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Dao.Impl;

import com.mycompany.aplicacionpoo.Config.ConexionDB;
import com.mycompany.aplicacionpoo.Dao.PersonaDao;
import com.mycompany.aplicacionpoo.Model.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PersonaDaoImpl implements PersonaDao{
    @Override
    public void guardarPersona(Persona persona) {
        String sql = "INSERT INTO persona (nombre, apellido, correo, tipo, id) values (?, ?, ?, ?, ?)";

        try(Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, persona.getNombres());
            stmt.setString(2, persona.getApellidos());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTipo());
            stmt.setInt(5, (int) persona.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error al guardar persona", ex);
        }
    }

    @Override
    public void eliminarPersona(int id) {
        String sql = "DELETE FROM persona WHERE id = ?";

        try(Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error al eliminar persona", ex);
        }
    }

    @Override
    public void actualizarPersona(Persona persona) {
        String sql = "UPDATE persona SET nombre=?, apellido=?, correo=?, tipo=? WHERE id=?";

        try(Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, persona.getNombres());
            stmt.setString(2, persona.getApellidos());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTipo());
            stmt.setInt(5, (int) persona.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error al actualizar persona", ex);
        }
    }

    @Override
    public ArrayList<Persona> mostrarPersona() {
        ArrayList<Persona> lista = new ArrayList<>();
        String sql = "SELECT * FROM persona";

        try(Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

            while(rs.next()){
                Persona p = new Persona();
                p.setId(rs.getInt("id"));
                p.setNombres(rs.getString("nombre"));
                p.setApellidos(rs.getString("apellido"));
                p.setEmail(rs.getString("correo"));
                p.setTipo(rs.getString("tipo"));
                lista.add(p);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error al mostrar personas", ex);
        }
        return lista;
    }

    @Override
    public Persona buscarPersona(int id) {
        String sql = "SELECT * FROM persona WHERE id=?";

        try(Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                Persona p = new Persona();
                p.setId(rs.getInt("id"));
                p.setNombres(rs.getString("nombre"));
                p.setApellidos(rs.getString("apellido"));
                p.setEmail(rs.getString("correo"));
                p.setTipo(rs.getString("tipo"));
                return p;
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error al buscar persona", ex);
        }
        return null;
    }
}

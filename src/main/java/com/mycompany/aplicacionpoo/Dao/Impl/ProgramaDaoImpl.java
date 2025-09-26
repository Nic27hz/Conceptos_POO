package com.mycompany.aplicacionpoo.Dao.Impl;

import com.mycompany.aplicacionpoo.Config.ConexionDB;
import com.mycompany.aplicacionpoo.Dao.ProgramaDao;
import com.mycompany.aplicacionpoo.Model.Programa;
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
public class ProgramaDaoImpl implements ProgramaDao {

    @Override
    public void guardarPrograma(Programa programa) {
        String sql = "INSERT INTO programa (id, nombre) VALUES (?, ?)";
        
        try(Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, (int) programa.getId());
            stmt.setString(2, programa.getNombre());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Programa agregado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar Programa: " + ex.getMessage());
        }
    }

    @Override
    public void actualizarPrograma(Programa programa) {
        String sql = "UPDATE programa SET nombre = ? WHERE id = ?";
        
        try(Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, programa.getNombre());
            stmt.setInt(2, (int) programa.getId());
            
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Programa actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró Programa con ese ID.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Programa: " + ex.getMessage());
        }
    }

    @Override
    public void eliminarPrograma(double id) {
        String sql = "DELETE FROM programa WHERE id = ?";
        
        try(Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, (int) id);
            
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Programa eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe Programa con ese ID.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Programa: " + ex.getMessage());
        }
    }

    @Override
    public Programa buscarPrograma(double id) {
        String sql = "SELECT id, nombre FROM programa WHERE id = ?";
        
        try(Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, (int) id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Programa p = new Programa();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                return p;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró Programa con ese ID.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Programa: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Programa> mostrarProgramas() {
        ArrayList<Programa> lista = new ArrayList<>();
        String sql = "SELECT id, nombre FROM programa";
        
        try(Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            
            while(rs.next()) {
                Programa p = new Programa();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Programas: " + ex.getMessage());
        }
        return lista;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Singleton.Adapter;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgreSQLAdapter implements Conexion {

    @Override
    public Connection conectar() {
        Properties props = new Properties();
        Connection conexion = null;

        try {
            
            FileInputStream fis = new FileInputStream("Configuracion\\postgressql.properties");
            props.load(fis);

            
            String url = props.getProperty("URL");
            String usuario = props.getProperty("USUARIO");
            String clave = props.getProperty("CLAVE");
            String driver = props.getProperty("DRIVER");

            
            Class.forName(driver);

            
            conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión PostgreSQL establecida correctamente");
            System.out.println("Conexión establecida a las " + java.time.LocalTime.now().withNano(0));

        } catch (IOException e) {
            System.err.println("Error al leer postgresql.properties: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión PostgreSQL: " + e.getMessage());
        }

        return conexion;
    }
}


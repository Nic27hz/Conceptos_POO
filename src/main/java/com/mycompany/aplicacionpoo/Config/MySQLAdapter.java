package com.mycompany.aplicacionpoo.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLAdapter implements Conexion {

    @Override
    public Connection conectar() {
        Properties props = new Properties();
        Connection conexion = null;

        try {
            FileInputStream fis = new FileInputStream("Configuracion\\mysql.properties");
            props.load(fis);

            String url = props.getProperty("URL");
            String usuario = props.getProperty("USUARIO");
            String clave = props.getProperty("CLAVE");
            String driver = props.getProperty("DRIVER");

            Class.forName(driver);

            conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión MySQL establecida correctamente");

        } catch (IOException e) {
            System.err.println("Error al leer mysql.properties: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión MySQL: " + e.getMessage());
        }

        return conexion;
    }
}

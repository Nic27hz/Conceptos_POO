package com.mycompany.aplicacionpoo.Singleton.Adapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Adapter implements Conexion {

    @Override
    public Connection conectar() {
        String url = "jdbc:h2:./data/testdb;AUTO_SERVER=TRUE";
        String user = "sa";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a H2");
            System.out.println("Conexión establecida a las " + java.time.LocalTime.now().withNano(0));
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo conectar a la base de datos H2: " + e.getMessage(), e);
        }
    }
}

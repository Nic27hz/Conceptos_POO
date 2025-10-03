package com.mycompany.aplicacionpoo.Config;

import java.sql.Connection;

public class Singleton {
    private static Singleton instancia;  
    private Connection conexion;         

    private Singleton() {
        try {
            Conexion adapter = ConexionFactory.getConexion(); 
            this.conexion = adapter.conectar();               
        } catch (Exception e) {
            throw new RuntimeException("Error al inicializar la conexión: " + e.getMessage(), e);
        }
    }

    public static Singleton getInstance() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }

    public Connection getConnection() {
        return conexion;
    }
}

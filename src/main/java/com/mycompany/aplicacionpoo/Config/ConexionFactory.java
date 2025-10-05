/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionpoo.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConexionFactory {

    public static Conexion getConexion() {
        Properties props = new Properties();

        try {
            // Leer archivo principal
            props.load(new FileInputStream("Configuracion\\DataBase.properties"));
            String motor = props.getProperty("motor");

            if (motor == null) {
                throw new RuntimeException("No se ha definido el motor en DataBse.properties");
            }

            switch (motor.toLowerCase()) {
                case "mysql":
                    return new MySQLAdapter();
                case "postgres":
                    return new PostgreSQLAdapter();
                case "h2":
                    return new H2Adapter();
                default:
                    throw new RuntimeException("Motor no soportado: " + motor);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo db.properties", e);
        }
    }
}

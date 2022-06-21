package com.dh.storage.persistence.dao.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracionJDBC {

    private String jdbcDriver;
    private String dbUrl;
    private String nombreUsuario;
    private String contrasenaUsuario;

    public static Logger logger = Logger.getLogger(ConfiguracionJDBC.class);

    //Podemos usar este constructor para conectarnos con otra configuracion
    public ConfiguracionJDBC(String jdbcDriver, String dbUrl, String nombreUsuario, String contrasenaUsuario) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }


    public ConfiguracionJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/db_pacientes;INIT=RUNSCRIPT FROM 'create.sql'";
        this.nombreUsuario = "sa";
        this.contrasenaUsuario = "";
    }

    public Connection conectarConBaseDeDatos() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, nombreUsuario, contrasenaUsuario);
            logger.info("Se ha establecido correctamente la conexion a la base de datos");

        } catch (SQLException throwables) {

            logger.error("La conexion a la base de datos presenta problemas");
            throwables.printStackTrace();
        }

        return connection;
    }

    public void cargarElControlador(){
        try {
            Class.forName(this.jdbcDriver);
            logger.info("Se cargo correctamente el driver jdbc");
        }
        catch(ClassNotFoundException ex) {
            logger.error("Error: unable to load driver class! " + ex.getMessage());
            System.exit(1);
        }
    }



}
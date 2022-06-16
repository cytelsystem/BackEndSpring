package com.dh.odontologica.persistence.dao.impl;

import com.dh.odontologica.model.Odontologo;
import com.dh.odontologica.persistence.dao.Dao;
import com.dh.odontologica.persistence.dao.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements Dao<Odontologo> {

    private Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    ConfiguracionJDBC jdbc = new ConfiguracionJDBC("org.h2.Driver", "jdbc:h2:~/Odontologica", "sa", "" );  // instanc

    @Override
    public Odontologo crear(Odontologo odontologo) {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("INSERT into odontologos (Nombre, Apellido, NumeroMatricula) VALUES (?,?,?)");

            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getMatricula());

            preparedStatement.executeUpdate();
            preparedStatement.close();

            logger.info("Informacion Guardada correctamente");

        }catch (SQLException e) {
            logger.error("No se pudo guardar la informacion");
            e.printStackTrace();
        }

        return odontologo;
    }

    @Override
    public void eliminar(Long id) {

        jdbc.cargarElControlador();
        PreparedStatement preparedStatement = null;


        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("DELETE FROM odontologos where id= ? ");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            logger.info("Eliminacion registro No" + " " + id + " " + "fue exitosa");

        } catch (SQLException e) {
            logger.error("No se pudo eliminar el registro");
            e.printStackTrace();
        }

    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {

        jdbc.cargarElControlador();
        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("UPDATE odontologos SET nombre = ?, apellido = ?, numeroMatricula = ?  WHERE id = ?");

            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getMatricula());
            preparedStatement.setLong(4, odontologo.getId());

            preparedStatement.executeUpdate();

            logger.info("Registro Actualizado No" + " " + odontologo.getId() + " " + "fue exitoso");

        } catch (SQLException e) {
            logger.error("No se pudo actualizar el registro");
            e.printStackTrace();
        }

        return odontologo;

    }


    @Override
    public Odontologo consultarPorId(Long id) {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        Odontologo odontologo = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM odontologos where id= ? ");
            preparedStatement.setLong(1, id);


            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()) {

                Long idOdontologo = resultado.getLong("id");
                String nombreOdontologo = resultado.getString("nombre");
                String apellidoOdontologo = resultado.getString("apellido");
                String NumeroMatriculaOdontologo = resultado.getString("NumeroMatricula");


                odontologo = new Odontologo();

                odontologo.setId(idOdontologo);
                odontologo.setNombre(nombreOdontologo);
                odontologo.setApellido(apellidoOdontologo);
                odontologo.setMatricula(NumeroMatriculaOdontologo);

            }

            preparedStatement.executeQuery();
            preparedStatement.close();

            logger.info("Consulta por ID No" + " " + id + " " + "fue exitosa");

        }catch (SQLException e) {
            logger.error("Presenta problemas la consulta por ID");
            e.printStackTrace();
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> consultarTodos() {

        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        List<Odontologo> odontologos = new ArrayList<>();

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM odontologos");

            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()) {

                Long idOdontologo = resultado.getLong("id");
                String nombreOdontologo = resultado.getString("nombre");
                String apellidoOdontologo = resultado.getString("apellido");
                String NumeroMatriculaOdontologo = resultado.getString("NumeroMatricula");

                Odontologo odontologo = new Odontologo();

                odontologo.setId(idOdontologo);
                odontologo.setNombre(nombreOdontologo);
                odontologo.setApellido(apellidoOdontologo);
                odontologo.setMatricula(NumeroMatriculaOdontologo);

                odontologos.add(odontologo);
            }

            preparedStatement.executeQuery();

            logger.info("Consulta de todos los registros fue exitosa");


        }catch (SQLException e) {
            logger.error("Consulta de todos los registros presento problemas");
            e.printStackTrace();
        }

        return odontologos;
    }


}
package com.dh.storage.persistence.dao.impl;


import com.dh.storage.model.Domicilio;
import com.dh.storage.persistence.dao.Dao;
import com.dh.storage.persistence.dao.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class DomicilioDAOH2 implements Dao<Domicilio> {

    private Logger logger = Logger.getLogger(DomicilioDAOH2.class);

    ConfiguracionJDBC jdbc = new ConfiguracionJDBC("org.h2.Driver", "jdbc:h2:~/Odontologica", "sa", "" );  // instanc

    @Override
    public Domicilio crear(Domicilio domicilio) {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("INSERT into domicilios (Calle, Numero, Localidad, Provincia) VALUES (?,?,?,?)");

            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setString(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());

            preparedStatement.executeUpdate();
            preparedStatement.close();

            logger.info("Informacion Guardada correctamente");

        }catch (SQLException e) {
            logger.error("No se pudo guardar la informacion");
            e.printStackTrace();
        }

        return domicilio;
    }

    @Override
    public void eliminar(Long id) {

        jdbc.cargarElControlador();
        PreparedStatement preparedStatement = null;


        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("DELETE FROM domicilios where id= ? ");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            logger.info("Eliminacion registro No" + " " + id + " " + "fue exitosa");

        } catch (SQLException e) {
            logger.error("No se pudo eliminar el registro");
            e.printStackTrace();
        }

    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {

        jdbc.cargarElControlador();
        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("UPDATE domicilios SET Calle = ?, Numero = ?, Localidad = ?, Provincia = ?  WHERE id = ?");

            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setString(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.setLong(5, domicilio.getId());

            preparedStatement.executeUpdate();

            logger.info("Registro Actualizado No" + " " + domicilio.getId() + " " + "fue exitoso");

        } catch (SQLException e) {
            logger.error("No se pudo actualizar el registro");
            e.printStackTrace();
        }

        return domicilio;

    }


    @Override
    public Domicilio consultarPorId(Long id) {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        Domicilio domicilio = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM domicilios where id= ? ");
            preparedStatement.setLong(1, id);


            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()) {

                Long idDomicilio = resultado.getLong("id");
                String calle = resultado.getString("calle");
                String numero = resultado.getString("numero");
                String localidad = resultado.getString("localidad");
                String provincia = resultado.getString("provincia");


                domicilio = new Domicilio();

                domicilio.setId(idDomicilio);
                domicilio.setCalle(calle);
                domicilio.setNumero(numero);
                domicilio.setLocalidad(localidad);
                domicilio.setProvincia(provincia);

            }

            preparedStatement.executeQuery();
            preparedStatement.close();

            logger.info("Consulta por ID No" + " " + id + " " + "fue exitosa");

        }catch (SQLException e) {
            logger.error("Presenta problemas la consulta por ID");
            e.printStackTrace();
        }

        return domicilio;
    }

    @Override
    public List<Domicilio> consultarTodos() {

        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        List<Domicilio> domicilios = new ArrayList<>();

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM domicilios");

            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()) {

                Long domicilioId = resultado.getLong("id");
                String domicilioCalle = resultado.getString("calle");
                String domicilioNumero = resultado.getString("numero");
                String domicilioLocalidad = resultado.getString("localidad");
                String domicilioProvincia = resultado.getString("provincia");

                Domicilio domicilio = new Domicilio();

                domicilio.setId(domicilioId);
                domicilio.setCalle(domicilioCalle);
                domicilio.setNumero(domicilioNumero);
                domicilio.setLocalidad(domicilioLocalidad);
                domicilio.setProvincia(domicilioProvincia);

                domicilios.add(domicilio);
            }

            preparedStatement.executeQuery();

            logger.info("Consulta de todos los registros fue exitosa");


        }catch (SQLException e) {
            logger.error("Consulta de todos los registros presento problemas");
            e.printStackTrace();
        }

        return domicilios;
    }


}
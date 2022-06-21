package com.dh.storage.persistence.dao.impl;

import com.dh.storage.model.Turno;
import com.dh.storage.persistence.dao.Dao;
import com.dh.storage.persistence.dao.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class TurnoDAOH2 implements Dao<Turno> {

    private Logger logger = Logger.getLogger(TurnoDAOH2.class);

    ConfiguracionJDBC jdbc = new ConfiguracionJDBC("org.h2.Driver", "jdbc:h2:~/Odontologica", "sa", "" );  // instanc

    @Override
    public Turno crear(Turno turno) {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("INSERT into turnos (date, IdOdontologo, IdPaciente) VALUES (?,?,?)");

            preparedStatement.setDate(1, turno.getDate());
            preparedStatement.setLong(2, turno.getOdontologo().getId());
            preparedStatement.setLong(3, turno.getPaciente().getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

            logger.info("Informacion Guardada correctamente Turno");

        }catch (SQLException e) {
            logger.error("No se pudo guardar la informacion");
            e.printStackTrace();
        }

        return turno;
    }

    @Override
    public void eliminar(Long id) {

        jdbc.cargarElControlador();
        PreparedStatement preparedStatement = null;


        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("DELETE FROM turnos where id= ? ");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            logger.info("Eliminacion registro No" + " " + id + " " + "fue exitosa");

        } catch (SQLException e) {
            logger.error("No se pudo eliminar el registro");
            e.printStackTrace();
        }

    }

    @Override
    public Turno actualizar(Turno turno) {

        jdbc.cargarElControlador();
        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("UPDATE turnos SET date = ?, IdOdontologo = ?, IdPaciente = ?,  WHERE id = ?");

            preparedStatement.setDate(1, turno.getDate());
            preparedStatement.setLong(2, turno.getPaciente().getId());
            preparedStatement.setLong(3, turno.getOdontologo().getId());

            preparedStatement.executeUpdate();

            logger.info("Registro Actualizado No" + " " + turno.getId() + " " + "fue exitoso");

        } catch (SQLException e) {
            logger.error("No se pudo actualizar el registro");
            e.printStackTrace();
        }

        return null;

    }


    @Override
    public Turno consultarPorId(Long id) {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        Turno turno = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM turnos where id= ? ");
            preparedStatement.setLong(1, id);


            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()) {

                Long idTurno = resultado.getLong("id");
                Date fechaTurno = resultado.getDate("date");
                Long IdOdontologo = resultado.getLong("IdOdontologo");
                Long IdPaciente = resultado.getLong("Idpaciente");


                turno = new Turno();

                turno.setId(idTurno);
                turno.setDate(fechaTurno);


            }

            preparedStatement.executeQuery();
            preparedStatement.close();

            logger.info("Consulta por ID No" + " " + id + " " + "fue exitosa");

        }catch (SQLException e) {
            logger.error("Presenta problemas la consulta por ID");
            e.printStackTrace();
        }

        return turno;
    }

    @Override
    public List<Turno> consultarTodos() {

        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        List<Turno> turnos = new ArrayList<>();

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM turnos");

            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()) {

                Long idTurno = resultado.getLong("id");
                Date turnoDate = resultado.getDate("date");
                Long IdOdontologo = resultado.getLong("IdOdontologo");
                Long IdPaciente = resultado.getLong("IdPaciente");

                Turno turno = new Turno();

                turno.setId(idTurno);
                turno.setDate(turnoDate);


                turnos.add(turno);
            }


            preparedStatement.executeQuery();

            logger.info("Consulta de todos los registros fue exitosa");


        }catch (SQLException e) {
            logger.error("Consulta de todos los registros presento problemas");
            e.printStackTrace();
        }

        return turnos;
    }


}


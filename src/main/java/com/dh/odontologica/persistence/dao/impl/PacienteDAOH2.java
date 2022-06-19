package com.dh.odontologica.persistence.dao.impl;


import com.dh.odontologica.model.Paciente;
import com.dh.odontologica.persistence.dao.Dao;
import com.dh.odontologica.persistence.dao.util.ConfiguracionJDBC;
import com.dh.odontologica.persistence.dao.util.Util;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PacienteDAOH2 implements Dao<Paciente> {

    private Logger logger = Logger.getLogger(PacienteDAOH2.class);

    ConfiguracionJDBC jdbc = new ConfiguracionJDBC("org.h2.Driver", "jdbc:h2:~/Odontologica", "sa", "" );  // instanc

    @Override
    public Paciente crear(Paciente paciente) {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("INSERT into pacientes (Nombre, Apellido, email,dni,fechadeingreso) VALUES (?,?,?,?,?)");

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getEmail());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setDate(5, Util.utilDateToSqlDate(paciente.getFechaDeIngreso()));



            preparedStatement.executeUpdate();
            preparedStatement.close();

            logger.info("Informacion Guardada correctamente Paciente");

        }catch (SQLException e) {
            logger.error("No se pudo guardar la informacion");
            e.printStackTrace();
        }

        return paciente;
    }

    @Override
    public void eliminar(Long id) {

        jdbc.cargarElControlador();
        PreparedStatement preparedStatement = null;


        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("DELETE FROM pacientes where id= ? ");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            logger.info("Eliminacion registro No" + " " + id + " " + "fue exitosa");

        } catch (SQLException e) {
            logger.error("No se pudo eliminar el registro");
            e.printStackTrace();
        }

    }

    @Override
    public Paciente actualizar(Paciente paciente) {

        jdbc.cargarElControlador();
        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("UPDATE pacientes SET nombre = ?, apellido = ?, email = ?, dni = ?, fechaDeIngreso = ?  WHERE id = ?");

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getEmail());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setDate(5, (Date) paciente.getFechaDeIngreso());
            preparedStatement.setLong(6, paciente.getId());

            preparedStatement.executeUpdate();

            logger.info("Registro Actualizado No" + " " + paciente.getId() + " " + "fue exitoso");

        } catch (SQLException e) {
            logger.error("No se pudo actualizar el registro");
            e.printStackTrace();
        }

        return paciente;

    }


    @Override
    public Paciente consultarPorId(Long id) {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        Paciente paciente = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM pacientes where id= ? ");
            preparedStatement.setLong(1, id);


            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()) {

                Long idPaciente = resultado.getLong("id");
                String nombrePaciente = resultado.getString("nombre");
                String apellidoPaciente = resultado.getString("apellido");
                String emailPaciente = resultado.getString("email");
                String dniPaciente = resultado.getString("dni");
                Date fechaDeIngresoPaciente = resultado.getDate("fechaDeIngreso");


                paciente = new Paciente();

                paciente.setId(idPaciente);
                paciente.setNombre(nombrePaciente);
                paciente.setApellido(apellidoPaciente);
                paciente.setEmail(emailPaciente);
                paciente.setDni(dniPaciente);
                paciente.setFechaDeIngreso(fechaDeIngresoPaciente);


            }

            preparedStatement.executeQuery();
            preparedStatement.close();

            logger.info("Consulta por ID No" + " " + id + " " + "fue exitosa");

        }catch (SQLException e) {
            logger.error("Presenta problemas la consulta por ID");
            e.printStackTrace();
        }

        return paciente;
    }

    @Override
    public List<Paciente> consultarTodos() {

        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        List<Paciente> pacientes = new ArrayList<>();

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM pacientes");

            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()) {

                Long idPaciente = resultado.getLong("id");
                String nombrePaciente = resultado.getString("nombre");
                String apellidoPaciente = resultado.getString("apellido");
                String emailPaciente = resultado.getString("email");
                String dniPaciente = resultado.getString("dni");
                Date fechaDeIngresoPaciente = resultado.getDate("fechaDeIngreso");

                Paciente paciente = new Paciente();

                paciente.setId(idPaciente);
                paciente.setNombre(nombrePaciente);
                paciente.setApellido(apellidoPaciente);
                paciente.setEmail(emailPaciente);
                paciente.setDni(dniPaciente);
                paciente.setFechaDeIngreso(fechaDeIngresoPaciente);

                pacientes.add(paciente);
            }


            preparedStatement.executeQuery();

            logger.info("Consulta de todos los registros fue exitosa");


        }catch (SQLException e) {
            logger.error("Consulta de todos los registros presento problemas");
            e.printStackTrace();
        }

        return pacientes;
    }


}


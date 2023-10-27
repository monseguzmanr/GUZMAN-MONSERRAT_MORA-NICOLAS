package com.backend.parcial.dao.impl;

import com.backend.parcial.dao.H2Connection;
import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    @Override
    public List<Odontologo> listAll() {

        Connection connection = null;
        List<Odontologo> odontologoList = new ArrayList<>();

        try {

            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM ODONTOLOGOS");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Odontologo odontologoPersistido = new Odontologo(
                        rs.getInt("id"),
                        rs.getInt("matricula"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                );

                odontologoList.add(odontologoPersistido);
            }

            LOGGER.info("Listado de odontologos" +  odontologoList);

        } catch (Exception e) {

            LOGGER.error(e.getMessage());
            e.printStackTrace();

            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Tuvimos un problema");
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }

        } finally {

            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }

        }

        return odontologoList;
    }

    @Override
    public Odontologo save(Odontologo odontologo) {

        Connection connection = null;
        Odontologo odontologoPersistido = null;

        try {

            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO ODONTOLOGOS(MATRICULA, NOMBRE, APELLIDO) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            preparedStatement.execute();
            connection.commit();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                odontologoPersistido = new Odontologo(resultSet.getInt(1), odontologo.getNumeroMatricula(), odontologo.getNombre(), odontologo.getApellido());
            }

            LOGGER.info("odontologo guardado: " + odontologoPersistido);

        } catch (Exception e) {

            LOGGER.error(e.getMessage());
            e.printStackTrace();

            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Tuvimos un problema");
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }

        } finally {

            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }

        }

        return odontologoPersistido;
    }
}

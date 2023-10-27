package com.backend.parcial.dao.impl;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OdontologoDaoMemory implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoMemory.class);
    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public List<Odontologo> listAll() {
        LOGGER.info("Obteniendo todos los odontologos" + odontologos);
        return odontologos;
    }

    @Override
    public Odontologo save(Odontologo odontologo) {
        int id = odontologos.size() + 1;
        Odontologo nuevoOdontologo = new Odontologo(id, odontologo.getNumeroMatricula(), odontologo.getNombre(), odontologo.getApellido());
        LOGGER.info("Nuevo odontologo agregado con exito" + nuevoOdontologo);
        odontologos.add(nuevoOdontologo);
        return odontologo;
    }

}
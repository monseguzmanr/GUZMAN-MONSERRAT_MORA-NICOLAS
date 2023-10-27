package com.backend.parcial.service;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;

import java.util.List;

public class OdontolgoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontolgoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoIDao.save(odontologo);
    }

    public List<Odontologo> listarOdontologos() {
        return odontologoIDao.listAll();
    }
}

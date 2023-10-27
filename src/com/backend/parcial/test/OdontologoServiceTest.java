package com.backend.parcial.test;

import com.backend.parcial.dao.impl.OdontologoDaoH2;
import com.backend.parcial.model.Odontologo;
import com.backend.parcial.service.OdontolgoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class OdontologoServiceTest {

    @BeforeEach
    public void setup() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/parcial;INIT=RUNSCRIPT FROM 'setup-test.sql'", "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void deberiaRetornarDosOdontiologos() {
        OdontolgoService odontolgoService = new OdontolgoService(new OdontologoDaoH2());
        List<Odontologo> odontologoList = odontolgoService.listarOdontologos();
        Assertions.assertEquals(2, odontologoList.size(), "Deberian ser 2 odontoilogos");
    }



}



DROP TABLE IF EXISTS ODONTOLOGOS;
CREATE TABLE ODONTOLOGOS(ID INT AUTO_INCREMENT PRIMARY KEY, MATRICULA INT NOT NULL, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL);

INSERT INTO ODONTOLOGOS (ID, MATRICULA, NOMBRE, APELLIDO) VALUES(1, 111, 'NICO', 'MORA');
INSERT INTO ODONTOLOGOS (ID, MATRICULA, NOMBRE, APELLIDO) VALUES(2, 222, 'MONSE', 'GUZMAN');
-- =============================================
-- Author:  	Julian Barragan Verano
-- Create date: 05-FEB-2015
-- Description: Creacion de tabla usuario_operacion
-- =============================================

CREATE TABLE usuario_operacion (
  id int(11) NOT NULL AUTO_INCREMENT,
  cedula bigint(20) NOT NULL,
  nombre varchar(200) NOT NULL,
  compania varchar(200) DEFAULT NULL,
  sap bigint(20) NOT NULL,
  estado varchar(1) NOT NULL,
  contrasena varchar(45) NOT NULL,
  estado_contrasena varchar(1) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  UNIQUE KEY cedula_UNIQUE (cedula)
);


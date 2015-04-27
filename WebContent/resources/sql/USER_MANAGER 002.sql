-- =============================================
-- Author:  	Julian Barragan Verano
-- Create date: 06-ABR-2015
-- Description: Alter Table usuario_operacion
-- =============================================

ALTER TABLE usuario_operacion
ADD COLUMN email VARCHAR(100) NULL AFTER estado_contrasena,
ADD COLUMN phone BIGINT(15) NULL AFTER email,
ADD COLUMN user_create VARCHAR(45) NULL AFTER phone,
ADD COLUMN date_create DATE NULL AFTER user_create,
ADD COLUMN user_update VARCHAR(45) NULL AFTER date_create,
ADD COLUMN date_update DATE NULL AFTER user_update;

CREATE TABLE user_allowed (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_name_allowed varchar(45) NOT NULL,
  user_create varchar(45) NOT NULL,
  date_create date NOT NULL,
  user_update varchar(45) DEFAULT NULL,
  date_update date DEFAULT NULL,
  PRIMARY KEY (id)
) 

ALTER TABLE usuario_operacion 
CHANGE COLUMN date_create date_create DATETIME NULL DEFAULT NULL ,
CHANGE COLUMN date_update date_update DATETIME NULL DEFAULT NULL ;

ALTER TABLE user_allowed 
ADD UNIQUE INDEX user_name_allowed_UNIQUE (user_name_allowed ASC);

CREATE TABLE audit (
  id INT NOT NULL AUTO_INCREMENT,
  table_name VARCHAR(60) NOT NULL,
  column_name VARCHAR(60) NOT NULL,
  old_value VARCHAR(60) NOT NULL,
  new_value VARCHAR(60) NOT NULL,
  user VARCHAR(100) NOT NULL,
  date DATETIME NOT NULL,
  PRIMARY KEY (id));
  
  ALTER TABLE audit 
ADD COLUMN id_register INT NOT NULL AFTER column_name;


ALTER TABLE user_allowed 
ADD COLUMN admin VARCHAR(1) NULL AFTER user_name_allowed;

ALTER TABLE audit 
CHANGE COLUMN old_value old_value VARCHAR(60) NULL ;

ADD UNIQUE INDEX email_UNIQUE (email ASC);
ALTER TABLE usuario_operacion 



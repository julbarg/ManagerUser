-- =============================================
-- Author:  	Julian Barragan Verano
-- Create date: 30-OCT-2015
-- Description: ADD Columns usuario_operacion
-- =============================================

ALTER TABLE `usuario_operacion` 
ADD COLUMN `cargo` VARCHAR(45) NULL AFTER `phone`,
ADD COLUMN `consulta_por_cuenta` VARCHAR(2) NULL AFTER `cargo`;
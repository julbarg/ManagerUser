package com.claro.manager.dto;

import java.io.Serializable;
import java.util.Date;


public class AuditDTO implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 8345445736349397566L;

   private String tabla;

   private String columna;

   private String registro;

   private String valorAnterior;

   private String valorNuevo;

   private String user;

   private Date fecha;

   public String getTabla() {
      return tabla;
   }

   public void setTabla(String tabla) {
      this.tabla = tabla;
   }

   public String getColumna() {
      return columna;
   }

   public void setColumna(String columna) {
      this.columna = columna;
   }

   public String getRegistro() {
      return registro;
   }

   public void setRegistro(String registro) {
      this.registro = registro;
   }

   public String getValorAnterior() {
      return valorAnterior;
   }

   public void setValorAnterior(String valorAnterior) {
      this.valorAnterior = valorAnterior;
   }

   public String getValorNuevo() {
      return valorNuevo;
   }

   public void setValorNuevo(String valorNuevo) {
      this.valorNuevo = valorNuevo;
   }

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }

   public Date getFecha() {
      return fecha;
   }

   public void setFecha(Date fecha) {
      this.fecha = fecha;
   }

   public static long getSerialversionuid() {
      return serialVersionUID;
   }

}

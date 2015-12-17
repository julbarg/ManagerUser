package com.claro.manager.dto;

import java.io.Serializable;
import java.util.Date;


public class ReporteIngresoDTO implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 3560350278501614366L;

   private String cedula;

   private String nombre;

   private String compania;

   private Date fecha;

   public String getCedula() {
      return cedula;
   }

   public void setCedula(String cedula) {
      this.cedula = cedula;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getCompania() {
      return compania;
   }

   public void setCompania(String compania) {
      this.compania = compania;
   }

   public Date getFecha() {
      return fecha;
   }

   public void setFecha(Date fecha) {
      this.fecha = fecha;
   }

}

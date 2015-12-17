package com.claro.manager.dto;

import java.io.Serializable;
import java.util.Date;


public class ReporteConsultasDTO implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 5856321852300177938L;

   private String cedula;

   private String nombre;

   private String compania;

   private String tipo;

   private Date fecha;

   private String mac;

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

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   public Date getFecha() {
      return fecha;
   }

   public void setFecha(Date fecha) {
      this.fecha = fecha;
   }

   public String getMac() {
      return mac;
   }

   public void setMac(String mac) {
      this.mac = mac;
   }

}

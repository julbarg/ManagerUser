package com.claro.manager.dto;

import java.io.Serializable;
import java.util.Date;


public class ReporteCambiosWifiDTO implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = -8834046998254987338L;

   private String cedula;

   private String nombre;

   private String compania;

   private Date fecha;

   private String mac;

   private String ssIdAnterior;

   private String keyAnterior;

   private String canalAnterior;

   private String cifradoAnterior;

   private String ssIdNuevo;

   private String keyNuevo;

   private String canalNuevo;

   private String cifradoNuevo;

   private String estado;

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

   public String getMac() {
      return mac;
   }

   public void setMac(String mac) {
      this.mac = mac;
   }

   public String getSsIdAnterior() {
      return ssIdAnterior;
   }

   public void setSsIdAnterior(String ssIdAnterior) {
      this.ssIdAnterior = ssIdAnterior;
   }

   public String getKeyAnterior() {
      return keyAnterior;
   }

   public void setKeyAnterior(String keyAnterior) {
      this.keyAnterior = keyAnterior;
   }

   public String getCanalAnterior() {
      return canalAnterior;
   }

   public void setCanalAnterior(String canalAnterior) {
      this.canalAnterior = canalAnterior;
   }

   public String getCifradoAnterior() {
      return cifradoAnterior;
   }

   public void setCifradoAnterior(String cifradoAnterior) {
      this.cifradoAnterior = cifradoAnterior;
   }

   public String getSsIdNuevo() {
      return ssIdNuevo;
   }

   public void setSsIdNuevo(String ssId_nuevo) {
      this.ssIdNuevo = ssId_nuevo;
   }

   public String getKeyNuevo() {
      return keyNuevo;
   }

   public void setKeyNuevo(String keyNuevo) {
      this.keyNuevo = keyNuevo;
   }

   public String getCanalNuevo() {
      return canalNuevo;
   }

   public void setCanalNuevo(String canalNuevo) {
      this.canalNuevo = canalNuevo;
   }

   public String getCifradoNuevo() {
      return cifradoNuevo;
   }

   public void setCifradoNuevo(String cifradoNuevo) {
      this.cifradoNuevo = cifradoNuevo;
   }

   public String getEstado() {
      return estado;
   }

   public void setEstado(String estado) {
      this.estado = estado;
   }
}

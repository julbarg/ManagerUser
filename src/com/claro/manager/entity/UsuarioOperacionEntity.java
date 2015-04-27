package com.claro.manager.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the usuario_operacion database table.
 * 
 */
@Entity
@Table(name = "usuario_operacion")
@NamedQuery(name = "UsuarioOperacionEntity.findAll", query = "SELECT u FROM UsuarioOperacionEntity u")
public class UsuarioOperacionEntity implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   private Long cedula;

   private String compania;

   private String contrasena;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "date_create")
   private Date dateCreate;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "date_update")
   private Date dateUpdate;

   private String email;

   private String estado;

   @Column(name = "estado_contrasena")
   private String estadoContrasena;

   private String nombre;

   private Long phone;

   private Long sap;

   @Column(name = "user_create")
   private String userCreate;

   @Column(name = "user_update")
   private String userUpdate;

   public UsuarioOperacionEntity() {
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Long getCedula() {
      return this.cedula;
   }

   public void setCedula(Long cedula) {
      this.cedula = cedula;
   }

   public String getCompania() {
      return this.compania;
   }

   public void setCompania(String compania) {
      this.compania = compania;
   }

   public String getContrasena() {
      return this.contrasena;
   }

   public void setContrasena(String contrasena) {
      this.contrasena = contrasena;
   }

   public Date getDateCreate() {
      return this.dateCreate;
   }

   public void setDateCreate(Date dateCreate) {
      this.dateCreate = dateCreate;
   }

   public Date getDateUpdate() {
      return this.dateUpdate;
   }

   public void setDateUpdate(Date dateUpdate) {
      this.dateUpdate = dateUpdate;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getEstado() {
      return this.estado;
   }

   public void setEstado(String estado) {
      this.estado = estado;
   }

   public String getEstadoContrasena() {
      return this.estadoContrasena;
   }

   public void setEstadoContrasena(String estadoContrasena) {
      this.estadoContrasena = estadoContrasena;
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public Long getPhone() {
      return this.phone;
   }

   public void setPhone(Long phone) {
      this.phone = phone;
   }

   public Long getSap() {
      return this.sap;
   }

   public void setSap(Long sap) {
      this.sap = sap;
   }

   public String getUserCreate() {
      return this.userCreate;
   }

   public void setUserCreate(String userCreate) {
      this.userCreate = userCreate;
   }

   public String getUserUpdate() {
      return this.userUpdate;
   }

   public void setUserUpdate(String userUpdate) {
      this.userUpdate = userUpdate;
   }

}
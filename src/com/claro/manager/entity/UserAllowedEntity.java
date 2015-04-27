package com.claro.manager.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the user_allowed database table.
 * 
 */
@Entity
@Table(name = "user_allowed")
@NamedQueries({
   @NamedQuery(name = "UserAllowedEntity.findAll", query = "SELECT u FROM UserAllowedEntity u"),
   @NamedQuery(name = "UserAllowedEntity.findUserName", query = "SELECT u FROM UserAllowedEntity u WHERE u.userNameAllowed=:userName") })
public class UserAllowedEntity implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   private String admin;

   @Temporal(TemporalType.DATE)
   @Column(name = "date_create")
   private Date dateCreate;

   @Temporal(TemporalType.DATE)
   @Column(name = "date_update")
   private Date dateUpdate;

   @Column(name = "user_create")
   private String userCreate;

   @Column(name = "user_name_allowed")
   private String userNameAllowed;

   @Column(name = "user_update")
   private String userUpdate;

   public UserAllowedEntity() {
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
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

   public String getUserCreate() {
      return this.userCreate;
   }

   public void setUserCreate(String userCreate) {
      this.userCreate = userCreate;
   }

   public String getUserNameAllowed() {
      return this.userNameAllowed;
   }

   public void setUserNameAllowed(String userNameAllowed) {
      this.userNameAllowed = userNameAllowed;
   }

   public String getUserUpdate() {
      return this.userUpdate;
   }

   public void setUserUpdate(String userUpdate) {
      this.userUpdate = userUpdate;
   }

   public String getAdmin() {
      return admin;
   }

   public void setAdmin(String admin) {
      this.admin = admin;
   }

}
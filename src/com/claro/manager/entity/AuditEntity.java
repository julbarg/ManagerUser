package com.claro.manager.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the audit database table.
 * 
 */
@Entity
@Table(name = "audit")
@NamedQueries({
   @NamedQuery(name = "AuditEntity.findAll", query = "SELECT a FROM AuditEntity a ORDER BY a.date DESC"),
   @NamedQuery(name = "AuditEntity.findByIdRegister", query = "SELECT a FROM AuditEntity a WHERE a.idRegister=:idRegister AND a.tableName=:tableName ORDER BY a.date DESC") })
public class AuditEntity implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column(name = "column_name")
   private String columnName;

   @Temporal(TemporalType.TIMESTAMP)
   private Date date;

   @Column(name = "id_register")
   private int idRegister;

   @Column(name = "new_value")
   private String newValue;

   @Column(name = "old_value")
   private String oldValue;

   @Column(name = "table_name")
   private String tableName;

   private String user;

   public AuditEntity() {
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getColumnName() {
      return this.columnName;
   }

   public void setColumnName(String columnName) {
      this.columnName = columnName;
   }

   public Date getDate() {
      return this.date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public int getIdRegister() {
      return this.idRegister;
   }

   public void setIdRegister(int idRegister) {
      this.idRegister = idRegister;
   }

   public String getNewValue() {
      return this.newValue;
   }

   public void setNewValue(String newValue) {
      this.newValue = newValue;
   }

   public String getOldValue() {
      return this.oldValue;
   }

   public void setOldValue(String oldValue) {
      this.oldValue = oldValue;
   }

   public String getTableName() {
      return this.tableName;
   }

   public void setTableName(String tableName) {
      this.tableName = tableName;
   }

   public String getUser() {
      return this.user;
   }

   public void setUser(String user) {
      this.user = user;
   }

   @Override
   public String toString() {
      String message = "Table: " + tableName + " Column: " + columnName + " Old Value: " + oldValue + " New Value: " + newValue;
      return message;
   }

}
package com.claro.manager.dto;

import java.io.Serializable;

public class FilterUserOperationsDTO implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 712503469641827745L;
   
   private String name;
   
   private Long identity;
   
   private String company;
   
   private Long SAP;
   
   private String estado;
   
   private String email;
   
   private String phone;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Long getIdentity() {
      return identity;
   }

   public void setIdentity(Long identity) {
      this.identity = identity;
   }

   public String getCompany() {
      return company;
   }

   public void setCompany(String company) {
      this.company = company;
   }

   public Long getSAP() {
      return SAP;
   }

   public void setSAP(Long sAP) {
      SAP = sAP;
   }

   public String getEstado() {
      return estado;
   }

   public void setEstado(String estado) {
      this.estado = estado;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

}

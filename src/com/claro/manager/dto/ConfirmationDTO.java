package com.claro.manager.dto;

import java.io.Serializable;


public class ConfirmationDTO implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = -149229958794856991L;

   private String name;

   private String value;

   public ConfirmationDTO(String name, String value) {
      this.name = name;
      this.value = value;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }

}

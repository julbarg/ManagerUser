package com.claro.manager.enums;

import java.util.ArrayList;


public enum StatePasswordEnum {

   PASSWORD("P", "Password"), CEDULA("C", "Cedula");

   private String value;

   private String name;

   private StatePasswordEnum(String value, String name) {
      this.value = value;
      this.name = name;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public static String getName(String value) {
      String name = "";
      switch (value) {
         case "P":
            name = StatePasswordEnum.PASSWORD.getName();
            break;
         case "C":
            name = StatePasswordEnum.CEDULA.getName();
         default:
            break;
      }
      return name;
   }

   public static ArrayList<StatePasswordEnum> getList() {
      ArrayList<StatePasswordEnum> listStatePassword = new ArrayList<StatePasswordEnum>();
      listStatePassword.add(StatePasswordEnum.PASSWORD);
      listStatePassword.add(StatePasswordEnum.CEDULA);
      return listStatePassword;
   }
}

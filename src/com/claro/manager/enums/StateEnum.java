package com.claro.manager.enums;

import java.util.ArrayList;


public enum StateEnum {

   ACTIVO("A", "Activo"), INACTIVO("I", "Inactivo");

   private String value;

   private String name;

   private StateEnum(String value, String name) {
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
         case "A":
            name = StateEnum.ACTIVO.getName();
            break;
         case "I":
            name = StateEnum.INACTIVO.getName();
         default:
            break;
      }
      return name;
   }

   public static ArrayList<StateEnum> getList() {
      ArrayList<StateEnum> listState = new ArrayList<StateEnum>();
      listState.add(StateEnum.ACTIVO);
      listState.add(StateEnum.INACTIVO);
      return listState;
   }

}

package com.claro.manager.enums;

import java.util.ArrayList;


public enum ConfirmationEnum {

   SI("S", "Si"), NO("N", "No");

   private String value;

   private String name;

   private ConfirmationEnum(String value, String name) {
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
         case "S":
            name = ConfirmationEnum.SI.getName();
            break;
         case "N":
            name = ConfirmationEnum.NO.getName();
         default:
            break;
      }
      return name;
   }

   public static ArrayList<ConfirmationEnum> getList() {
      ArrayList<ConfirmationEnum> listConfirmation = new ArrayList<ConfirmationEnum>();
      listConfirmation.add(ConfirmationEnum.NO);
      listConfirmation.add(ConfirmationEnum.SI);
      return listConfirmation;
   }

}

package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.claro.manager.entity.UsuarioOperacionEntity;


public class Test {

   public String getString(UsuarioOperacionEntity usuarioO) throws Exception {
      return getString2(usuarioO);
   }

   private String getString2(UsuarioOperacionEntity usuarioO) throws Exception {
      return getString3(usuarioO);
   }

   private String getString3(UsuarioOperacionEntity usuarioO) throws Exception {
      try {
         return usuarioO.getCedula().toString();
      } catch (Exception e) {
         throw new Exception("Hooola!!");
      }

   }

   public static void main(String[] args) {
      System.out.println("Hola \nMundo");
      UsuarioOperacionEntity usuarioOperacionEntity = new UsuarioOperacionEntity();
      Test test = new Test();
      try {
         System.out.println(test.getString(usuarioOperacionEntity));
      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }
      
      
     String error = "java.error,numberpointer: Fonr input Strign \"TEST\"";
      
      String regex = "\".*?\""; 
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(error);

      if (matcher.find()) {
         System.out.println(matcher.group());
      } else {
         
      }
      
      
      

   }

}

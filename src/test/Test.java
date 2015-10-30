package test;

import java.util.StringTokenizer;

import org.opensaml.ws.wsaddressing.To;

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

   

}

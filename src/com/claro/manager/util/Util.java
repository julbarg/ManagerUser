package com.claro.manager.util;

import java.io.IOException;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.claro.manager.entity.UserAllowedEntity;
import com.claro.manager.enums.ConfirmationEnum;


public class Util {

   public static HttpSession getSession() {
      return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
   }

   public static HttpServletRequest getRequest() {
      return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
   }

   public static String getUserName() throws Exception {
      HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
      return session.getAttribute(Constante.USER_NAME).toString();
   }

   public static boolean getAdminValidate() throws Exception {
      HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
      return (boolean) session.getAttribute(Constante.ADMIN);
   }

   public static String getUserId() {
      HttpSession session = getSession();
      if (session != null)
         return (String) session.getAttribute(Constante.USER_ID);
      else
         return null;
   }

   public static void logout() {
      HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
      session.invalidate();
   }

   public static void redirecionar(String url) throws IOException {
      FacesContext.getCurrentInstance().getExternalContext().redirect(url);
   }

   public static void addMessageInfo(String mensaje) {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null);
      FacesContext.getCurrentInstance().addMessage(null, message);
   }

   public static void addMessageInfo(String mensaje, String component) {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null);
      FacesContext.getCurrentInstance().addMessage(component, message);
   }

   public static void addMessageFatal(String mensaje) {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, mensaje, null);
      FacesContext.getCurrentInstance().addMessage(null, message);
   }

   public static void addMessageFatal(String mensaje, String component) {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, mensaje, null);
      FacesContext.getCurrentInstance().addMessage(component, message);
   }

   public static String upperCase(String value) {
      if (value != null) {
         return value.toUpperCase();
      }
      return value;
   }

   public static void iniciarSesion(UserAllowedEntity userName) {
      Util.getSession().setAttribute(Constante.USER_NAME, userName.getUserNameAllowed());
      boolean admin = ConfirmationEnum.SI.getValue().equals(userName.getAdmin());
      Util.getSession().setAttribute(Constante.ADMIN, admin);
   }

   public static long substracDatesInDays(Date dateInitial, Date dateFinal) {
      System.out.println("INITIAL: " + dateInitial);
      System.out.println("FINAL: " + dateFinal);
      long diff = Math.abs(dateFinal.getTime() - dateInitial.getTime());
      System.out.println("DIFF: " + diff);
      long diffDays = (int) (diff / (24 * 60 * 60 * 1000));
      System.out.println("DIFF DAYS: " + diffDays);

      return diffDays;

   }

}

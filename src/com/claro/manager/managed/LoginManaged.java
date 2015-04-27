package com.claro.manager.managed;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import com.claro.manager.dto.UserDTO;
import com.claro.manager.ejb.LoginRemote;
import com.claro.manager.entity.UserAllowedEntity;
import com.claro.manager.util.Constante;
import com.claro.manager.util.Messages;
import com.claro.manager.util.Util;


@ManagedBean(name = "login")
@SessionScoped
public class LoginManaged implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = -7956539444637798381L;

   private static Logger LOGGER = LogManager.getLogger(LoginManaged.class.getName());

   @EJB
   private LoginRemote loginEJB;

   private UserDTO user;

   @PostConstruct
   public void initialize() {
      user = new UserDTO();
   }

   public boolean login() {
      boolean loginIn = false;
      RequestContext context = RequestContext.getCurrentInstance();
      UserAllowedEntity userAllowed = null;
      try {
         userAllowed = loginEJB.authenticate(this.user);
         if (userAllowed != null) {
            loginIn = true;
            Util.iniciarSesion(userAllowed);
         } else {
            Util.addMessageFatal(Messages.CREDENTIAL_INVALID);
            loginIn = false;
         }
      } catch (Exception e) {
         LOGGER.error(Messages.ERROR_AUTHENTICATION, e);
         Util.addMessageFatal(Messages.ERROR_AUTHENTICATION);
         loginIn = false;
      }
      context.addCallbackParam(Constante.LOGGED_IN, loginIn);
      // test();

      return loginIn;
   }

   public void test() {
      RequestContext context = RequestContext.getCurrentInstance();
      context.addCallbackParam(Constante.LOGGED_IN, true);
      UserAllowedEntity userAllowed = new UserAllowedEntity();
      userAllowed.setUserNameAllowed("test");
      userAllowed.setAdmin("S");
      Util.iniciarSesion(userAllowed);

   }

   public void logout() {
      Util.logout();
   }

   public LoginRemote getLoginEJB() {
      return loginEJB;
   }

   public void setLoginEJB(LoginRemote loginEJB) {
      this.loginEJB = loginEJB;
   }

   public UserDTO getUser() {
      return user;
   }

   public void setUser(UserDTO user) {
      this.user = user;
   }

}

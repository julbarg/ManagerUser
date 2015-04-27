package com.claro.manager.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import co.com.claro.sisges.ldap.service.LDAPAuthenticationServices;
import co.com.claro.sisges.ldap.service.LDAPAuthenticationServicesServiceLocator;

import com.claro.manager.dao.UserAllowedDAORemote;
import com.claro.manager.dto.UserDTO;
import com.claro.manager.entity.UserAllowedEntity;


@Stateful
@LocalBean
public class LoginEJB implements LoginRemote {

   private static final String DOMAIN_NAME = "co.attla.corp";

   @EJB
   private UserAllowedDAORemote userAllowedDAO;

   @Override
   public UserAllowedEntity authenticate(UserDTO user) throws Exception {
      UserAllowedEntity userAllowed = null;
      LDAPAuthenticationServicesServiceLocator ldapL = new LDAPAuthenticationServicesServiceLocator();
      LDAPAuthenticationServices query;
      query = ldapL.getLDAPAuthenticationServices();
      userAllowed = userAllowedDAO.findByUserAllowed(user.getUserName());
      if (query.userAuthentication(user.getUserName(), user.getPassword(), DOMAIN_NAME) && userAllowed != null) {
         return userAllowed;
      }
      return null;
   }
}

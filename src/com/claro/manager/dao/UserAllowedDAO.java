package com.claro.manager.dao;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;

import com.claro.manager.entity.UserAllowedEntity;


@Stateless
@LocalBean
public class UserAllowedDAO extends AbstractDAO<UserAllowedEntity> implements UserAllowedDAORemote {

   @Override
   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public UserAllowedEntity findByUserAllowed(String userName) throws Exception {
      UserAllowedEntity userResult = null;
      TypedQuery<UserAllowedEntity> query = entityManager.createNamedQuery("UserAllowedEntity.findUserName",
         UserAllowedEntity.class);
      query.setParameter("userName", userName.toUpperCase());
      ArrayList<UserAllowedEntity> results = (ArrayList<UserAllowedEntity>) query.setMaxResults(1).getResultList();
      if (results.size() > 0) {
         userResult = results.get(0);
      }

      return userResult;

   }

   @Override
   public ArrayList<UserAllowedEntity> findAll() throws Exception {
      ArrayList<UserAllowedEntity> results = new ArrayList<UserAllowedEntity>();
      TypedQuery<UserAllowedEntity> query = entityManager.createNamedQuery("UserAllowedEntity.findAll",
         UserAllowedEntity.class);
      results = (ArrayList<UserAllowedEntity>) query.getResultList();

      return results;
   }
}

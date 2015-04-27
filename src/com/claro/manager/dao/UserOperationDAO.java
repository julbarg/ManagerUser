package com.claro.manager.dao;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.claro.manager.dto.FilterUserOperationsDTO;
import com.claro.manager.entity.UsuarioOperacionEntity;


@Stateless
@LocalBean
public class UserOperationDAO extends AbstractDAO<UsuarioOperacionEntity> implements UserOperationDAORemote {

   private static Logger LOGGER = LogManager.getLogger(UserOperationDAO.class.getName());

   @EJB
   private AuditDAORemote auditDAO;

   @Override
   public ArrayList<UsuarioOperacionEntity> findByFilter(FilterUserOperationsDTO userOperation) {

      StringBuffer comandQuery = new StringBuffer();
      comandQuery.append("SELECT u FROM UsuarioOperacionEntity u WHERE ");
      comandQuery = validateString(comandQuery, userOperation.getName(), "u.nombre LIKE '%");
      comandQuery = validateLong(comandQuery, userOperation.getIdentity(), "u.cedula = ");
      comandQuery = validateString(comandQuery, userOperation.getCompany(), "u.compania LIKE '%");
      comandQuery = validateLong(comandQuery, userOperation.getSAP(), "u.sap = ");
      comandQuery = validateString(comandQuery, userOperation.getEstado(), "u.estado LIKE '%");
      comandQuery = validateString(comandQuery, userOperation.getEmail(), "u.email LIKE '%");
      comandQuery = validateString(comandQuery, userOperation.getPhone(), "u.phone LIKE '%");

      comandQuery.append(" 1 = 1");

      TypedQuery<UsuarioOperacionEntity> query = entityManager.createQuery(comandQuery.toString(), UsuarioOperacionEntity.class);

      return (ArrayList<UsuarioOperacionEntity>) query.getResultList();

   }

   private StringBuffer validateLong(StringBuffer comandQuery, Long number, String name) {
      if (number != null && number.intValue() != 0) {
         comandQuery.append(name);
         comandQuery.append(number);
         comandQuery.append(" AND ");
      }
      return comandQuery;
   }

   private StringBuffer validateString(StringBuffer comandQuery, String value, String name) {
      if (value != null && !value.isEmpty()) {
         comandQuery.append(name);
         comandQuery.append(value);
         comandQuery.append("%' AND ");

      }
      return comandQuery;
   }

   @Override
   public void auditarEdit(UsuarioOperacionEntity userUpdate) {
      try {
         UsuarioOperacionEntity userOld = entityManager.find(UsuarioOperacionEntity.class, userUpdate.getId());
         auditDAO.auditarEdit(userOld, userUpdate);
      } catch (Exception e) {
         LOGGER.error("auditarEdit", e);
      }
   }

   @Override
   public void auditarNew(UsuarioOperacionEntity userNew) throws Exception {
      try {
         auditDAO.auditarNew(userNew);
      } catch (Exception e) {
         LOGGER.error("auditarNew", e);
      }
   }

   /**
    * Encontrar usuario por id
    */
   public UsuarioOperacionEntity findById(int id) throws Exception {
      return entityManager.find(UsuarioOperacionEntity.class, id);
   }

}

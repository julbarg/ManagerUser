package com.claro.manager.dao;

import java.io.Serializable;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class AbstractDAO<T extends Serializable> {

   private Class<T> clase;

   @PersistenceContext(unitName = "ManagerUserPU")
   EntityManager entityManager;

   public final void setClase(Class<T> entity) throws Exception {
      this.clase = entity;
   }

   public T findOne(long id) throws Exception {
      return this.entityManager.find(this.clase, id);

   }

   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public void create(T entity) throws Exception {
      this.entityManager.persist(entity);
   }

   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public T update(T entity) throws Exception {
      try {
         return this.entityManager.merge(entity);
      } catch (javax.persistence.PersistenceException e) {
         Exception e1 = new Exception(e.getMessage());
         throw e1;
      } catch (Exception e) {
         throw e;
      }
   }

   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public void delete(T entity) throws Exception {
      this.entityManager.remove(this.entityManager.contains(entity) ? entity : this.entityManager.merge(entity));
   }

   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public void deleteById(long entityId) throws Exception {
      T entity = this.findOne(entityId);
      this.delete(entity);
   }
}

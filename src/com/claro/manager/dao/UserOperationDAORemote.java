package com.claro.manager.dao;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.claro.manager.dto.FilterUserOperationsDTO;
import com.claro.manager.entity.UsuarioOperacionEntity;


@Remote
public interface UserOperationDAORemote {

   public ArrayList<UsuarioOperacionEntity> findByFilter(FilterUserOperationsDTO userOperation) throws Exception;

   public void create(UsuarioOperacionEntity userOperation) throws Exception;

   public UsuarioOperacionEntity update(UsuarioOperacionEntity userOperation) throws Exception;

   public void delete(UsuarioOperacionEntity userOperation) throws Exception;

   public UsuarioOperacionEntity findById(int id) throws Exception;

   public void auditarEdit(UsuarioOperacionEntity userUpdate) throws Exception;

   public void auditarNew(UsuarioOperacionEntity userNew) throws Exception;

}

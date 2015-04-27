package com.claro.manager.dao;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.claro.manager.dto.AuditDTO;
import com.claro.manager.entity.AuditEntity;
import com.claro.manager.entity.UsuarioOperacionEntity;


@Remote
public interface AuditDAORemote {

   public ArrayList<AuditDTO> findAll();

   public void create(AuditEntity auditEntity) throws Exception;

   public void auditarEdit(UsuarioOperacionEntity userOld, UsuarioOperacionEntity userUpdate) throws Exception;

   public ArrayList<AuditEntity> findByIdRegister(int idRegister, String tableName);

   public void auditarNew(UsuarioOperacionEntity userNew) throws Exception;

}

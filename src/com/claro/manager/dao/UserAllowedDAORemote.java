package com.claro.manager.dao;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.claro.manager.entity.UserAllowedEntity;


@Remote
public interface UserAllowedDAORemote {

   public UserAllowedEntity findByUserAllowed(String userName) throws Exception;

   public ArrayList<UserAllowedEntity> findAll() throws Exception;

   public void create(UserAllowedEntity userAllowedEntity) throws Exception;

}

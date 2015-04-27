package com.claro.manager.ejb;

import javax.ejb.Remote;

import com.claro.manager.dto.UserDTO;
import com.claro.manager.entity.UserAllowedEntity;


@Remote
public interface LoginRemote {

   public UserAllowedEntity authenticate(UserDTO usuario) throws Exception;

}

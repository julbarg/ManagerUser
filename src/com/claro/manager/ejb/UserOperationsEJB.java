package com.claro.manager.ejb;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.claro.manager.dao.AuditDAORemote;
import com.claro.manager.dao.UserAllowedDAORemote;
import com.claro.manager.dao.UserOperationDAORemote;
import com.claro.manager.dto.AuditDTO;
import com.claro.manager.dto.FilterUserOperationsDTO;
import com.claro.manager.entity.AuditEntity;
import com.claro.manager.entity.UserAllowedEntity;
import com.claro.manager.entity.UsuarioOperacionEntity;
import com.claro.manager.enums.StatePasswordEnum;
import com.claro.manager.util.Constante;
import com.claro.manager.util.Messages;
import com.claro.manager.util.Util;


@LocalBean
@Stateless
public class UserOperationsEJB implements UserOperationsEJBRemote {

   @EJB
   private UserOperationDAORemote userOperationDAO;

   @EJB
   private UserAllowedDAORemote userAllowedDAO;

   @EJB
   private AuditDAORemote auditDAO;

   @Override
   public ArrayList<UsuarioOperacionEntity> searchUser(FilterUserOperationsDTO userOperations) throws Exception {
      return userOperationDAO.findByFilter(userOperations);
   }

   @Override
   public UsuarioOperacionEntity newUser(UsuarioOperacionEntity userNew) throws Exception {
      userNew.setNombre(Util.upperCase(userNew.getNombre()));
      userNew.setCompania(Util.upperCase(userNew.getCompania()));
      userNew.setEstadoContrasena(StatePasswordEnum.CEDULA.getValue());
      userNew.setContrasena(userNew.getCedula().toString());
      userNew.setCargo(Util.upperCase(userNew.getCargo()));
      String userName = Util.getUserName();
      userNew.setUserCreate(userName);
      userNew.setDateCreate(new Date());
      userNew = userOperationDAO.update(userNew);
      userOperationDAO.auditarNew(userNew);

      return userNew;
   }

   @Override
   public UsuarioOperacionEntity editUser(UsuarioOperacionEntity selectedUser) throws Exception {
      if (selectedUser.getEstadoContrasena().equals(StatePasswordEnum.CEDULA.getValue())) {
         selectedUser.setContrasena(selectedUser.getCedula().toString());
      }
      selectedUser.setNombre(Util.upperCase(selectedUser.getNombre()));
      selectedUser.setCompania(Util.upperCase(selectedUser.getCompania()));
      String userName = Util.getUserName();
      selectedUser.setUserUpdate(userName);
      selectedUser.setDateUpdate(new Date());
      userOperationDAO.auditarEdit(selectedUser);
      selectedUser = userOperationDAO.update(selectedUser);

      return selectedUser;
   }

   @Override
   public void deleteUser(UsuarioOperacionEntity selectedUser) throws Exception {
      userOperationDAO.delete(selectedUser);
   }

   @Override
   public boolean deleteSelectUser(ArrayList<UsuarioOperacionEntity> listUserSelect) throws Exception {
      if (listUserSelect.isEmpty()) {
         Util.addMessageInfo(Messages.USER_SELECTED_DELETE_EMPTY);
         return false;
      }
      for (UsuarioOperacionEntity userDelete : listUserSelect) {
         deleteUser(userDelete);
      }
      return true;

   }

   @Override
   public void saveUserAllowed(UserAllowedEntity userAllowed) throws Exception {
      userAllowed.setUserNameAllowed(userAllowed.getUserNameAllowed().toUpperCase());
      userAllowed.setDateCreate(new Date());
      userAllowed.setUserCreate(Util.getUserName());
      userAllowedDAO.create(userAllowed);

   }

   @Override
   public ArrayList<UserAllowedEntity> searchUserAllowed() throws Exception {
      return userAllowedDAO.findAll();
   }

   @Override
   public ArrayList<AuditEntity> viewAudit(int idSelected, String usuarioOperacionTable) throws Exception {
      return auditDAO.findByIdRegister(idSelected, Constante.USUARIO_OPERACION_TABLE);
   }

   @Override
   public UsuarioOperacionEntity viewUser(int idSelected) throws Exception {
      return userOperationDAO.findById(idSelected);
   }

   @Override
   public ArrayList<AuditDTO> viewAllAudit() throws Exception {
      return auditDAO.findAll();
   }

}

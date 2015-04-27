package com.claro.manager.managed;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.claro.manager.dto.AuditDTO;
import com.claro.manager.dto.FilterUserOperationsDTO;
import com.claro.manager.ejb.ProcessFileRemote;
import com.claro.manager.ejb.UserOperationsEJBRemote;
import com.claro.manager.entity.AuditEntity;
import com.claro.manager.entity.UserAllowedEntity;
import com.claro.manager.entity.UsuarioOperacionEntity;
import com.claro.manager.enums.ConfirmationEnum;
import com.claro.manager.enums.StateEnum;
import com.claro.manager.enums.StatePasswordEnum;
import com.claro.manager.util.Constante;
import com.claro.manager.util.Messages;
import com.claro.manager.util.Util;


@ManagedBean(name = "operation")
@SessionScoped
public class UserOperationsManaged implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1113582134561843210L;

   private static Logger LOGGER = LogManager.getLogger(UserOperationsManaged.class.getName());

   @EJB
   private UserOperationsEJBRemote userOperationsEJB;

   @EJB
   private ProcessFileRemote processFile;

   private FilterUserOperationsDTO filterUserOperations;

   private ArrayList<StateEnum> listState;

   private ArrayList<StatePasswordEnum> listStatePassword;

   private ArrayList<ConfirmationEnum> listConfirmation;

   private ArrayList<UsuarioOperacionEntity> listUserOperation;

   private ArrayList<UsuarioOperacionEntity> listUserSelect;

   private UsuarioOperacionEntity userNew;

   private UsuarioOperacionEntity selectedUser;

   private UploadedFile file;

   private UserAllowedEntity userAllowed;

   private ArrayList<UserAllowedEntity> listUserAllowed;

   private ArrayList<AuditEntity> listAudit;

   private int idSelected;

   private ArrayList<AuditDTO> listAuditAll;

   @PostConstruct
   private void initialize() {
      selectedUser = new UsuarioOperacionEntity();
      filterUserOperations = new FilterUserOperationsDTO();
      userAllowed = new UserAllowedEntity();

      listUserOperation = new ArrayList<UsuarioOperacionEntity>();
      listAudit = new ArrayList<AuditEntity>();
      listAuditAll = new ArrayList<AuditDTO>();

      listState = StateEnum.getList();
      listStatePassword = StatePasswordEnum.getList();
      listConfirmation = ConfirmationEnum.getList();
      searchUserAllowed();
   }

   public boolean searchUser() {
      if (!validateSesion())
         return false;
      try {
         listUserOperation = userOperationsEJB.searchUser(filterUserOperations);
         return true;
      } catch (Exception e) {
         Util.addMessageFatal(Messages.USER_SEARCH_ERROR);
         LOGGER.error(Messages.USER_SEARCH_ERROR, e);
         return false;
      }
   }

   public void loadNew() {
      userNew = new UsuarioOperacionEntity();
   }

   public boolean newUser() {
      if (!validateSesion())
         return false;
      RequestContext context = RequestContext.getCurrentInstance();
      try {
         userNew = userOperationsEJB.newUser(userNew);
         listUserOperation.add(userNew);
         userNew = new UsuarioOperacionEntity();
         context.execute("PF('userNewDialog').hide();");
         Util.addMessageInfo(Messages.USER_CREATE);
      } catch (Exception e) {
         validarException(Messages.USER_CREATE_ERROR, e, userNew);
      }
      return true;
   }

   private void validarException(String error, Exception e, UsuarioOperacionEntity user) {
      String constraintViolationException = "org.hibernate.exception.ConstraintViolationException: ";
      String exceptionMessage = error;
      if (e.getLocalizedMessage().contains(constraintViolationException)) {
         if (e.getLocalizedMessage().contains(Messages.EMAIL_UNIQUE)) {
            exceptionMessage = error + ". \n" + Messages.EMAIL_UNIQUE_MESSAGE + (user != null ? user.getEmail() : "");
         } else if (e.getLocalizedMessage().contains(Messages.CEDULA_UNIQUE)) {
            exceptionMessage = error + ". \n" + Messages.CEDULA_UNIQUE_MESSAGE
               + (user != null ? user.getCedula().toString() : "");
         }
      }
      Util.addMessageFatal(exceptionMessage);
      LOGGER.error(error, e);
   }

   public void cargarArchivo(FileUploadEvent event) {
      try {
         file = event.getFile();
         String message = file.getFileName() + Messages.USER_FILE;
         Util.addMessageInfo(message);
      } catch (Exception e) {
         Util.addMessageFatal(Messages.USER_FILE_ERROR);
         LOGGER.error(Messages.USER_FILE_ERROR, e);
      }
   }

   public void procesarArchivo() {
      if (file != null) {
         DataInputStream entrada = null;
         try {
            entrada = new DataInputStream(file.getInputstream());
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            StringBuffer strFile = new StringBuffer();
            String lineUser;
            while ((lineUser = buffer.readLine()) != null) {
               strFile.append(lineUser);
               strFile.append("\n");
            }
            String validacionFile = processFile.validateFileMain(strFile);
            if (validacionFile.equals(Constante.OK)) {
               processFile.processFile(strFile);
               Util.addMessageInfo(Messages.PROCESS_FILE);
            } else {
               Util.addMessageFatal(validacionFile);
            }
         } catch (EJBException e1) {
            Util.addMessageFatal(Messages.PROCESS_FILE_DB);
            LOGGER.error(Messages.PROCESS_FILE_DB, e1);
         } catch (Exception e) {
            Util.addMessageFatal(e.getMessage());
            LOGGER.error(Messages.PROCESS_FILE_DB, e);
         } finally {
            try {
               entrada.close();
            } catch (IOException e) {
               LOGGER.error("entrada.close", e);
            }
         }
      }
   }

   public boolean editUser() {
      if (!validateSesion())
         return false;
      RequestContext context = RequestContext.getCurrentInstance();
      try {
         selectedUser = userOperationsEJB.editUser(selectedUser);
         context.execute("PF('userEditDialog').hide();");
         Util.addMessageInfo(Messages.USER_EDIT);
         searchUser();
      } catch (Exception e) {
         validarException(Messages.USER_EDIT_ERROR, e, selectedUser);
      }
      return true;
   }

   public boolean validateSesion() {
      try {
         Util.getUserName();
         return true;
      } catch (Exception e) {
         try {
            initialize();
            Util.redirecionar(Constante.URL_SALIR);
            Util.addMessageInfo(Messages.SESION_CLOSE);

            return false;
         } catch (Exception e1) {
            LOGGER.error(Messages.ERROR_SESSION, e1);
            return false;
         }
      }
   }

   public void saveUserAllowed() {
      try {
         userOperationsEJB.saveUserAllowed(userAllowed);
         Util.addMessageInfo(Messages.USER_CREATE);
         searchUserAllowed();
         userAllowed = new UserAllowedEntity();
      } catch (Exception e) {
         Util.addMessageFatal(Messages.USER_CREATE_ALLOWED_ERROR);
         LOGGER.error(Messages.USER_CREATE_ALLOWED_ERROR, e);
      }
   }

   public void searchUserAllowed() {
      try {
         listUserAllowed = userOperationsEJB.searchUserAllowed();
      } catch (Exception e) {
         Util.addMessageFatal(Messages.LIST_USER_ALLOWED_ERROR);
         LOGGER.error(Messages.LIST_USER_ALLOWED_ERROR, e);
      }
   }

   public void viewAudit() {
      try {
         listAudit = userOperationsEJB.viewAudit(idSelected, Constante.USUARIO_OPERACION_TABLE);
      } catch (Exception e) {
         Util.addMessageFatal(Messages.VIEW_AUDIT_ERROR);
         LOGGER.error(Messages.VIEW_AUDIT_ERROR, e);
      }
   }

   public void loadEdit() {
      try {
         selectedUser = userOperationsEJB.viewUser(idSelected);
      } catch (Exception e) {
         Util.addMessageFatal(Messages.VIEW_USER_ERROR);
         LOGGER.error(Messages.VIEW_USER_ERROR, e);
      }
   }

   public void viewAllAudit() {
      try {
         listAuditAll = userOperationsEJB.viewAllAudit();
      } catch (Exception e) {
         Util.addMessageFatal(Messages.VIEW_AUDIT_ALL_ERROR);
         LOGGER.error(Messages.VIEW_AUDIT_ALL_ERROR, e);
      }
   }

   public void postProcessXLS(Object document) {
      HSSFWorkbook wb = (HSSFWorkbook) document;
      HSSFSheet sheet = wb.getSheetAt(0);

      sheet.setColumnWidth(0, 20 * 254);
      sheet.setColumnWidth(1, 20 * 254);
      sheet.setColumnWidth(2, 20 * 254);
      sheet.setColumnWidth(3, 35 * 256);
      sheet.setColumnWidth(4, 35 * 256);
      sheet.setColumnWidth(5, 20 * 256);
      sheet.setColumnWidth(6, 20 * 256);
   }

   public void postProcessUsuarioXLS(Object document) {
      HSSFWorkbook wb = (HSSFWorkbook) document;
      HSSFSheet sheet = wb.getSheetAt(0);

      sheet.setColumnWidth(0, 30 * 254);
      sheet.setColumnWidth(1, 15 * 254);
      sheet.setColumnWidth(2, 30 * 254);
      sheet.setColumnWidth(3, 15 * 256);
      sheet.setColumnWidth(4, 20 * 256);
      sheet.setColumnWidth(5, 30 * 256);
      sheet.setColumnWidth(6, 10 * 256);
      sheet.setColumnWidth(7, 20 * 256);
   }

   public void closeSesion() {
      listUserOperation = new ArrayList<UsuarioOperacionEntity>();

   }

   public FilterUserOperationsDTO getFilterUserOperations() {
      return filterUserOperations;
   }

   public void setFilterUserOperations(FilterUserOperationsDTO userOperations) {
      this.filterUserOperations = userOperations;
   }

   public ArrayList<StateEnum> getListState() {
      return listState;
   }

   public void setListState(ArrayList<StateEnum> listState) {
      this.listState = listState;
   }

   public ArrayList<UsuarioOperacionEntity> getListUserOperation() {
      return listUserOperation;
   }

   public void setListUserOperation(ArrayList<UsuarioOperacionEntity> listUserOperation) {
      this.listUserOperation = listUserOperation;
   }

   public UsuarioOperacionEntity getUserNew() {
      return userNew;
   }

   public void setUserNew(UsuarioOperacionEntity userNew) {
      this.userNew = userNew;
   }

   public UsuarioOperacionEntity getSelectedUser() {
      return selectedUser;
   }

   public void setSelectedUser(UsuarioOperacionEntity selectedUser) {
      this.selectedUser = selectedUser;
   }

   public ArrayList<StatePasswordEnum> getListStatePassword() {
      return listStatePassword;
   }

   public void setListStatePassword(ArrayList<StatePasswordEnum> listStatePassword) {
      this.listStatePassword = listStatePassword;
   }

   public ArrayList<UsuarioOperacionEntity> getListUserSelect() {
      return listUserSelect;
   }

   public void setListUserSelect(ArrayList<UsuarioOperacionEntity> listUserSelect) {
      this.listUserSelect = listUserSelect;
   }

   public UploadedFile getFile() {
      return file;
   }

   public void setFile(UploadedFile file) {
      this.file = file;
   }

   public UserAllowedEntity getUserAllowed() {
      return userAllowed;
   }

   public void setUserAllowed(UserAllowedEntity userAllowed) {
      this.userAllowed = userAllowed;
   }

   public ArrayList<UserAllowedEntity> getListUserAllowed() {
      return listUserAllowed;
   }

   public void setListUserAllowed(ArrayList<UserAllowedEntity> listUserAllowed) {
      this.listUserAllowed = listUserAllowed;
   }

   public ArrayList<AuditEntity> getListAudit() {
      return listAudit;
   }

   public void setListAudit(ArrayList<AuditEntity> listAudit) {
      this.listAudit = listAudit;
   }

   public int getIdSelected() {
      return idSelected;
   }

   public void setIdSelected(int idSelected) {
      this.idSelected = idSelected;
   }

   public ArrayList<ConfirmationEnum> getListConfirmation() {
      return listConfirmation;
   }

   public void setListConfirmation(ArrayList<ConfirmationEnum> listConfirmation) {
      this.listConfirmation = listConfirmation;
   }

   public boolean isAdmin() {
      try {
         return Util.getAdminValidate();
      } catch (Exception e) {
         LOGGER.error("Erro obteniendo validación de Usuario Administrador");
         return false;
      }
   }

   public ArrayList<AuditDTO> getListAuditAll() {
      return listAuditAll;
   }

   public void setListAuditAll(ArrayList<AuditDTO> listAuditAll) {
      this.listAuditAll = listAuditAll;
   }

   public String getToday() {
      String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
      return today;
   }
}
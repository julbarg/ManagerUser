package com.claro.manager.ejb;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Remote;

import com.claro.manager.dto.AuditDTO;
import com.claro.manager.dto.FilterUserOperationsDTO;
import com.claro.manager.dto.ReporteCambiosWifiDTO;
import com.claro.manager.dto.ReporteConsultasDTO;
import com.claro.manager.dto.ReporteIngresoDTO;
import com.claro.manager.entity.AuditEntity;
import com.claro.manager.entity.UserAllowedEntity;
import com.claro.manager.entity.UsuarioOperacionEntity;


@Remote
public interface UserOperationsEJBRemote {

   public ArrayList<UsuarioOperacionEntity> searchUser(FilterUserOperationsDTO userOperations) throws Exception;

   public UsuarioOperacionEntity newUser(UsuarioOperacionEntity userNew) throws Exception;

   public UsuarioOperacionEntity editUser(UsuarioOperacionEntity selectedUser) throws Exception;

   public void deleteUser(UsuarioOperacionEntity selectedUser) throws Exception;

   public boolean deleteSelectUser(ArrayList<UsuarioOperacionEntity> listUserSelect) throws Exception;

   public void saveUserAllowed(UserAllowedEntity userAllowed) throws Exception;

   public ArrayList<UserAllowedEntity> searchUserAllowed() throws Exception;

   public ArrayList<AuditEntity> viewAudit(int idSelected, String usuarioOperacionTable) throws Exception;

   public UsuarioOperacionEntity viewUser(int idSelected) throws Exception;

   public ArrayList<AuditDTO> viewAllAudit() throws Exception;

   public ArrayList<ReporteIngresoDTO> searchReporteIngresoByDate(Date dateInitial, Date dateFinal) throws Exception;

   public ArrayList<ReporteConsultasDTO> searchReporteConsultasByDate(Date dateInitial, Date dateFinal) throws Exception;

   public ArrayList<ReporteCambiosWifiDTO> searchReporteCambiosWifiByDate(Date dateInitial, Date dateFinal) throws Exception;

}

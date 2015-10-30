package com.claro.manager.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.claro.manager.dto.AuditDTO;
import com.claro.manager.entity.AuditEntity;
import com.claro.manager.entity.UsuarioOperacionEntity;
import com.claro.manager.util.Constante;
import com.claro.manager.util.Util;


@Stateless
@LocalBean
public class AuditDAO extends AbstractDAO<AuditEntity> implements AuditDAORemote {

   private static Logger LOGGER = LogManager.getLogger(AuditDAO.class.getName());

   @EJB
   private UserOperationDAORemote userOperationDAO;

   @Override
   public void auditarNew(UsuarioOperacionEntity userNew) throws Exception {

      saveAudit(userNew, "cedula", userNew.getCedula());
      saveAudit(userNew, "nombre", userNew.getNombre());
      saveAudit(userNew, "compania", userNew.getCompania());
      saveAudit(userNew, "sap", userNew.getSap());
      saveAudit(userNew, "email", userNew.getEmail());
      saveAudit(userNew, "phone", userNew.getPhone());
      saveAudit(userNew, "estado", userNew.getEstado());
      saveAudit(userNew, "estado_contrasena", userNew.getEstadoContrasena());
      saveAudit(userNew, "cargo", userNew.getCargo());
      saveAudit(userNew, "consulta_por_cuenta", userNew.getConsultaPorCuenta());

   }

   private void saveAudit(UsuarioOperacionEntity user, String columnName, Object newValue) throws Exception {
      AuditEntity audit = new AuditEntity();
      audit.setTableName(Constante.USUARIO_OPERACION_TABLE);
      audit.setColumnName(columnName);
      audit.setIdRegister(user.getId());
      audit.setNewValue(setValue(newValue));
      audit.setUser(Util.getUserName());
      audit.setDate(new Date());

      create(audit);

   }

   @Override
   public void auditarEdit(UsuarioOperacionEntity userOld, UsuarioOperacionEntity userUpdate) throws Exception {

      createAuditTemplate(userOld, "cedula", userOld.getCedula(), userUpdate.getCedula());

      createAuditTemplate(userOld, "nombre", userOld.getNombre(), userUpdate.getNombre());

      createAuditTemplate(userOld, "compania", userOld.getCompania(), userUpdate.getCompania());

      createAuditTemplate(userOld, "sap", userOld.getSap().toString(), userUpdate.getSap().toString());

      createAuditTemplate(userOld, "email", userOld.getEmail(), userUpdate.getEmail());

      createAuditTemplate(userOld, "phone", userOld.getPhone().toString(), userUpdate.getPhone().toString());

      createAuditTemplate(userOld, "estado", userOld.getEstado(), userUpdate.getEstado());

      createAuditTemplate(userOld, "estado_contrasena", userOld.getEstadoContrasena(), userUpdate.getEstadoContrasena());

      createAuditTemplate(userOld, "cargo", userOld.getCargo(), userUpdate.getCargo());

      createAuditTemplate(userOld, "consulta_por_cuenta", userOld.getConsultaPorCuenta(), userUpdate.getConsultaPorCuenta());

   }

   private void createAuditTemplate(UsuarioOperacionEntity user, String columnName, Object oldValue, Object newValue) throws Exception {
      if (isDiferent(oldValue, newValue)) {
         AuditEntity audit = new AuditEntity();
         audit.setTableName(Constante.USUARIO_OPERACION_TABLE);
         audit.setColumnName(columnName);
         audit.setIdRegister(user.getId());
         audit.setOldValue(setValue(oldValue));
         audit.setNewValue(setValue(newValue));
         audit.setUser(Util.getUserName());
         audit.setDate(new Date());

         create(audit);
      }
   }

   private boolean isDiferent(Object oldValue, Object newValue) {
      if (oldValue == null && newValue == null) {
         return false;
      }
      return (oldValue == null && newValue != null) || (oldValue != null && newValue == null) || (!oldValue.equals(newValue));
   }

   private String setValue(Object value) {
      return value != null ? value.toString() : "";
   }

   private String setValueBigInt(Object value) {
      String result = "";
      try {
         result = ((BigInteger) value).toString();
      } catch (Exception e) {
         LOGGER.error("Error setValueBigInt" + e.getMessage());
      }
      return result;
   }

   private Date setValueDate(Object value) {
      try {
         Date date = (Date) value;
         return date;
      } catch (Exception e) {
         LOGGER.error("setValueDate", e);
      }
      return null;
   }

   @Override
   public ArrayList<AuditEntity> findByIdRegister(int idRegister, String tableName) {
      ArrayList<AuditEntity> results = new ArrayList<AuditEntity>();
      try {
         TypedQuery<AuditEntity> query = entityManager.createNamedQuery("AuditEntity.findByIdRegister", AuditEntity.class);
         query.setParameter("idRegister", idRegister);
         query.setParameter("tableName", tableName);
         results = (ArrayList<AuditEntity>) query.getResultList();
      } catch (Exception e) {
         LOGGER.error("findByIdRegister", e);
         return results;
      }
      return results;
   }

   @SuppressWarnings("unchecked")
   @Override
   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public ArrayList<AuditDTO> findAll() {
      ArrayList<AuditDTO> results = new ArrayList<AuditDTO>();
      try {
         StringBuffer nativeQuery = getQueryFindAll();
         Query query = entityManager.createNativeQuery(nativeQuery.toString());
         List<Object[]> listResults = query.getResultList();
         for (Object[] object : listResults) {
            AuditDTO auditDTO = createAudit(object);
            results.add(auditDTO);
         }
      } catch (Exception e) {
         LOGGER.error("findAll", e);
         return results;
      }
      return results;
   }

   private StringBuffer getQueryFindAll() {
      StringBuffer query = new StringBuffer();
      query.append("SELECT a.table_name, a.column_name, u.cedula, ");
      query.append("a.old_value,a.new_value, a.user, a.date ");
      query.append("FROM audit a ");
      query.append("LEFT JOIN usuario_operacion u ON a.id_register = u.id ");
      query.append("ORDER BY a.date DESC ");

      return query;

   }

   private AuditDTO createAudit(Object[] object) {
      AuditDTO auditDTO = new AuditDTO();
      auditDTO.setTabla(setValue(object[0]));
      auditDTO.setColumna(setValue(object[1]));
      auditDTO.setRegistro(setValueBigInt(object[2]));
      auditDTO.setValorAnterior(setValue(object[3]));
      auditDTO.setValorNuevo(setValue(object[4]));
      auditDTO.setUser(setValue(object[5]));
      auditDTO.setFecha(setValueDate(object[6]));

      return auditDTO;
   }
}

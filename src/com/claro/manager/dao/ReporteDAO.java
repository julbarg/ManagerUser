package com.claro.manager.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.claro.manager.dto.ReporteCambiosWifiDTO;
import com.claro.manager.dto.ReporteConsultasDTO;
import com.claro.manager.dto.ReporteIngresoDTO;
import com.claro.manager.entity.AuditEntity;


@Stateless
@LocalBean
public class ReporteDAO extends AbstractDAO<AuditEntity> implements ReportesDAORemote {

   private static Logger LOGGER = LogManager.getLogger(ReporteDAO.class.getName());

   @SuppressWarnings("unchecked")
   @Override
   public ArrayList<ReporteIngresoDTO> searchReporteIngresoByDate(Date dateInitial, Date dateFinal) throws Exception {

      ArrayList<ReporteIngresoDTO> results = new ArrayList<ReporteIngresoDTO>();
      try {
         StringBuffer sql = getSQLIngreso();
         Query query = entityManager.createNativeQuery(sql.toString());
         query = setDates(query, dateInitial, dateFinal);
         List<Object[]> listResults = query.getResultList();
         for (Object[] object : listResults) {
            ReporteIngresoDTO reporteIngresoDTO = createDataIngreso(object);
            results.add(reporteIngresoDTO);
         }
      } catch (Exception e) {
         LOGGER.info("Ha ocurrido un error al intentar consultar el reporte de ingresos" + e);
         throw e;
      } finally {

      }

      return results;

   }

   @SuppressWarnings("unchecked")
   @Override
   public ArrayList<ReporteConsultasDTO> searchReporteConsultasByDate(Date dateInitial, Date dateFinal) throws Exception {
      ArrayList<ReporteConsultasDTO> results = new ArrayList<ReporteConsultasDTO>();
      try {
         StringBuffer sql = getSQLConsultas();
         Query query = entityManager.createNativeQuery(sql.toString());
         query = setDates(query, dateInitial, dateFinal);
         List<Object[]> listResults = query.getResultList();
         for (Object[] object : listResults) {
            ReporteConsultasDTO reporteConsultasDTO = createDataConsultas(object);
            results.add(reporteConsultasDTO);
         }
      } catch (Exception e) {
         LOGGER.info("Ha ocurrido un error al intentar consultar el reporte de ingresos" + e);
         throw e;
      } finally {

      }

      return results;
   }

   @SuppressWarnings("unchecked")
   @Override
   public ArrayList<ReporteCambiosWifiDTO> searchReporteCambiosWifiByDate(Date dateInitial, Date dateFinal) throws Exception {
      ArrayList<ReporteCambiosWifiDTO> results = new ArrayList<ReporteCambiosWifiDTO>();
      try {
         StringBuffer sql = getSQLCambiosWifi();
         Query query = entityManager.createNativeQuery(sql.toString());
         String operaciones = "operaciones";
         query.setParameter("origen", operaciones);
         query = setDates(query, dateInitial, dateFinal);
         List<Object[]> listResults = query.getResultList();
         for (Object[] object : listResults) {
            ReporteCambiosWifiDTO reporteCambiosWifiDTO = createDataCambioWifi(object);
            results.add(reporteCambiosWifiDTO);
         }
      } catch (Exception e) {
         LOGGER.info("Ha ocurrido un error al intentar consultar el reporte de ingresos" + e);
         throw e;
      } finally {

      }

      return results;
   }

   private StringBuffer getSQLIngreso() {
      StringBuffer sql = new StringBuffer();

      sql.append("select ");

      sql.append("u.cedula, ");
      sql.append("u.nombre, ");
      sql.append("u.compania, ");
      sql.append("a.fecha ");

      sql.append("from usuario_operacion u ");
      sql.append("inner join auditoria a on u.cedula = a.usuario ");

      sql.append("where a.fecha between :dateinitial and :datefinal ");


      LOGGER.info("SQL REPORTE INGRESOS: " + sql.toString());
      return sql;

   }

   private StringBuffer getSQLConsultas() {
      StringBuffer sql = new StringBuffer();

      sql.append("select ");

      sql.append("u.cedula, ");
      sql.append("u.nombre, ");
      sql.append("u.compania, ");
      sql.append("c.tipo, ");
      sql.append("c.fecha, ");
      sql.append("c.mac ");

      sql.append("from usuario_operacion u ");
      sql.append("inner join consulta c on u.cedula = c.usuario ");

      sql.append("where c.fecha between :dateinitial and :datefinal ");


      LOGGER.info("SQL REPORTE CONSULTAS: " + sql.toString());
      return sql;

   }

   private StringBuffer getSQLCambiosWifi() {
      StringBuffer sql = new StringBuffer();

      sql.append("select ");

      sql.append("u.cedula, ");
      sql.append("u.nombre, ");
      sql.append("u.compania, ");
      sql.append("cw.fecha, ");
      sql.append("cw.mac, ");
      sql.append("cw.ssid_anterior, ");
      sql.append("cw.key_anterior, ");
      sql.append("cw.canal_anterior, ");
      sql.append("cw.cifrado_anterior, ");
      sql.append("cw.ssid_nuevo, ");
      sql.append("cw.key_nuevo, ");
      sql.append("cw.canal_nuevo, ");
      sql.append("cw.cifrado_nuevo, ");
      sql.append("cw.estado ");

      sql.append("from usuario_operacion u ");
      sql.append("inner join diagnosticador.cambioswifi cw on (u.cedula = cw.usuario) ");

      sql.append("where cw.fecha between :dateinitial and :datefinal ");
      sql.append(" and origen = :origen ");


      LOGGER.info("SQL REPORTE CAMBIOS WIFI: " + sql.toString());
      return sql;

   }

   private ReporteIngresoDTO createDataIngreso(Object[] object) {
      int numCol = 0;

      ReporteIngresoDTO reporteIngresoDTO = new ReporteIngresoDTO();
      reporteIngresoDTO.setCedula(getValue(object[numCol]));
      reporteIngresoDTO.setNombre(getValue(object[++numCol]));
      reporteIngresoDTO.setCompania(getValue(object[++numCol]));
      reporteIngresoDTO.setFecha(getDate(object[++numCol]));

      return reporteIngresoDTO;
   }

   private ReporteConsultasDTO createDataConsultas(Object[] object) {
      int numCol = 0;

      ReporteConsultasDTO reporteConsultasDTO = new ReporteConsultasDTO();
      reporteConsultasDTO.setCedula(getValue(object[numCol]));
      reporteConsultasDTO.setNombre(getValue(object[++numCol]));
      reporteConsultasDTO.setCompania(getValue(object[++numCol]));
      reporteConsultasDTO.setTipo(getValue(object[++numCol]));
      reporteConsultasDTO.setFecha(getDate(object[++numCol]));
      reporteConsultasDTO.setMac(getValue(object[++numCol]));

      return reporteConsultasDTO;
   }

   private ReporteCambiosWifiDTO createDataCambioWifi(Object[] object) {
      int numCol = 0;

      ReporteCambiosWifiDTO reporteCambiosWifiDTO = new ReporteCambiosWifiDTO();
      reporteCambiosWifiDTO.setCedula(getValue(object[numCol]));
      reporteCambiosWifiDTO.setNombre(getValue(object[++numCol]));
      reporteCambiosWifiDTO.setCompania(getValue(object[++numCol]));
      reporteCambiosWifiDTO.setFecha(getDate(object[++numCol]));
      reporteCambiosWifiDTO.setSsIdAnterior(getValue(object[++numCol]));
      reporteCambiosWifiDTO.setKeyAnterior(getValue(object[++numCol]));
      reporteCambiosWifiDTO.setCanalAnterior(getValue(object[++numCol]));
      reporteCambiosWifiDTO.setCifradoAnterior(getValue(object[++numCol]));
      reporteCambiosWifiDTO.setSsIdNuevo(getValue(object[++numCol]));
      reporteCambiosWifiDTO.setKeyNuevo(getValue(object[++numCol]));
      reporteCambiosWifiDTO.setCanalNuevo(getValue(object[++numCol]));
      reporteCambiosWifiDTO.setCifradoNuevo(getValue(object[++numCol]));
      reporteCambiosWifiDTO.setEstado(getValue(object[++numCol]));

      return reporteCambiosWifiDTO;
   }

   private Query setDates(Query query, Date dateInitial, Date dateFinal) {
      if (dateInitial != null) {
         query.setParameter("dateinitial", dateInitial);
      }
      if (dateFinal != null) {
         query.setParameter("datefinal", dateFinal);
      }

      return query;
   }

   private String getValue(Object value) {
      return value != null ? value.toString() : "";
   }

   private Date getDate(Object value) {
      try {
         Date date = (Date) value;
         return date;
      } catch (Exception e) {
         return null;
      }
   }

}

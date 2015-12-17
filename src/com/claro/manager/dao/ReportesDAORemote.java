package com.claro.manager.dao;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Remote;

import com.claro.manager.dto.ReporteCambiosWifiDTO;
import com.claro.manager.dto.ReporteConsultasDTO;
import com.claro.manager.dto.ReporteIngresoDTO;


@Remote
public interface ReportesDAORemote {

   public ArrayList<ReporteIngresoDTO> searchReporteIngresoByDate(Date dateInitial, Date dateFinal) throws Exception;

   public ArrayList<ReporteConsultasDTO> searchReporteConsultasByDate(Date dateInitial, Date dateFinal) throws Exception;

   public ArrayList<ReporteCambiosWifiDTO> searchReporteCambiosWifiByDate(Date dateInitial, Date dateFinal) throws Exception;
}

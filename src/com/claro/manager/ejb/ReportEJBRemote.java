package com.claro.manager.ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.claro.manager.dto.ReporteCambiosWifiDTO;
import com.claro.manager.dto.ReporteConsultasDTO;
import com.claro.manager.dto.ReporteIngresoDTO;


@Remote
public interface ReportEJBRemote {

   public void generateReport(ArrayList<ReporteIngresoDTO> listReporteIngreso, ArrayList<ReporteConsultasDTO> listReporteConsultasDTO,
      ArrayList<ReporteCambiosWifiDTO> listReporteCambiosWifi) throws Exception;

}

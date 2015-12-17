package com.claro.manager.ejb;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.claro.manager.dto.ReporteCambiosWifiDTO;
import com.claro.manager.dto.ReporteConsultasDTO;
import com.claro.manager.dto.ReporteIngresoDTO;
import com.claro.manager.util.Constante;


@Stateless
@LocalBean
public class ReportEJB implements ReportEJBRemote {

   private CellStyle cellStyleDate;

   private CreationHelper createHelper;

   @SuppressWarnings("resource")
   @Override
   public void generateReport(ArrayList<ReporteIngresoDTO> listReporteIngreso, ArrayList<ReporteConsultasDTO> listReporteConsultasDTO,
      ArrayList<ReporteCambiosWifiDTO> listReporteCambiosWifi) throws Exception {

      String excelFileName = Constante.URL_REPORT;

      XSSFWorkbook workBook = new XSSFWorkbook();
      cellStyleDate = workBook.createCellStyle();
      createHelper = workBook.getCreationHelper();
      workBook = getIngresos(workBook, listReporteIngreso);
      workBook = getConsultas(workBook, listReporteConsultasDTO);
      workBook = getCambiosWifi(workBook, listReporteCambiosWifi);

      FileOutputStream fileReport = new FileOutputStream(excelFileName);
      workBook.write(fileReport);
      workBook.close();
      fileReport.flush();
      fileReport.close();

   }

   private XSSFWorkbook getIngresos(XSSFWorkbook workBook, ArrayList<ReporteIngresoDTO> listReporteIngreso) {
      if (listReporteIngreso == null || listReporteIngreso.size() == 0) {
         return workBook;
      }
      ArrayList<String> listTitle = getTitlesIngreso();
      XSSFSheet sheetIngresos = workBook.createSheet("INGRESOS");

      int rowNum = sheetIngresos.getLastRowNum();
      Row row = sheetIngresos.createRow(rowNum++);
      int cellNum = 0;
      for (String title : listTitle) {
         Cell cell = row.createCell(cellNum++);
         cell.setCellValue(title);
      }

      for (ReporteIngresoDTO data : listReporteIngreso) {
         row = sheetIngresos.createRow(rowNum++);
         row = getCellIngresos(row, data);
      }

      sheetIngresos = adjustWidthColumns(sheetIngresos);

      return workBook;
   }

   private XSSFWorkbook getConsultas(XSSFWorkbook workBook, ArrayList<ReporteConsultasDTO> listReporteConsultasDTO) {
      if (listReporteConsultasDTO == null || listReporteConsultasDTO.size() == 0) {
         return workBook;
      }
      ArrayList<String> listTitle = getTitlesConsultas();
      XSSFSheet sheetIngresos = workBook.createSheet("CONSULTAS");

      int rowNum = sheetIngresos.getLastRowNum();
      Row row = sheetIngresos.createRow(rowNum++);
      int cellNum = 0;
      for (String title : listTitle) {
         Cell cell = row.createCell(cellNum++);
         cell.setCellValue(title);
      }

      for (ReporteConsultasDTO data : listReporteConsultasDTO) {
         row = sheetIngresos.createRow(rowNum++);
         row = getCellConsultas(row, data);
      }

      sheetIngresos = adjustWidthColumns(sheetIngresos);

      return workBook;
   }

   private XSSFWorkbook getCambiosWifi(XSSFWorkbook workBook, ArrayList<ReporteCambiosWifiDTO> listReporteCambiosWifi) {
      if (listReporteCambiosWifi == null || listReporteCambiosWifi.size() == 0) {
         return workBook;
      }
      ArrayList<String> listTitle = getTitlesCambiosWifi();
      XSSFSheet sheetIngresos = workBook.createSheet("CAMBIOS WIFI");

      int rowNum = sheetIngresos.getLastRowNum();
      Row row = sheetIngresos.createRow(rowNum++);
      int cellNum = 0;
      for (String title : listTitle) {
         Cell cell = row.createCell(cellNum++);
         cell.setCellValue(title);
      }

      for (ReporteCambiosWifiDTO data : listReporteCambiosWifi) {
         row = sheetIngresos.createRow(rowNum++);
         row = getCellCambiosWifi(row, data);
      }

      sheetIngresos = adjustWidthColumns(sheetIngresos);

      return workBook;
   }

   private ArrayList<String> getTitlesIngreso() {

      ArrayList<String> listTitlesIngreso = new ArrayList<String>();
      listTitlesIngreso.add("CEDULA");
      listTitlesIngreso.add("NOMBRE");
      listTitlesIngreso.add("COMPAÑIA");
      listTitlesIngreso.add("FECHA");

      return listTitlesIngreso;
   }

   private ArrayList<String> getTitlesConsultas() {
      ArrayList<String> listTitlesIngreso = new ArrayList<String>();

      listTitlesIngreso.add("CEDULA");
      listTitlesIngreso.add("NOMBRE");
      listTitlesIngreso.add("COMPAÑIA");
      listTitlesIngreso.add("TIPO");
      listTitlesIngreso.add("FECHA");
      listTitlesIngreso.add("MAC");
      return listTitlesIngreso;
   }

   private ArrayList<String> getTitlesCambiosWifi() {
      ArrayList<String> listTitlesIngreso = new ArrayList<String>();

      listTitlesIngreso.add("CEDULA");
      listTitlesIngreso.add("NOMBRE");
      listTitlesIngreso.add("COMPAÑIA");
      listTitlesIngreso.add("FECHA");
      listTitlesIngreso.add("MAC");
      listTitlesIngreso.add("SSID ANTERIOR");
      listTitlesIngreso.add("KEY ANTERIOR");
      listTitlesIngreso.add("CANAL ANTERIOR");
      listTitlesIngreso.add("CIFRADO ANTERIOR");
      listTitlesIngreso.add("SSID NUEVO");
      listTitlesIngreso.add("KEY NUEVO");
      listTitlesIngreso.add("CANAL NUEVO");
      listTitlesIngreso.add("CIFRADO NUEVO");
      listTitlesIngreso.add("ESTADO");
      return listTitlesIngreso;
   }

   private Row getCellIngresos(Row row, ReporteIngresoDTO data) {
      int cellNum = 0;
      Cell cell;

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getCedula());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getNombre());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getCompania());

      cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getFecha());
      cell.setCellStyle(cellStyleDate);

      return row;

   }

   private Row getCellConsultas(Row row, ReporteConsultasDTO data) {
      int cellNum = 0;
      Cell cell;

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getCedula());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getNombre());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getCompania());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getTipo());

      cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getFecha());
      cell.setCellStyle(cellStyleDate);

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getMac());

      return row;

   }

   private Row getCellCambiosWifi(Row row, ReporteCambiosWifiDTO data) {
      int cellNum = 0;
      Cell cell;

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getCedula());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getNombre());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getCompania());

      cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getFecha());
      cell.setCellStyle(cellStyleDate);

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getMac());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getSsIdAnterior());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getKeyAnterior());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getCanalAnterior());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getCifradoAnterior());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getSsIdNuevo());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getKeyNuevo());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getCanalNuevo());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getCifradoNuevo());

      cell = row.createCell(cellNum++);
      cell.setCellValue(data.getEstado());

      return row;

   }

   private XSSFSheet adjustWidthColumns(XSSFSheet sheet) {
      short numColumns = sheet.getRow(0).getLastCellNum();
      for (int i = 0; i < numColumns; i++) {
         sheet.autoSizeColumn(i);
      }

      return sheet;
   }

}

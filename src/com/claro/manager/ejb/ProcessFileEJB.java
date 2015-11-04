package com.claro.manager.ejb;

import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.claro.manager.dao.UserOperationDAORemote;
import com.claro.manager.entity.UsuarioOperacionEntity;
import com.claro.manager.enums.StateEnum;
import com.claro.manager.enums.StatePasswordEnum;
import com.claro.manager.util.Constante;
import com.claro.manager.util.Messages;
import com.claro.manager.util.Util;


@Stateless
@LocalBean
public class ProcessFileEJB implements ProcessFileRemote {

   private static Logger LOGGER = LogManager.getLogger(ProcessFileEJB.class.getName());

   private static final String ERROR_LINE = "Error de formato en la linea: ";

   @EJB
   private UserOperationDAORemote userOperationDAO;

   @Override
   public String validateFileMain(StringBuffer strFile) throws Exception {

      StringTokenizer tokenMain = new StringTokenizer(strFile.toString(), "\n");
      int i = 1;
      while (tokenMain.hasMoreTokens()) {
         String lineMain = (String) tokenMain.nextToken();
         String validateLine = processLineValidate(lineMain);
         if (!validateLine.equals(Constante.OK)) {
            return ERROR_LINE + i + " " + validateLine;
         }
         i++;
      }
      return Constante.OK;
   }

   @Override
   public boolean processFile(StringBuffer strFile) throws Exception {
      StringTokenizer tokenMain = new StringTokenizer(strFile.toString(), "\n");
      String lineMain = null;
      int i = 1;
      try {
         while (tokenMain.hasMoreTokens()) {
            lineMain = (String) tokenMain.nextToken();
            processLine(lineMain);
            i++;
         }
         return true;
      } catch (Exception e) {
         if (lineMain.length() > 15) {
            lineMain = lineMain.substring(0, 15) + "...";
         }
         String exceptionMessage = "Error en Linea " + i + ": " + lineMain + ". ";
         if (e.getMessage().contains(Messages.EMAIL_UNIQUE)) {
            exceptionMessage = exceptionMessage + Messages.EMAIL_UNIQUE_MESSAGE;
         } else if (e.getMessage().contains(Messages.CEDULA_UNIQUE)) {
            exceptionMessage = exceptionMessage + Messages.CEDULA_UNIQUE_MESSAGE;
         }
         throw new Exception(exceptionMessage);
      }

   }

   private void processLine(String lineUser) throws Exception {
      if (lineUser.length() > 0) {

         StringTokenizer token = new StringTokenizer(lineUser, ",");
         UsuarioOperacionEntity user = new UsuarioOperacionEntity();

         String nombre = (String) token.nextElement();
         nombre = nombre.toUpperCase();
         user.setNombre(nombre);

         String cedula = (String) token.nextElement();
         Long cedulaL = Long.parseLong(cedula.trim());
         user.setCedula(cedulaL);

         String SAP = (String) token.nextElement();
         Long SAPL = Long.parseLong(SAP.trim());
         user.setSap(SAPL);

         String compania = (String) token.nextElement();
         compania = compania.toUpperCase();
         user.setCompania(compania);
         user.setEmail((String) token.nextElement());

         String phone = (String) token.nextElement();
         Long phoneL = Long.parseLong(phone.trim());
         user.setPhone(phoneL);

         String cargo = (String) token.nextElement();
         cargo = cargo.toUpperCase();
         user.setCargo(cargo);

         String consultaPorCuenta = (String) token.nextElement();
         consultaPorCuenta = consultaPorCuenta.toUpperCase();
         user.setConsultaPorCuenta(consultaPorCuenta);

         user.setContrasena(cedula);
         user.setEstado(StateEnum.ACTIVO.getValue());
         user.setEstadoContrasena(StatePasswordEnum.CEDULA.getValue());

         String userName = Util.getUserName();
         user.setUserCreate(userName);
         user.setDateCreate(new Date());
         user = userOperationDAO.update(user);
         userOperationDAO.auditarNew(user);
      }

   }

   private String processLineValidate(String lineUser) {
      try {
         if (lineUser.length() > 0) {
            StringTokenizer token = new StringTokenizer(lineUser, ",");
            token.nextElement();
            String cedula = (String) token.nextElement();
            Long.parseLong(cedula.trim());
            String SAP = (String) token.nextElement();
            Long.parseLong(SAP.trim());
            token.nextElement();
            token.nextElement();
            String phone = (String) token.nextElement();
            Long.parseLong(phone.trim());
            token.nextElement();
            String consultaPorCuenta = (String) token.nextElement();
            if (consultaPorCuenta.length() > 1) {
               return "Error de Longitud Consulta por Cuenta (S/N)";
            }
            consultaPorCuenta = consultaPorCuenta.toUpperCase();
            if (!(Constante.SI.equals(consultaPorCuenta) || Constante.NO.equals(consultaPorCuenta))) {
               return "Consulta por Cuenta debe ser S ó N";
            }

         }
         return Constante.OK;
      } catch (Exception e) {
         LOGGER.error("processLineValidate", e);
         try {
            String regex = "\".*?\"";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(e.getMessage());
            if (matcher.find()) {
               return matcher.group();
            } else {
               return "";
            }
         } catch (Exception e1) {
            return "";
         }
      }

   }
}

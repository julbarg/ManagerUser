package com.claro.manager.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Constante {

   private static Logger LOGGER = LogManager.getLogger(Constante.class.getName());

   public static final String PATH_CONFIG_PROPERTIES = "/usr/share/tomee/webapps/ManagerUser/resources/config/report.properties";

   // public static final String PATH_CONFIG_PROPERTIES =
   // "C:/Apache Tomee/wtpwebapps/ManagerUser/resources/config/report.properties";

   public static final String PATH_REPORT = "/usr/share/tomee/webapps/ManagerUser/resources/Report.xlsx";

   public static final String LOGGED_IN = "loggedIn";

   public static final String USER_NAME = "userName";

   public static final String USER_ID = "userID";

   public static final String URL_SALIR = "/ManagerUser/";

   public static final String USUARIO_OPERACION_TABLE = "usuario_operacion";

   public static final String ADMIN = "admin";

   public static final String OK = "OK";

   public static final String SI = "S";

   public static final String NO = "N";

   public static final String URL_REPORT = getProperties("url_report");

   public static final int MAX_DAYS_FOR_REPORT = getPropertiesInt("max_days_for_report");

   /**
    * Obtener propertie
    * @param propertie
    * @return Propertie
    */
   public static String getProperties(String propertie) {

      final Properties prop = new Properties();
      InputStream input = null;
      try {

         input = new FileInputStream(PATH_CONFIG_PROPERTIES);
         prop.load(input);
         return prop.getProperty(propertie);
      } catch (final IOException ex) {
         LOGGER.error("Error getProperties", ex);
         return propertie;
      } finally {
         if (input != null) {
            try {
               input.close();
            } catch (final IOException e) {
               LOGGER.error("Error getProperties", e);
            }
         }
      }

   }

   /**
    * Obtener propertie entero
    * @param propertie
    * @return Propertie Int
    */
   public static int getPropertiesInt(String propertie) {

      final Properties prop = new Properties();
      InputStream input = null;
      int propertieInt = 0;
      try {
         input = new FileInputStream(PATH_CONFIG_PROPERTIES);
         prop.load(input);
         String propertieString = prop.getProperty(propertie);
         propertieInt = Integer.parseInt(propertieString);
         return propertieInt;

      } catch (final IOException ex) {
         LOGGER.error("Error getPropertiesInt", ex);
         return propertieInt;
      } finally {
         if (input != null) {
            try {
               input.close();
            } catch (final IOException e) {
               LOGGER.error("getPropertiesInt", e);
            }
         }
      }

   }

}

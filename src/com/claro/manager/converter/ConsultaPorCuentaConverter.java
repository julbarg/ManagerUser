package com.claro.manager.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter("consultaPorCuentaConverter")
public class ConsultaPorCuentaConverter implements Converter {

   @Override
   public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) throws ConverterException {
      return null;
   }

   @Override
   public String getAsString(FacesContext arg0, UIComponent arg1, Object value) throws ConverterException {
      String valor = (String) value;
      if ("S".equals(valor)) {
         return "Si";
      } else {
         return "No";
      }
   }

}

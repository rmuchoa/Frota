/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.converter;

import com.model.entity.Estado;
import com.model.entity.TipoVeiculo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author renanmarceluchoa
 */
@FacesConverter(value="EstadoConverter")
public class EstadoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && !value.equals("")) {
        
            return component.getAttributes().get(value);
        
        }
        
        return null;
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if (value != null) {
        
            Estado estado = (Estado) value;
            String key = estado.getSigla();
            component.getAttributes().put(key, estado);
            return key;
        
        }
        
        return null;
        
    }
    
}

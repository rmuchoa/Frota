/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.converter;

import com.model.entity.TipoUsuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author renanmarceluchoa
 */
@FacesConverter(value="TipoUsuarioConverter")
public class TipoUsuarioConverter implements Converter {

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
        
            TipoUsuario tipo = (TipoUsuario) value;
            String key = tipo.getDescricao();
            component.getAttributes().put(key, tipo);
            return key;
        
        }
        
        return null;
        
    }
    
}

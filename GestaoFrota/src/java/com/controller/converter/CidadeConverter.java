/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.converter;

import com.model.entity.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author renanmarceluchoa
 */
@FacesConverter(value="CidadeConverter")
public class CidadeConverter implements Converter {

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
        
            Cidade cidade = (Cidade) value;
            String key = cidade.getNome();
            component.getAttributes().put(key, cidade);
            return key;
        
        }
        
        return null;
        
    }
    
}

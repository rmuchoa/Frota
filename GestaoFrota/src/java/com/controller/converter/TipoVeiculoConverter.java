/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.converter;

import com.model.entity.TipoVeiculo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author renanmarceluchoa
 */
@FacesConverter(value="TipoVeiculoConverter")
public class TipoVeiculoConverter implements Converter {

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
        
            TipoVeiculo tipo = (TipoVeiculo) value;
            this.addAttribute(component, tipo);
            return tipo.getDescricao();
        
        }
        
        return null;
        
    }
    
    
    protected void addAttribute(UIComponent component, TipoVeiculo tipo) {  
        
        String key = tipo.getDescricao();
        component.getAttributes().put(key, tipo);
        
    }
    
}

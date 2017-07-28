package com.empyme.bogota.controllers;

import com.empyme.bogota.entitys.Codigosdescripcion;
import com.empyme.bogota.controllers.util.JsfUtil;
import com.empyme.bogota.controllers.util.JsfUtil.PersistAction;
import com.empyme.bogota.facade.CodigosdescripcionFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("codigosdescripcionController")
@SessionScoped
public class CodigosdescripcionController implements Serializable {

    @EJB
    private com.empyme.bogota.facade.CodigosdescripcionFacade ejbFacade;
    private List<Codigosdescripcion> items = null;
    private Codigosdescripcion selected;

    public CodigosdescripcionController() {
    }

    public Codigosdescripcion getSelected() {
        return selected;
    }

    public void setSelected(Codigosdescripcion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CodigosdescripcionFacade getFacade() {
        return ejbFacade;
    }

    public Codigosdescripcion prepareCreate() {
        selected = new Codigosdescripcion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle/Mensajes").getString("CodigosdescripcionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle/Mensajes").getString("CodigosdescripcionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle/Mensajes").getString("CodigosdescripcionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Codigosdescripcion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle/Mensajes").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle/Mensajes").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Codigosdescripcion getCodigosdescripcion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Codigosdescripcion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Codigosdescripcion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Codigosdescripcion.class)
    public static class CodigosdescripcionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CodigosdescripcionController controller = (CodigosdescripcionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "codigosdescripcionController");
            return controller.getCodigosdescripcion(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Codigosdescripcion) {
                Codigosdescripcion o = (Codigosdescripcion) object;
                return getStringKey(o.getCodDescripcion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Codigosdescripcion.class.getName()});
                return null;
            }
        }

    }

}

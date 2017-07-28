package com.empyme.bogota.controllers;

import com.empyme.bogota.entitys.Tipodoc;
import com.empyme.bogota.controllers.util.JsfUtil;
import com.empyme.bogota.controllers.util.JsfUtil.PersistAction;
import com.empyme.bogota.facade.TipodocFacade;

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

@Named("tipodocController")
@SessionScoped
public class TipodocController implements Serializable {

    @EJB
    private com.empyme.bogota.facade.TipodocFacade ejbFacade;
    private List<Tipodoc> items = null;
    private Tipodoc selected;

    public TipodocController() {
    }

    public Tipodoc getSelected() {
        return selected;
    }

    public void setSelected(Tipodoc selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TipodocFacade getFacade() {
        return ejbFacade;
    }

    public Tipodoc prepareCreate() {
        selected = new Tipodoc();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle/Mensajes").getString("TipodocCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle/Mensajes").getString("TipodocUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle/Mensajes").getString("TipodocDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tipodoc> getItems() {
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

    public Tipodoc getTipodoc(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Tipodoc> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tipodoc> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tipodoc.class)
    public static class TipodocControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipodocController controller = (TipodocController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipodocController");
            return controller.getTipodoc(getKey(value));
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
            if (object instanceof Tipodoc) {
                Tipodoc o = (Tipodoc) object;
                return getStringKey(o.getCodTipo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tipodoc.class.getName()});
                return null;
            }
        }

    }

}

package com.empyme.bogota.controllers;

import com.empyme.bogota.entitys.Tiposdesociedades;
import com.empyme.bogota.controllers.util.JsfUtil;
import com.empyme.bogota.controllers.util.JsfUtil.PersistAction;
import com.empyme.bogota.facade.TiposdesociedadesFacade;

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

@Named("tiposdesociedadesController")
@SessionScoped
public class TiposdesociedadesController implements Serializable {

    @EJB
    private com.empyme.bogota.facade.TiposdesociedadesFacade ejbFacade;
    private List<Tiposdesociedades> items = null;
    private Tiposdesociedades selected;

    public TiposdesociedadesController() {
    }

    public Tiposdesociedades getSelected() {
        return selected;
    }

    public void setSelected(Tiposdesociedades selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TiposdesociedadesFacade getFacade() {
        return ejbFacade;
    }

    public Tiposdesociedades prepareCreate() {
        selected = new Tiposdesociedades();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle/Mensajes").getString("TiposdesociedadesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle/Mensajes").getString("TiposdesociedadesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle/Mensajes").getString("TiposdesociedadesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tiposdesociedades> getItems() {
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

    public Tiposdesociedades getTiposdesociedades(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Tiposdesociedades> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tiposdesociedades> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tiposdesociedades.class)
    public static class TiposdesociedadesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TiposdesociedadesController controller = (TiposdesociedadesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tiposdesociedadesController");
            return controller.getTiposdesociedades(getKey(value));
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
            if (object instanceof Tiposdesociedades) {
                Tiposdesociedades o = (Tiposdesociedades) object;
                return getStringKey(o.getCodigo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tiposdesociedades.class.getName()});
                return null;
            }
        }

    }

}
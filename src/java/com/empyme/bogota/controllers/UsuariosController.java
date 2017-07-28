package com.empyme.bogota.controllers;

import com.empyme.bogota.entitys.Usuarios;
import com.empyme.bogota.controllers.util.JsfUtil;
import com.empyme.bogota.controllers.util.JsfUtil.PersistAction;
import com.empyme.bogota.facade.UsuariosFacade;

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

@Named("usuariosController")
@SessionScoped
public class UsuariosController implements Serializable {

    @EJB
    private com.empyme.bogota.facade.UsuariosFacade ejbFacade;
    private List<Usuarios> items = null;
    private Usuarios selected;

    public UsuariosController() {
    }

    public Usuarios getSelected() {
        return selected;
    }

    public void setSelected(Usuarios selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getUsuariosPK().setEmpresaNit(selected.getEmpresas().getNit());
        selected.getUsuariosPK().setIdusuario(selected.getRepresentantes().getIdentificacion());
    }

    protected void initializeEmbeddableKey() {
        selected.setUsuariosPK(new com.empyme.bogota.entitys.UsuariosPK());
    }

    private UsuariosFacade getFacade() {
        return ejbFacade;
    }

    public Usuarios prepareCreate() {
        selected = new Usuarios();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle/Mensajes").getString("UsuariosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle/Mensajes").getString("UsuariosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle/Mensajes").getString("UsuariosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Usuarios> getItems() {
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

    public Usuarios getUsuarios(com.empyme.bogota.entitys.UsuariosPK id) {
        return getFacade().find(id);
    }

    public List<Usuarios> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Usuarios> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Usuarios.class)
    public static class UsuariosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuariosController controller = (UsuariosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuariosController");
            return controller.getUsuarios(getKey(value));
        }

        com.empyme.bogota.entitys.UsuariosPK getKey(String value) {
            com.empyme.bogota.entitys.UsuariosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.empyme.bogota.entitys.UsuariosPK();
            key.setIdusuario(Integer.parseInt(values[0]));
            key.setEmpresaNit(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.empyme.bogota.entitys.UsuariosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdusuario());
            sb.append(SEPARATOR);
            sb.append(value.getEmpresaNit());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Usuarios) {
                Usuarios o = (Usuarios) object;
                return getStringKey(o.getUsuariosPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Usuarios.class.getName()});
                return null;
            }
        }

    }

}

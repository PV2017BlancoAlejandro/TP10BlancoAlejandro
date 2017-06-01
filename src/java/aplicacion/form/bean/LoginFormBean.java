/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.modelo.datos.ColeccionUsuarios;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alumno
 */
@ManagedBean
@RequestScoped
public class LoginFormBean implements Serializable {
    private String unUsuario;
    private String unaContraseña;

    public LoginFormBean(String unUsuario, String unaContraseña) {
        this.unUsuario = unUsuario;
        this.unaContraseña = unaContraseña;
    }
    
    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
    }
        
    public String validarUsuario(){
        String resultado = null;
        ColeccionUsuarios usuarios = new ColeccionUsuarios();
        Usuario usuario = new Usuario();
        usuario = usuarios.validarUsuario(getUnUsuario(), getUnaContraseña());
        if(usuario == null){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales Inválidas","Credenciales Inválidas");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        else{
            FacesMessage facesMessage = new FacesMessage (FacesMessage.SEVERITY_INFO,"Usuario Válido", "Usuario Válido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado", usuario);
            resultado = "/menu";
            //resltado = "/menu?faces-redirect=true";
        }
        return resultado;
    }
    
    public String getNombreUsuarioValidado (){
        Usuario usuario = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        return usuario.getUsuario();
    }
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesMessage facesMessage = new FacesMessage (FacesMessage.SEVERITY_INFO,"Sesion Cerrada","Sesion Cerrada");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        String resultado="/login";
        //String resultado = "/login?faces-redirect=true";
        return resultado;
         }
    
    public boolean verificarSesion(){
        boolean sesionValida = false;
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado")!=null){
            sesionValida = true;}
            return sesionValida;
    }
    /**
     * @return the unUsuario
     */
    public String getUnUsuario() {
        return unUsuario;
    }

    /**
     * @param unUsuario the unUsuario to set
     */
    public void setUnUsuario(String unUsuario) {
        this.unUsuario = unUsuario;
    }

    /**
     * @return the unaContraseña
     */
    public String getUnaContraseña() {
        return unaContraseña;
    }

    /**
     * @param unaContraseña the unaContraseña to set
     */
    public void setUnaContraseña(String unaContraseña) {
        this.unaContraseña = unaContraseña;
    }
    
}

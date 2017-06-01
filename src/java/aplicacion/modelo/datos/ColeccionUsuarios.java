/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.datos;

import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class ColeccionUsuarios implements Serializable {
    private Usuario usuario;
    private ArrayList<Usuario> usuarios;

    public ColeccionUsuarios() {
    usuarios = new ArrayList ();
    usuarios.add(new Usuario("admin","admin"));
    usuarios.add(new Usuario("usuario","usuario"));
    usuarios.add(new Usuario("alumno","alumno"));
    }

    public Usuario validarUsuario(String unUsuario, String unaContraseña){
        usuario = new Usuario();
        Usuario usuario = null;
        for (Usuario u: usuarios){
            if ((u.getUsuario().equals(unUsuario)) && (u.getContraseña().equals(unaContraseña))){
                usuario=u;
        break;
            }
        }
        return usuario;
    }
    
    public ColeccionUsuarios(Usuario usuario, ArrayList<Usuario> usuarios) {
        this.usuario = usuario;
        this.usuarios = usuarios;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}

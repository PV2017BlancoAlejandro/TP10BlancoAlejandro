/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.modelo.datos.ColeccionClientes;
import aplicacion.modelo.dominio.Cliente;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Alumno
 */
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
    private Cliente cliente;

    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
    }
    
    @PostConstruct
    public void init (){
        if (getCliente() == null){
            setCliente(new Cliente());
            
        }
    }

    public ArrayList <Cliente> obtenerClientes(){
        if (ColeccionClientes.clientes == null){
            ColeccionClientes.llenarTabla();
        }
        return ColeccionClientes.clientes;
        
    }
    
    public void establecerCliente (Cliente cliente){
        setCliente(cliente);
    }
    
    public void agregarCliente(){
        ColeccionClientes.clientes.add(getCliente());
    }
    
    public void modificarCliente(){
        for (Cliente p: ColeccionClientes.clientes){
            if (p.getClienteId()==(getCliente().getClienteId())){
                ColeccionClientes.clientes.set(ColeccionClientes.clientes.indexOf(p), getCliente());
                break;
            }
        }
    }
    
    public void eliminarCliente(){
         for (Cliente p: ColeccionClientes.clientes){
            if (p.getClienteId()==(getCliente().getClienteId())){
                ColeccionClientes.clientes.remove(ColeccionClientes.clientes.indexOf(p));
                break;
            }
        }
    }
    
    
    
    
    public Cliente obtenerUnCliente (Integer dni){
        return cliente;
    }
    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

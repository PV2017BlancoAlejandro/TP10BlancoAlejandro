/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.modelo.dominio.Cliente;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Alumno
 */
@ManagedBean
@ViewScoped
public class ClienteFormBean implements Serializable {
    @ManagedProperty(value= "#{clienteBean}" )
    private ClienteBean clienteBean;
    private ArrayList <Cliente> listadoClientes;
    private transient UploadedFile file = null;
    
    /**
     * Creates a new instance of ClienteFormBean
     */
    public ClienteFormBean() {
    }

    public ArrayList<Cliente> obtenerCliente(){
        return getClienteBean().obtenerClientes();
    }

    public void establecerCliente (Cliente cliente){
        getClienteBean().establecerCliente(cliente);
    }
    
    public void agregarCliente (){
        tratarFoto();
        getClienteBean().agregarCliente();
    }
    
    public void modificarCliente(){
        tratarFoto();
        getClienteBean().modificarCliente();
    }
    public void eliminarCliente(){
        getClienteBean().eliminarCliente();
        RequestContext.getCurrentInstance().execute("PF('eliminarCliente').hide()");
    }
    
    public void inicializarCliente(){
        clienteBean = new ClienteBean();
        clienteBean.setCliente(new Cliente());
        RequestContext.getCurrentInstance().execute("PF('altaCliente').show()");
    }
    
    public Date getFechaActual(){
        return new Date(System.currentTimeMillis());
    }
    
    public StreamedContent getFotoCliente () throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        if(context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE){
            return new DefaultStreamedContent();
            
        }
        else{
            String dni = context.getExternalContext().getRequestParameterMap().get("dni");
            Cliente cliente = getClienteBean().obtenerUnCliente(Integer.parseInt(dni));
            if (cliente.getFoto()==null){
                return null;
                
            }else{
                return new DefaultStreamedContent (new ByteArrayInputStream(cliente.getFoto()));
            }
        }
    }
    
    public void tratarFoto(){
        try{
            InputStream inputStream = this.getFile().getInputstream();
           
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte [] bytes = new byte[(int) getFile().getSize()];
            while ((nRead = inputStream.read(bytes,0,bytes.length))!=-1){
                buffer.write(bytes, 0, nRead);
            }
            buffer.flush();
            getClienteBean().getCliente().setFoto(buffer.toByteArray());
            
        } catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
            (FacesMessage.SEVERITY_FATAL,"Error","Error: No se puede cargar el archivo"));
        }
    }
    /**
     * @return the clienteBean
     */
    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    /**
     * @param clienteBean the clienteBean to set
     */
    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    /**
     * @return the listadoClientes
     */
    public ArrayList <Cliente> getListadoClientes() {
        return listadoClientes;
    }

    /**
     * @param listadoClientes the listadoClientes to set
     */
    public void setListadoClientes(ArrayList <Cliente> listadoClientes) {
        this.listadoClientes = listadoClientes;
    }

    /**
     * @return the file
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }
}

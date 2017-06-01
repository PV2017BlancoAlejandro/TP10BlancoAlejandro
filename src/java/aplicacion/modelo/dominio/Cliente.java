/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Date;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Alumno
 */
public class Cliente implements Serializable {
    private int clienteId;
    private Integer dni = 0;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String correoElectronico;
    private byte[] foto;
    private StreamedContent muestraFoto = null;

    public Cliente() {
    }

    public Cliente(int clienteId, Integer dni, String nombre, String apellido, Date fechaNacimiento, String correoElectronico, byte[] foto) {
        this.clienteId = clienteId;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.foto = foto;
    }
    
    public boolean getConFoto(){
        boolean resu = false;
        if (getFoto()!= null){
            resu = true;
        }
        return resu;
    }

    /**
     * @return the clienteId
     */
    public int getClienteId() {
        return clienteId;
    }

    /**
     * @param clienteId the clienteId to set
     */
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    /**
     * @return the dni
     */
    public Integer getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(Integer dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    /**
     * @return the muestraFoto
     */
    public StreamedContent getMuestraFoto() {
        if (getFoto()!= null){
            return new DefaultStreamedContent (new ByteArrayInputStream(getFoto()));
        }
        else{
        return null;
        }
    }

    /**
     * @param muestraFoto the muestraFoto to set
     */
    public void setMuestraFoto(StreamedContent muestraFoto) {
        this.muestraFoto = muestraFoto;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.datos;

import aplicacion.modelo.dominio.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Alumno
 */
public class ColeccionClientes implements Serializable {
    public static ArrayList <Cliente> clientes;
    
    public static void llenarTabla(){
        clientes = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, 2, 28);
        String correo = "correo1@gmail.com";
        
        clientes.add(new Cliente (120, 154516, "Neo", "Smith", calendar.getTime(),correo,null));
        
        calendar.set(2012, 8, 11);
        correo = "correo2@gmail.com";
        
        clientes.add(new Cliente (77, 23471, "Cersei", "Stark", calendar.getTime(), correo, null));
        }
    }
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.persistence;
//imports
import es.uah.javafit.model.gym.Actividad;
import es.uah.javafit.model.gym.Reserva;
import es.uah.javafit.model.usuarios.Admin;
import es.uah.javafit.model.usuarios.Socio;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author razie
 */
public class GestorGym implements Serializable
{
    private ArrayList<Admin> admins;
    private ArrayList<Socio> socios;
    private ArrayList<Actividad> actividades;
    private ArrayList<Reserva> reservas;

    public GestorGym(ArrayList<Admin> admins, ArrayList<Socio> socios, ArrayList<Actividad> actividades, ArrayList<Reserva> reservas) 
    {
        this.admins = admins;
        this.socios = socios;
        this.actividades = actividades;
        this.reservas = reservas;
    }
    
    //Setter y getter

    public ArrayList<Admin> getAdmins() 
    {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) 
    {
        this.admins = admins;
    }

    public ArrayList<Socio> getSocios() 
    {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socios) 
    {
        this.socios = socios;
    }

    public ArrayList<Actividad> getActividades() 
    {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) 
    {
        this.actividades = actividades;
    }

    public ArrayList<Reserva> getReservas() 
    {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) 
    {
        this.reservas = reservas;
    }
    
    // Funciones y Metodos
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.model.gym;
// imports

import es.uah.javafit.model.enums.TipoActividad;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author razie
 */
public class Actividad 
{
    private String id;
    private String titulo;
    private TipoActividad tipo;
    private Sala sala;
    private Horario horario;
    private String monitor;
    private String rutaImagen;

    public Actividad(String id, String titulo, TipoActividad tipo, Sala sala, Horario horario, String monitor, String rutaImagen) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.sala = sala;
        this.horario = horario;
        this.monitor = monitor;
        this.rutaImagen = rutaImagen;
    }
    
    //Setters y getters

    public String getId() 
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getTitulo() 
    {
        return titulo;
    }

    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }

    public TipoActividad getTipo() 
    {
        return tipo;
    }

    public void setTipo(TipoActividad tipo) 
    {
        this.tipo = tipo;
    }

    public Sala getSala() 
    {
        return sala;
    }

    public void setSala(Sala sala) 
    {
        this.sala = sala;
    }

    public Horario getHorario() 
    {
        return horario;
    }

    public void setHorario(Horario horario) 
    {
        this.horario = horario;
    }

    public String getMonitor() 
    {
        return monitor;
    }

    public void setMonitor(String monitor) 
    {
        this.monitor = monitor;
    }

    public String getRutaImagen() 
    {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) 
    {
        this.rutaImagen = rutaImagen;
    }
    // funciones:
    public int getAforoDisponible(ArrayList<Reserva> reservas, LocalDate fecha)
    {
        return 1; // temporal
    }
    public boolean isEspecial()
    {
        return false;
    }
}

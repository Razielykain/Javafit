/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.model.gym;
//imports
import es.uah.javafit.model.usuarios.Socio;
import java.io.Serializable;
import java.time.LocalDate;


/**
 *
 * @author razie
 */
public class Reserva implements Serializable
{
    private String id;
    private Socio socio;
    private Actividad act;
    private LocalDate fecha;
    private double coste;

    public Reserva(String id, Socio socio, Actividad act, LocalDate fecha, double coste) 
    {
        this.id = id;
        this.socio = socio;
        this.act = act;
        this.fecha = fecha;
        this.coste = coste;
    }

    // Setter y getter
    public String getId() 
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public Socio getSocio() 
    {
        return socio;
    }

    public void setSocio(Socio socio) 
    {
        this.socio = socio;
    }

    public Actividad getAct() 
    {
        return act;
    }

    public void setAct(Actividad act) 
    {
        this.act = act;
    }

    public LocalDate getFecha() 
    {
        return fecha;
    }

    public void setFecha(LocalDate fecha) 
    {
        this.fecha = fecha;
    }

    public double getCoste() 
    {
        return coste;
    }

    public void setCoste(double coste) 
    {
        this.coste = coste;
    }
    
    // Metodos y Funciones
    public void generarRecibo()
    {
        // cuando aprenda a generar archivos lo hare
    }
    public boolean esCancelable()
    {
       return true; // no se para que es 
    }

    @Override
    public String toString() 
    {
        return "Reserva{" + "id=" + id + ", socio=" + socio + ", act=" + act + ", fecha=" + fecha + ", coste=" + coste + '}';
    }
}

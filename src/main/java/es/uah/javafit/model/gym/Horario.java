/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.model.gym;

// imports
import es.uah.javafit.model.enums.DiaSemana;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.EnumSet;

/**
 *
 * @author razie
 */
public class Horario implements Serializable
{
    private EnumSet<DiaSemana> dias;
    private LocalTime hInicio;
    private LocalTime hFin;

    public Horario(EnumSet<DiaSemana> dias, LocalTime hInicio, LocalTime hFin) 
    {
        this.dias = dias;
        this.hInicio = hInicio;
        this.hFin = hFin;
    }
    
    // Setters y getters

    public EnumSet<DiaSemana> getDias() 
    {
        return dias;
    }

    public void setDias(EnumSet<DiaSemana> dias) 
    {
        this.dias = dias;
    }

    public LocalTime gethInicio() 
    {
        return hInicio;
    }

    public void sethInicio(LocalTime hInicio) 
    {
        this.hInicio = hInicio;
    }

    public LocalTime gethFin() 
    {
        return hFin;
    }

    public void sethFin(LocalTime hFin) 
    {
        this.hFin = hFin;
    }
    // funciones
    public boolean includes(DiaSemana day)
    {
        return this.dias.contains(day);
    }
    
    @Override
    public String toString() 
    {
        return "Horario{" + "dias=" + dias + ", hInicio=" + hInicio + ", hFin=" + hFin + '}';
    }
    
}

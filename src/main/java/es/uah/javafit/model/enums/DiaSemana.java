/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package es.uah.javafit.model.enums;

import java.time.DayOfWeek;

/**
 *
 * @author razie
 */
public enum DiaSemana 
{
    LUNES("Lunes"),
    MARTES("Martes"),
    MIERCOLES("Miercoles"),
    JUEVES("Jueves"), 
    VIERNES("Viernes"),
    SABADO("Sabado"),
    DOMINGO("Domingo");
    
    // atributo
    private final String etiqueta;

    private DiaSemana(String etiqueta) 
    {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() 
    {
        return etiqueta;
    }
    
    public static DiaSemana fromDayOfWeek(DayOfWeek dow)
    {
        switch (dow)
        {
            case MONDAY : return DiaSemana.LUNES;
            case TUESDAY : return DiaSemana.MARTES;
            case WEDNESDAY : return DiaSemana.MIERCOLES;
            case THURSDAY : return DiaSemana.JUEVES;
            case FRIDAY : return DiaSemana.VIERNES;
            case SATURDAY : return DiaSemana.SABADO;
            case SUNDAY : return DiaSemana.DOMINGO;
        }
        return null;
    }
}

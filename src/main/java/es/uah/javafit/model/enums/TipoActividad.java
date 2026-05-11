/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package es.uah.javafit.model.enums;

/**
 *
 * @author razie
 */
public enum TipoActividad 
{
    YOGA("Yoga"),
    MUSCULACION("Musculación"),
    CARDIO("Cardio"),
    NATACION("Natación");

    // atributo
    private final String etiqueta;
    
    TipoActividad(String etiqueta) 
    {
        this.etiqueta = etiqueta; 
    }
    
    public String getEtiqueta() 
    { 
        return etiqueta; 
    }
}

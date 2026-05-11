/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package es.uah.javafit.model.enums;

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
}

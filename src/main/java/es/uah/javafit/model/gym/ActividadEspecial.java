/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.model.gym;
//imports
import es.uah.javafit.model.enums.TipoActividad;
import es.uah.javafit.model.usuarios.Socio;

/**
 *
 * @author razie
 */
public class ActividadEspecial extends Actividad 
{
    private double price;
    private String descripcion;

    public ActividadEspecial(double price, String descripcion, String id, String titulo, TipoActividad tipo, Sala sala, Horario horario, String monitor, String rutaImagen) 
    {
        super(id, titulo, tipo, sala, horario, monitor, rutaImagen);
        this.price = price;
        this.descripcion = descripcion;
    }
    
    //setter y getter

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }
    
    // Funciones:
    public double calcPrecioFinal(Socio socio)
    {
        return socio.calcPrecio(price);
    }

    @Override
    public boolean isEspecial() 
    {
        return true;
    }

    @Override
    public String toString() 
    {
        return "ActividadEspecial{" + "price=" + price + ", descripcion=" + descripcion + '}';
    }
    
}

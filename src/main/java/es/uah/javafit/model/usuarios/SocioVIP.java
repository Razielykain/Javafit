/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.model.usuarios;

/**
 *
 * @author razie
 */
public class SocioVIP extends Socio
{
    static final double CMENSUAL = 0; // temporal
    static final double DESCUENTO = 0.1;

    public SocioVIP(String user, String password, String name, String telefono, String dir, String tc) {
        super(user, password, name, telefono, dir, tc);
    }

    @Override
    public double calcPrecio(double base) 
    {
        return base*(1-DESCUENTO);
    }

    @Override
    public double getCuotaMensual() 
    {
        return SocioVIP.CMENSUAL;
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.model.usuarios;

/**
 *
 * @author razie
 */
public abstract class Socio extends User
{
    // atributos
    private String name;
    private String telefono;
    private String dir;
    private TarjetaCredito tc;

    public Socio(String name, String telefono, String dir, TarjetaCredito tc, String user, String password) 
    {
        super(user, password);
        this.name = name;
        this.telefono = telefono;
        this.dir = dir;
        this.tc = tc;
    }

    // Setter y getter

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getTelefono() 
    {
        return telefono;
    }

    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }

    public String getDir() 
    {
        return dir;
    }

    public void setDir(String dir) 
    {
        this.dir = dir;
    }

    public TarjetaCredito getTc() 
    {
        return tc;
    }

    public void setTc(TarjetaCredito tc) 
    {
        this.tc = tc;
    }
    
    // FUNCIONES:
    public abstract double calcPrecio(double base);
    public abstract double getCuotaMensual();
    public boolean esVIP()
    {
        return (SocioVIP.class==this.getClass());
    }

    @Override
    public String toString() 
    {
        return "Socio{" + "name=" + name + ", telefono=" + telefono + ", dir=" + dir + ", tc=" + tc + '}';
    }
    
    
}

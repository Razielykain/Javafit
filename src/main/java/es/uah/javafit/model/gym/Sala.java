/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.model.gym;

/**
 *
 * @author razie
 */
public class Sala 
{
    private String name;
    private int aforoMax;

    public Sala(String name, int aforoMax) 
    {
        this.name = name;
        this.aforoMax = aforoMax;
    }
    
    // Getter y setter
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getAforoMax() 
    {
        return aforoMax;
    }

    public void setAforoMax(int aforoMax) 
    {
        this.aforoMax = aforoMax;
    }

    @Override
    public String toString() 
    {
        return "Sala{" + "name=" + name + ", aforoMax=" + aforoMax + '}';
    }
    
    
}

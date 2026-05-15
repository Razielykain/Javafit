/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.model.usuarios;

/**
 *
 * @author razie
 */
// imports
import java.io.Serializable;
import java.time.YearMonth;
public class TarjetaCredito  implements Serializable
{
    //atributos
    private String name;
    private String num;
    private YearMonth expDate;
    private int ccv;

    public TarjetaCredito(String name, String num, YearMonth expDate, int ccv) {
        this.name = name;
        this.num = num;
        this.expDate = expDate;
        this.ccv = ccv;
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

    public String getNum() 
    {
        return num;
    }

    public void setNum(String num) 
    {
        this.num = num;
    }

    public YearMonth getExpDate() 
    {
        return expDate;
    }

    public void setExpDate(YearMonth expDate) 
    {
        this.expDate = expDate;
    }

    public int getCcv() 
    {
        return ccv;
    }

    public void setCcv(int ccv) 
    {
        this.ccv = ccv;
    }
    
    public String getNumEnmascarado()
    {
        if (num == null || num.length() < 4)
            return "****";
        return "**** **** **** " + num.substring(num.length() - 4);
    }
    //hacemos un metodo para mostrar solo los ultimos 4 digitos de la tarjeta, no todos
    
    public boolean estaVigente()
    {
        if (expDate == null) return false;
        return !expDate.isBefore(YearMonth.now());
    }
    //hacemos otro metodo para comprobar que la tarjeta esta vigente
    
    @Override
    public String toString()
    {
        return "TarjetaCredito{titular=" + name +
               ", num=" + getNumEnmascarado() +
               ", expDate=" + expDate + '}';
        //el ccv no hace falta mostrarlo ya que nunca se muestra en ningún sitio
    }
    
    
}

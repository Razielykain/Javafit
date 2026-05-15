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

    @Override
    // probablemente haya que hacer una funcion digitos() para solo mostrar los ultimos 4 digitos de la tarjeta
    public String toString() 
    {
        return "TarjetaCredito{" + "name=" + name + ", num=" + num + ", expDate=" + expDate + ", ccv=" + ccv + '}';
    }
    
}

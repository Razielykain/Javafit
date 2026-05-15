/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.persistence;

/**
 *
 * @author razie
 */
import javax.swing.JOptionPane;

public class Mensaje
{
    public static void error(String msg)
    {
        JOptionPane.showMessageDialog(null,msg,"ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public static void info(String msg)
    {
        JOptionPane.showMessageDialog(null,msg,"Información",JOptionPane.INFORMATION_MESSAGE);
    }
}

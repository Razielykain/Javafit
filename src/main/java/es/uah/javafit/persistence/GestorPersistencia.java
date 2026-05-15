/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.persistence;
//imports

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class GestorPersistencia 
{
    static final String RUTA = "datos.dat";

    // Guarda el objeto en un archivo
    public static void guardar(GestorGym g)
    {
        try
        {
            ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(RUTA));

            oos.writeObject(g);
            oos.close();
        }
        catch (IOException e)
        {
            Mensaje.error(e.getMessage());
        }
    }

    // Carga el objeto desde un archivo
    public static GestorGym cargar()
    {
        try
        {
            ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(RUTA));

            GestorGym gestor = (GestorGym) ois.readObject();

            ois.close();

            return gestor;
        }
        catch (IOException | ClassNotFoundException e)
        {
            Mensaje.error(e.getMessage());
            return null;
        }
    }
}
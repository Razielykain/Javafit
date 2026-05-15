/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.uah.javafit;

import es.uah.javafit.persistence.DataLoader;
import es.uah.javafit.persistence.GestorGym;
import es.uah.javafit.persistence.GestorPersistencia;
import java.io.File;

/**
 *
 * @author razie
 */
public class Javafit 
{

    public static void main(String[] args) 
    {
        GestorGym gestor;
        File archivo = new File("datos.dat");

        if (archivo.exists()) 
        {
            gestor = GestorPersistencia.cargar();
        } else 
        {
            gestor = new GestorGym();
            DataLoader.cargarDatosPrueba(gestor);
        }
        GestorPersistencia.guardar(gestor);
    }
}

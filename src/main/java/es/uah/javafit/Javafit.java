/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.uah.javafit;

import es.uah.javafit.persistence.DataLoader;
import es.uah.javafit.persistence.GestorGym;
import es.uah.javafit.persistence.GestorPersistencia;
import es.uah.javafit.ui.LoginFrame;
import java.io.File;
import javax.swing.SwingUtilities;

// Punto de entrada de la aplicación JavaFit.
 
public class Javafit
{
    public static void main(String[] args)
    {
        // Se intentan cargar datos guardados de sesiones anteriores
        GestorGym gestor;
        File archivo = new File("datos.dat");

        if (archivo.exists())
        {
            // El fichero existe: cargar los datos persistidos
            gestor = GestorPersistencia.cargar();

            // Por seguridad: si cargar falla devuelve null y se crea uno nuevo
            if (gestor == null)
            {
                gestor = new GestorGym();
                DataLoader.cargarDatosPrueba(gestor);
            }
        }
        else
        {
            // Primera vez que se ejecuta se crean datos de prueba
            gestor = new GestorGym();
            DataLoader.cargarDatosPrueba(gestor);
        }

        // Guardamos referencia final 
        final GestorGym gestorFinal = gestor;

        // Lanzar la UI en el hilo de Swing
        // SwingUtilities.invokeLater nos garantiza que la UI se crea en el hilo correcto
        
        SwingUtilities.invokeLater(() ->
        {
            LoginFrame login = new LoginFrame(gestorFinal);
            login.setVisible(true);
        });
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.persistence;
//imports
import es.uah.javafit.model.enums.DiaSemana;
import es.uah.javafit.model.enums.TipoActividad;
import es.uah.javafit.model.gym.Actividad;
import es.uah.javafit.model.gym.ActividadEspecial;
import es.uah.javafit.model.gym.Horario;
import es.uah.javafit.model.gym.Sala;
import es.uah.javafit.model.usuarios.SocioBasico;
import es.uah.javafit.model.usuarios.SocioVIP;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumSet;
import java.util.UUID;
/**
 *
 * @author razie
 */
public class DataLoader implements Serializable
{
     public static void cargarDatosPrueba(GestorGym gestor) {
 
         try {
             // SALAS
             Sala salaYoga      = new Sala("Sala Yoga",        20);
             Sala salaMuscu     = new Sala("Sala Musculación", 30);
             Sala salaPiscina   = new Sala("Piscina",          15);
             Sala salaCardio    = new Sala("Sala Cardio",      25);
             
             // ACTIVIDADES
             
             Actividad yoga = new Actividad(
                     UUID.randomUUID().toString(),
                     "Yoga Matutino",
                     TipoActividad.YOGA,
                     salaYoga,
                     new Horario(
                             EnumSet.of(DiaSemana.LUNES, DiaSemana.MIERCOLES, DiaSemana.VIERNES),
                             LocalTime.of(9, 0),
                             LocalTime.of(10, 0)
                     ),
                     "Ana García",
                     "imagenes/yoga.png"
             );
             
             Actividad spinning = new Actividad(
                     UUID.randomUUID().toString(),
                     "Spinning Intensivo",
                     TipoActividad.CARDIO,
                     salaCardio,
                     new Horario(
                             EnumSet.of(DiaSemana.MARTES, DiaSemana.JUEVES),
                             LocalTime.of(18, 0),
                             LocalTime.of(19, 0)
                     ),
                     "Carlos López",
                     "imagenes/spinning.png"
             );
             
             Actividad musculacion = new Actividad(
                     UUID.randomUUID().toString(),
                     "Musculación Avanzada",
                     TipoActividad.MUSCULACION,
                     salaMuscu,
                     new Horario(
                             EnumSet.of(DiaSemana.LUNES, DiaSemana.MIERCOLES, DiaSemana.VIERNES),
                             LocalTime.of(17, 0),
                             LocalTime.of(18, 30)
                     ),
                     "Pedro Martínez",
                     "imagenes/musculacion.png"
             );
             
             Actividad natacion = new Actividad(
                     UUID.randomUUID().toString(),
                     "Natación Libre",
                     TipoActividad.NATACION,
                     salaPiscina,
                     new Horario(
                             EnumSet.of(DiaSemana.LUNES, DiaSemana.MARTES, DiaSemana.MIERCOLES,
                                     DiaSemana.JUEVES, DiaSemana.VIERNES),
                             LocalTime.of(8, 0),
                             LocalTime.of(9, 0)
                     ),
                     "Laura Sánchez",
                     "imagenes/natacion.png"
             );
             
             // ACTIVIDADES ESPECIALES (2)
             
             ActividadEspecial crossfit = new ActividadEspecial(
                     UUID.randomUUID().toString(),
                     "Sesión CrossFit HIIT",
                     TipoActividad.CARDIO,
                     salaCardio,
                     new Horario(
                             EnumSet.of(DiaSemana.SABADO),
                             LocalTime.of(10, 0),
                             LocalTime.of(11, 30)
                     ),
                     "Carlos López",
                     "imagenes/crossfit.png",
                     15.00,
                     "Sesión de alta intensidad combinando ejercicios funcionales y cardio."
             );
             
             ActividadEspecial yogaAvanzado = new ActividadEspecial(
                     UUID.randomUUID().toString(),
                     "Yoga y Meditación Avanzada",
                     TipoActividad.YOGA,
                     salaYoga,
                     new Horario(
                             EnumSet.of(DiaSemana.DOMINGO),
                             LocalTime.of(11, 0),
                             LocalTime.of(12, 30)
                     ),
                     "Ana García",
                     "imagenes/yoga_avanzado.png",
                     12.00,
                     "Sesión avanzada de yoga con técnicas de meditación y respiración."
             );
             gestor.agregarActividad(yoga);
             gestor.agregarActividad(spinning);
             gestor.agregarActividad(musculacion);
             gestor.agregarActividad(natacion);
             gestor.agregarActividad(crossfit);
             gestor.agregarActividad(yogaAvanzado);
             
             // SOCIOS (2 básicos, 2 VIP)
             
             SocioBasico juan = new SocioBasico(
                     "juan@email.com",
                     "1234",
                     "Juan Pérez",
                     "612345678",
                     "Calle Mayor 10, Madrid",
                     "4111111111111111"
             );
             
             SocioBasico maria = new SocioBasico(
                     "maria@email.com",
                     "1234",
                     "María González",
                     "623456789",
                     "Avenida Libertad 5, Madrid",
                     "4222222222222222"
             );
             
             SocioVIP carlos = new SocioVIP(
                     "carlos@email.com",
                     "1234",
                     "Carlos Rodríguez",
                     "634567890",
                     "Plaza España 3, Madrid",
                     "4333333333333333"
             );
             
             SocioVIP ana = new SocioVIP(
                     "ana@email.com",
                     "1234",
                     "Ana Martínez",
                     "645678901",
                     "Calle Alcalá 22, Madrid",
                     "4444444444444444"
             );
             
             gestor.registrarSocio(juan);
             gestor.registrarSocio(maria);
             gestor.registrarSocio(carlos);
             gestor.registrarSocio(ana);
             
             // RESERVAS
             
             gestor.realizarReserva(juan, yoga, LocalDate.of(2026, 5, 18));
             
             gestor.realizarReserva(maria,  spinning,    LocalDate.of(2026, 5, 19));
             
             gestor.realizarReserva(carlos, crossfit,    LocalDate.of(2026, 5, 16));
             
             gestor.realizarReserva(ana,    yogaAvanzado, LocalDate.of(2026, 5, 17));
             
             gestor.realizarReserva(juan,   natacion,    LocalDate.of(2026, 5, 21));
              
             gestor.realizarReserva(maria,  yogaAvanzado, LocalDate.of(2026, 5, 24));
         } catch (NoArgEx ex) {
            Mensaje.error(ex.getMessage()); // no deberia salir por que se supone que todo esta bien
         }
    }
}

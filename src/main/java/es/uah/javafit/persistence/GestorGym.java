/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.persistence;
//imports
import es.uah.javafit.model.enums.TipoActividad;
import es.uah.javafit.model.enums.DiaSemana;
import es.uah.javafit.model.gym.Actividad;
import es.uah.javafit.model.gym.ActividadEspecial;
import es.uah.javafit.model.gym.Reserva;
import es.uah.javafit.model.usuarios.Admin;
import es.uah.javafit.model.usuarios.Socio;
import es.uah.javafit.model.usuarios.User;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author razie
 */
public class GestorGym implements Serializable
{
    private ArrayList<Admin> admins;
    private ArrayList<Socio> socios;
    private ArrayList<Actividad> actividades;
    private ArrayList<Reserva> reservas;
    private static final long serialVersionUID = 1L; // para el serializable

    public GestorGym(ArrayList<Admin> admins, ArrayList<Socio> socios, ArrayList<Actividad> actividades, ArrayList<Reserva> reservas) 
    {
        this.admins = admins;
        this.socios = socios;
        this.actividades = actividades;
        this.reservas = reservas;
    }

    public GestorGym() 
    {
        this.admins = new ArrayList<>();
        this.socios = new ArrayList<>();
        this.actividades = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }
    
    //Setter y getter

    public ArrayList<Admin> getAdmins() 
    {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) 
    {
        this.admins = admins;
    }

    public ArrayList<Socio> getSocios() 
    {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socios) 
    {
        this.socios = socios;
    }

    public ArrayList<Actividad> getActividades() 
    {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) 
    {
        this.actividades = actividades;
    }

    public ArrayList<Reserva> getReservas() 
    {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) 
    {
        this.reservas = reservas;
    }
    
    // Funciones y Metodos
    
    public boolean isSocio(String user)
    { // para simplificar programas luego
        // claro que probablemente no se necesite ya que el resto de programas
        // se asume que si se estan ejecutando, el usuario ya esta registrado y ha hecho login
        for (Socio socio: this.socios)
            if (socio.getUser().equals(user))
                return true;
        return false;
    }
    
    public User login(String email, String clave) throws  LoginEx
    {
        for (Socio socio: this.socios)
            if (socio.getUser().equals(email))
            {
                if (!socio.autenticator(clave))
                    throw new LoginEx("Contraseña incorrecta");
                return socio;
            }
        for (Admin admin: this.admins)
            if (admin.getUser().equals(email))
            {
                if (!admin.autenticator(clave))
                    throw new LoginEx("Contraseña incorrecta");
                return admin;
            }
        return null; // luego hay que decirle al peras q ponga el try y catch ademas de unn if por si recibe null
    }
    
    public void registrarSocio(Socio s)
    {   // aqui peras tiene que tirar y manejar las excepciones
        this.socios.add(s);
    }
    
    public void agregarActividad(Actividad a)
    {   // aqui peras tiene que tirar y manejar las excepciones
        this.actividades.add(a);
    }
    
    public Reserva realizarReserva(Socio s, Actividad a, LocalDate fecha) throws NoArgEx
    {
        DiaSemana dia = DiaSemana.fromDayOfWeek(fecha.getDayOfWeek());
        // comprobaciones
        if (!a.getHorario().includes(dia))
            throw new NoArgEx("La fecha no coincide con el horario de la actividad");
        if (a.getAforoDisponible(reservas, fecha, a)<=0)
            throw new NoArgEx("No hay aforo disponible");
        double cost = 0;
        if (a.isEspecial())
        {
            ActividadEspecial ae = (ActividadEspecial) a;
            cost = s.calcPrecio(ae.getPrice());
        }
        // crearReserva()
        String id = UUID.randomUUID().toString();
        Reserva r = new Reserva(id, s, a, fecha, cost);
        reservas.add(r);
        r.generarRecibo();
        return r;
    }
    
    public void cancelarReserva(String id)throws NoArgEx
    {
        for (Reserva r: this.reservas)
            if (r.getId().equals(id))
            {
                reservas.remove(r);
                return;
            }
        throw new NoArgEx("La reserva no existe");
    }
    
    public ArrayList<Actividad> buscarPorTipo(TipoActividad tipo)
    {
        return (ArrayList<Actividad>) actividades.stream()
                .filter(a -> a.getTipo() == tipo) // lambda -> explicar a peritas
                .collect(Collectors.toList()); // o .collect(Collectors.toCollection(ArrayList::new))
    }
    
    public ArrayList<Actividad> buscarPorMonitor(String mon)
    {
        return (ArrayList<Actividad>) actividades.stream()
                .filter(a -> a.getMonitor().equals(mon))
                .collect(Collectors.toList()); // o .collect(Collectors.toCollection(ArrayList::new))
    }
    
    public ArrayList<Actividad> buscarPorDia(DiaSemana dia)
    {
        return (ArrayList<Actividad>) actividades.stream()
                .filter(a -> a.getHorario().includes(dia))
                .collect(Collectors.toList()); // o .collect(Collectors.toCollection(ArrayList::new))
    }
    
    public ArrayList<Reserva> getReservas(Socio s)
    {   // para cuando entras desde socio
        return (ArrayList<Reserva>)  reservas.stream()
                .filter(r -> r.getSocio()==s)
                .collect(Collectors.toList());
    }
    public ArrayList<Reserva> getReservasFecha(LocalDate fecha)
    {   // para cuando entras desde admin y quieres ver DESDE un dia
        return (ArrayList<Reserva>)  reservas.stream()
                .filter(r -> 0 <= ChronoUnit.DAYS.between(fecha, r.getFecha()))
                .collect(Collectors.toList());
    }
    // si eres admin y quieres ver todas las reservas pues getReservas()
}

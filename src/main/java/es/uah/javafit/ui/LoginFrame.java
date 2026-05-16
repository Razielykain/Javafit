/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author david
 */

package es.uah.javafit.ui;

import es.uah.javafit.model.usuarios.Admin;
import es.uah.javafit.model.usuarios.Socio;
import es.uah.javafit.model.usuarios.User;
import es.uah.javafit.persistence.GestorGym;
import es.uah.javafit.persistence.GestorPersistencia;
import es.uah.javafit.persistence.LoginEx;
import javax.swing.*;
import java.awt.*;

// Ventana de inicio de sesion de JavaFit, desde aqui se accede al panel de Admin o al panel de Socio.
 
public class LoginFrame extends JFrame
{
    private final GestorGym gestor;

    private JTextField campoEmail;
    private JPasswordField campoClave;

    public LoginFrame(GestorGym gestor)
    {
        this.gestor = gestor;
        initComponents();
    }

    //Construimos y colocamos los componentes de la ventana separados del constructor para mayor claridad.     
     
    private void initComponents()
    {
        // Configuracion de la ventana 
        setTitle("JavaFit - Iniciar sesión");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(420, 480);
        setLocationRelativeTo(null); // centrar en la pantalla
        setResizable(false);

        // Al cerrar la ventana, guardar datos y salir
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e)
            {
                GestorPersistencia.guardar(gestor);
                System.exit(0);
            }
        });

        //Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panelPrincipal.setBackground(Color.WHITE);

        //Logo 
        JLabel logo = new JLabel("JavaFit", SwingConstants.CENTER);
        logo.setFont(new Font("Arial", Font.BOLD, 42));
        logo.setForeground(new Color(30, 120, 60)); // verde gimnasio
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Tu gimnasio inteligente", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Arial", Font.ITALIC, 14));
        subtitulo.setForeground(Color.GRAY);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Separador visual
        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sep.setForeground(new Color(200, 200, 200));

        //Etiqueta "Iniciar sesion" 
        JLabel lblTitulo = new JLabel("Iniciar sesión");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Campo email
        JLabel lblEmail = new JLabel("Correo electrónico");
        lblEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoEmail = new JTextField();
        campoEmail.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        //Campo contraseña 
        JLabel lblClave = new JLabel("Contraseña");
        lblClave.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoClave = new JPasswordField();
        campoClave.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        //Botón Entrar
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEntrar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnEntrar.setBackground(new Color(30, 120, 60));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnEntrar.setFocusPainted(false);
        // Al pulsar Enter en el campo contraseña también hace login
        campoClave.addActionListener(e -> hacerLogin());
        btnEntrar.addActionListener(e -> hacerLogin());

        //Boton Registrarse 
        JButton btnRegistro = new JButton("¿No tienes cuenta? Regístrate");
        btnRegistro.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegistro.setBorderPainted(false);
        btnRegistro.setContentAreaFilled(false);
        btnRegistro.setForeground(new Color(30, 120, 60));
        btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegistro.addActionListener(e -> abrirRegistro());

        //Montamos todo en el panel
        panelPrincipal.add(logo);
        panelPrincipal.add(Box.createVerticalStrut(5));
        panelPrincipal.add(subtitulo);
        panelPrincipal.add(Box.createVerticalStrut(20));
        panelPrincipal.add(sep);
        panelPrincipal.add(Box.createVerticalStrut(20));
        panelPrincipal.add(lblTitulo);
        panelPrincipal.add(Box.createVerticalStrut(20));
        panelPrincipal.add(lblEmail);
        panelPrincipal.add(Box.createVerticalStrut(5));
        panelPrincipal.add(campoEmail);
        panelPrincipal.add(Box.createVerticalStrut(15));
        panelPrincipal.add(lblClave);
        panelPrincipal.add(Box.createVerticalStrut(5));
        panelPrincipal.add(campoClave);
        panelPrincipal.add(Box.createVerticalStrut(25));
        panelPrincipal.add(btnEntrar);
        panelPrincipal.add(Box.createVerticalStrut(10));
        panelPrincipal.add(btnRegistro);

        add(panelPrincipal);
    }

    //Lógica de login: llama al gestor y redirige según el tipo de usuario.
     
     
    private void hacerLogin()
    {
        String email = campoEmail.getText().trim();
        String clave = new String(campoClave.getPassword());

        
        if (email.isEmpty() || clave.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                "Por favor, rellena todos los campos.",
                "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try
        {
            
            User usuario = gestor.login(email, clave);

            // Redirigir según el tipo de usuario
            if (usuario instanceof Admin)
            {
                dispose(); // cerrar ventana de login
                new AdminFrame(gestor).setVisible(true);
            }
            else if (usuario instanceof Socio)
            {
                dispose();
                new SocioFrame(gestor, (Socio) usuario).setVisible(true);
            }
        }
        catch (LoginEx ex)
        {
            // Mostrar el mensaje de error que lanza GestorGym
            JOptionPane.showMessageDialog(this,
                ex.getMessage(),
                "Error de acceso", JOptionPane.ERROR_MESSAGE);
            campoClave.setText(""); // limpiar contraseña por seguridad
        }
    }

    //Abrimos el formulario de registro de nuevo socio.
     
    private void abrirRegistro()
    {
        new RegistroFrame(gestor, this).setVisible(true);
        setVisible(false); // ocultar login mientras se registra
    }
}

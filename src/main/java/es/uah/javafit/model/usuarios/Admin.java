/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.model.usuarios;

import java.io.Serializable;

/**
 *
 * @author razie
 */
public class Admin extends User implements Serializable
{

    public Admin(String user, String password) 
    {
        super(user, password);
    }
}

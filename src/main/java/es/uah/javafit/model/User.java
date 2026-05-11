/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.model;

/**
 *
 * @author razie
 */
public abstract class User 
{
    private String user;
    private String password;

    public User(String user, String password) 
    {
        this.user = user;
        this.password = password;
    }

    // getter y setter
    public String getUser() 
    {
        return user;
    }

    public void setUser(String user) 
    {
        this.user = user;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
    
    public boolean autenticator(String password)
    {
        // OBJ: revisa si la contraseña es correcta
        return password.equals(this.password);
    }
    
    @Override
    public String toString() 
    {
        return "Usuario{" + "user=" + user + '}';
    }
    
    
}

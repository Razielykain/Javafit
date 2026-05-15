package es.uah.javafit.persistence;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author razie
 */
public class JavaFitError extends Exception implements Serializable
{

    public JavaFitError(String message) 
    {
        super(message);
    }

}

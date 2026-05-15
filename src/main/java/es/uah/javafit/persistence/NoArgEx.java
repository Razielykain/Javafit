/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uah.javafit.persistence;

import java.io.Serializable;

/**
 *
 * @author razie
 */
public class NoArgEx extends Exception implements Serializable{

    public NoArgEx(String msg) {
        super(msg);
    }
    
}

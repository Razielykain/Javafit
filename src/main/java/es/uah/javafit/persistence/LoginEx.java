/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package es.uah.javafit.persistence;

/**
 *
 * @author razie
 */
public class LoginEx extends Exception {

    /**
     * Creates a new instance of <code>LoginEx</code> without detail message.
     */
    public LoginEx() {
    }

    /**
     * Constructs an instance of <code>LoginEx</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public LoginEx(String msg) {
        super(msg);
    }
}

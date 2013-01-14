/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author ak
 */
public class InvalidLocationException extends Exception {

    /**
     *
     * @param msg
     */
    public InvalidLocationException(String msg) {
        super(msg);
    }
}

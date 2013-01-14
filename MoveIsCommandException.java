/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author ak
 */
public class MoveIsCommandException extends InvalidLocationException {

    /**
     *
     * @param msg
     */
    public MoveIsCommandException(Command cmd) {
        super(cmd.getCommandString());
        this.command = cmd;

    }
    private Command command;

    /**
     *
     * @return
     */
    public Command getCommand() {
        return this.command;
    }
}

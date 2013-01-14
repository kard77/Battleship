package battleship;

import java.util.InputMismatchException;

/**
 *
 * @author ak
 */
public enum Command {

    /**
     *
     */
    HELP("help", "You have chosen to print the help menu.\n"
            + "List of available commands:\n"
            + "help, save, load, exit\n"
            + "Move selection:\n"
            + "A move can be entered in the form \"A5\", \"C13\", etc. "
            + "(without a gap between the letter and the number)"),
    /**
     *
     */
    SAVE("save", "You have chosen to save the current game.\n"),
    /**
     *
     */
    LOAD("load", "You have chosen to load a previously saved game.\n"),
    /**
     *
     */
    EXIT("exit", "You have chosen to exit the current game.\n");

    /**
     *
     * @param commandString
     * @param helpText
     */
    private Command(String commandString, String helpText) {
        this.commandString = commandString;
        this.helpText = helpText;
    }
    private String commandString;
    private String helpText;

    /**
     *
     * @param dirString
     * @return
     * @throws InputMismatchException
     */
    public static Command fromString(String dirString) throws InputMismatchException {
        switch (dirString) {
            case "help":
                return HELP;
            case "save":
                return SAVE;
            case "load":
                return LOAD;
            case "exit":
                return EXIT;
            default:
                throw new InputMismatchException("Invalid command.");
        }
    }
    
    
    /**
     *
     * @return
     */
    public String getCommandString() {
        return this.commandString;
    }   
    
    /**
     *
     * @return
     */
    public String getHelpText() {
        return this.helpText;
    }     
    
    
    
    
}

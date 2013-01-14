package battleship;

import java.util.InputMismatchException;

/**
 *
 * @author ak
 */
public enum ShipDirection {

    /**
     *
     */
    HORIZONTAL,
    /**
     *
     */
    VERTICAL;

    /**
     *
     * @param dirString
     * @return
     * @throws InputMismatchException
     */
    public static ShipDirection fromString(String dirString) throws InputMismatchException {
        if (dirString.equalsIgnoreCase("h")) {
            return HORIZONTAL;
        } else if (dirString.equalsIgnoreCase("v")){
            return VERTICAL;
        } else {
            throw new InputMismatchException();
        }
    }
}

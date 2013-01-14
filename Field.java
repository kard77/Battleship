package battleship;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ak
 */
public class Field {

    /**
     *
     * @param player
     * @param rows
     * @param cols
     */
    public Field(Player player, int rows, int cols) {
        this.player = player;
        this.rows = rows;
        this.cols = cols;
        this.grid = new Location[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Location();
                grid[i][j].setContent(".");
            }
        }
    }
    // 
    private int rows, cols, counter;
    private String input;
    private Location grid[][];
    static String letters[] = {"!", "A", "B", "C",
        "D", "E", "F", "G",
        "H", "I", "J", "K",
        "L", "M", "N", "O"};
    private Player player;
    Random generator = new Random(System.currentTimeMillis());

    /**
     *
     */
    public void printGrid() {

        System.out.println();
        System.out.printf("\n   ");
        for (int i = 0; i < cols; i++) {
            System.out.printf("%3d", i + 1);
        }
        System.out.printf("\n    ");
        for (int i = 0; i < cols; i++) {
            System.out.printf("---");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.printf("%2s| ", letters[i + 1]);
            for (int j = 0; j < cols; j++) {
                System.out.printf("%2s ", grid[i][j].getContent());
            }
            System.out.println();
        }
    }

    /**
     *
     * @param r
     * @param c
     * @return
     */
    public Location getLocation(int r, int c) {
        return grid[r][c];
    }

    /**
     *
     * @param locString
     * @return
     * @throws InvalidLocationException
     */
    public Location getLocation(String locString) throws InvalidLocationException {
        return null;
    }

    /**
     *
     * @param s
     * @param maxTries
     * @param checkMarked
     * @return
     */
    public boolean placeShipRandomly(Ship s, int maxTries, boolean checkMarked) {

        Location loc = new Location();
        if (maxTries == 0 && checkMarked == true) {

            do {
                counter = 1;
                loc.setRow(generator.nextInt(rows - 1));
                loc.setCol(generator.nextInt(cols - 1));

                if (grid[loc.getRow()][loc.getCol()].isEmpty()
                        || !(grid[loc.getRow()][loc.getCol()].isMarked())) {
                    if ((loc.getRow() + 1) < rows
                            && (grid[loc.getRow() + 1][loc.getCol()].isEmpty())
                            && !(grid[loc.getRow() + 1][loc.getCol()].isMarked())) {

                        for (int i = 1; i < s.getLength(); i++) {
                            if (((loc.getRow() + i) < rows)
                                    && (grid[loc.getRow() + i][loc.getCol()].isEmpty())
                                    && !(grid[loc.getRow() + i][loc.getCol()].isMarked())) {
                                counter++;
                            }
                        }

                        if (counter == s.getLength()) {

                            s.setStart(loc);
                            s.setDir(ShipDirection.VERTICAL);
                            grid[loc.getRow()][loc.getCol()] = loc;
                            loc.setShip(s);
                            loc.mark();
                            s.getShipPosition()[0] = loc;

                            switch (s.getLetter()) {
                                case "A":
                                    for (int i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow() + i][loc.getCol()].setContent("A");
                                        grid[loc.getRow() + i][loc.getCol()].setShip(s);
                                        grid[loc.getRow() + i][loc.getCol()].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                                    }
                                    break;
                                case "D":
                                    for (int i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow() + i][loc.getCol()].setContent("D");
                                        grid[loc.getRow() + i][loc.getCol()].setShip(s);
                                        grid[loc.getRow() + i][loc.getCol()].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                                    }
                                    break;
                                case "S":
                                    for (int i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow() + i][loc.getCol()].setContent("S");
                                        grid[loc.getRow() + i][loc.getCol()].setShip(s);
                                        grid[loc.getRow() + i][loc.getCol()].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                                    }
                                    break;
                            }
                        }
                    } else if ((loc.getCol() + 1) < cols
                            && (grid[loc.getRow()][loc.getCol() + 1].isEmpty())
                            && !(grid[loc.getRow()][loc.getCol() + 1].isMarked())) {

                        for (int i = 1; i < s.getLength(); i++) {
                            if (((loc.getCol() + i) < cols)
                                    && (grid[loc.getRow()][loc.getCol() + i].isEmpty())
                                    && !(grid[loc.getRow()][loc.getCol() + i].isMarked())) {
                                counter++;
                            }
                        }

                        if (counter == s.getLength()) {

                            s.setStart(loc);
                            s.setDir(ShipDirection.HORIZONTAL);
                            grid[loc.getRow()][loc.getCol()] = loc;
                            loc.setShip(s);
                            loc.mark();
                            s.getShipPosition()[0] = loc;

                            switch (s.getLetter()) {
                                case "A":
                                    for (int i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow()][loc.getCol() + i].setContent("A");
                                        grid[loc.getRow()][loc.getCol() + i].setShip(s);
                                        grid[loc.getRow()][loc.getCol() + i].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                                    }
                                    break;
                                case "D":
                                    for (int i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow()][loc.getCol() + i].setContent("D");
                                        grid[loc.getRow()][loc.getCol() + i].setShip(s);
                                        grid[loc.getRow()][loc.getCol() + i].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                                    }
                                    break;
                                case "S":
                                    for (int i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow()][loc.getCol() + i].setContent("S");
                                        grid[loc.getRow()][loc.getCol() + i].setShip(s);
                                        grid[loc.getRow()][loc.getCol() + i].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                                    }
                                    break;
                            }


                        }
                    } else {
                        continue;
                    }
                }
            } while (counter != s.getLength());

            return true;


        } else if (maxTries == 0 && checkMarked == false) {

            do {
                counter = 1;
                loc.setRow(generator.nextInt(rows - 1));
                loc.setCol(generator.nextInt(cols - 1));

                if (grid[loc.getRow()][loc.getCol()].isEmpty()) {
                    if (((loc.getRow() + 1) < rows)
                            && (grid[loc.getRow() + 1][loc.getCol()].isEmpty())) {

                        for (int i = 1; i < s.getLength(); i++) {
                            if (((loc.getRow() + i) < rows)
                                    && (grid[loc.getRow() + i][loc.getCol()].isEmpty())) {
                                counter++;
                            }
                        }

                        if (counter == s.getLength()) {

                            s.setStart(loc);
                            s.setDir(ShipDirection.VERTICAL);
                            grid[loc.getRow()][loc.getCol()] = loc;
                            loc.setShip(s);
                            loc.mark();
                            s.getShipPosition()[0] = loc;

                            switch (s.getLetter()) {
                                case "A":
                                    for (int i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow() + i][loc.getCol()].setContent("A");
                                        grid[loc.getRow() + i][loc.getCol()].setShip(s);
                                        grid[loc.getRow() + i][loc.getCol()].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                                    }
                                    break;
                                case "D":
                                    for (int i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow() + i][loc.getCol()].setContent("D");
                                        grid[loc.getRow() + i][loc.getCol()].setShip(s);
                                        grid[loc.getRow() + i][loc.getCol()].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                                    }
                                    break;
                                case "S":
                                    for (int i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow() + i][loc.getCol()].setContent("S");
                                        grid[loc.getRow() + i][loc.getCol()].setShip(s);
                                        grid[loc.getRow() + i][loc.getCol()].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                                    }
                                    break;
                            }
                        }
                    } else if (((loc.getCol() + 1) < cols)
                            && (grid[loc.getRow()][loc.getCol() + 1].isEmpty())) {

                        for (int i = 1; i < s.getLength(); i++) {
                            if (((loc.getCol() + i) < cols)
                                    && (grid[loc.getRow()][loc.getCol() + i].isEmpty())) {
                                counter++;
                            }
                        }

                        if (counter == s.getLength()) {

                            s.setStart(loc);
                            s.setDir(ShipDirection.HORIZONTAL);
                            grid[loc.getRow()][loc.getCol()] = loc;
                            loc.setShip(s);
                            loc.mark();
                            s.getShipPosition()[0] = loc;

                            switch (s.getLetter()) {
                                case "A":
                                    for (int i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow()][loc.getCol() + i].setContent("A");
                                        grid[loc.getRow()][loc.getCol() + i].setShip(s);
                                        grid[loc.getRow()][loc.getCol() + i].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                                    }
                                    break;
                                case "D":
                                    for (int i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow()][loc.getCol() + i].setContent("D");
                                        grid[loc.getRow()][loc.getCol() + i].setShip(s);
                                        grid[loc.getRow()][loc.getCol() + i].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                                    }
                                    break;
                                case "S":
                                    for (int i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow()][loc.getCol() + i].setContent("S");
                                        grid[loc.getRow()][loc.getCol() + i].setShip(s);
                                        grid[loc.getRow()][loc.getCol() + i].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                                    }
                                    break;
                            }


                        }
                    } else {
                        continue;
                    }
                }
            } while (counter != s.getLength());

            return true;

        } else if (maxTries != 0 && checkMarked == true) {

            for (int i = 0; i < maxTries; i++) {
                counter = 1;
                loc.setRow(generator.nextInt(rows - 1));
                loc.setCol(generator.nextInt(cols - 1));

                if (grid[loc.getRow()][loc.getCol()].isEmpty()
                        || !(grid[loc.getRow()][loc.getCol()].isMarked())) {
                    if ((loc.getRow() + 1) < rows
                            && (grid[loc.getRow() + 1][loc.getCol()].isEmpty())
                            && !(grid[loc.getRow() + 1][loc.getCol()].isMarked())) {

                        for (i = 1; i < s.getLength(); i++) {
                            if (((loc.getRow() + i) < rows)
                                    && (grid[loc.getRow() + i][loc.getCol()].isEmpty())
                                    && !(grid[loc.getRow() + i][loc.getCol()].isMarked())) {
                                counter++;
                            }
                        }

                        if (counter == s.getLength()) {

                            s.setStart(loc);
                            s.setDir(ShipDirection.VERTICAL);
                            grid[loc.getRow()][loc.getCol()] = loc;
                            loc.setShip(s);
                            loc.mark();
                            s.getShipPosition()[0] = loc;

                            switch (s.getLetter()) {
                                case "A":
                                    for (i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow() + i][loc.getCol()].setContent("A");
                                        grid[loc.getRow() + i][loc.getCol()].setShip(s);
                                        grid[loc.getRow() + i][loc.getCol()].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                                    }
                                    break;
                                case "D":
                                    for (i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow() + i][loc.getCol()].setContent("D");
                                        grid[loc.getRow() + i][loc.getCol()].setShip(s);
                                        grid[loc.getRow() + i][loc.getCol()].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                                    }
                                    break;
                                case "S":
                                    for (i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow() + i][loc.getCol()].setContent("S");
                                        grid[loc.getRow() + i][loc.getCol()].setShip(s);
                                        grid[loc.getRow() + i][loc.getCol()].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                                    }
                                    break;
                            }
                        } else {
                            continue;
                        }
                    } else if ((loc.getCol() + 1) < cols
                            && (grid[loc.getRow()][loc.getCol() + 1].isEmpty())
                            && !(grid[loc.getRow()][loc.getCol() + 1].isMarked())) {

                        for (i = 1; i < s.getLength(); i++) {
                            if (((loc.getCol() + i) < cols)
                                    && (grid[loc.getRow()][loc.getCol() + i].isEmpty())
                                    && !(grid[loc.getRow()][loc.getCol() + i].isMarked())) {
                                counter++;
                            }
                        }

                        if (counter == s.getLength()) {

                            s.setStart(loc);
                            s.setDir(ShipDirection.HORIZONTAL);
                            grid[loc.getRow()][loc.getCol()] = loc;
                            loc.setShip(s);
                            loc.mark();
                            s.getShipPosition()[0] = loc;

                            switch (s.getLetter()) {
                                case "A":
                                    for (i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow()][loc.getCol() + i].setContent("A");
                                        grid[loc.getRow()][loc.getCol() + i].setShip(s);
                                        grid[loc.getRow()][loc.getCol() + i].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                                    }
                                    break;
                                case "D":
                                    for (i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow()][loc.getCol() + i].setContent("D");
                                        grid[loc.getRow()][loc.getCol() + i].setShip(s);
                                        grid[loc.getRow()][loc.getCol() + i].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                                    }
                                    break;
                                case "S":
                                    for (i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow()][loc.getCol() + i].setContent("S");
                                        grid[loc.getRow()][loc.getCol() + i].setShip(s);
                                        grid[loc.getRow()][loc.getCol() + i].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                                    }
                                    break;
                            }
                            return true;

                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }

            return false;

        } else { // maxTries != 0 && checkMarked == false


            for (int i = 0; i < maxTries; i++) {
                counter = 1;
                loc.setRow(generator.nextInt(rows - 1));
                loc.setCol(generator.nextInt(cols - 1));

                if (grid[loc.getRow()][loc.getCol()].isEmpty()) {
                    if ((loc.getRow() + 1) < rows
                            && (grid[loc.getRow() + 1][loc.getCol()].isEmpty())) {

                        for (i = 1; i < s.getLength(); i++) {
                            if (((loc.getRow() + i) < rows)
                                    && (grid[loc.getRow() + i][loc.getCol()].isEmpty())) {
                                counter++;
                            }
                        }

                        if (counter == s.getLength()) {

                            s.setStart(loc);
                            s.setDir(ShipDirection.VERTICAL);
                            grid[loc.getRow()][loc.getCol()] = loc;
                            loc.setShip(s);
                            loc.mark();
                            s.getShipPosition()[0] = loc;

                            switch (s.getLetter()) {
                                case "A":
                                    for (i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow() + i][loc.getCol()].setContent("A");
                                        grid[loc.getRow() + i][loc.getCol()].setShip(s);
                                        grid[loc.getRow() + i][loc.getCol()].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                                    }
                                    break;
                                case "D":
                                    for (i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow() + i][loc.getCol()].setContent("D");
                                        grid[loc.getRow() + i][loc.getCol()].setShip(s);
                                        grid[loc.getRow() + i][loc.getCol()].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                                    }
                                    break;
                                case "S":
                                    for (i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow() + i][loc.getCol()].setContent("S");
                                        grid[loc.getRow() + i][loc.getCol()].setShip(s);
                                        grid[loc.getRow() + i][loc.getCol()].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                                    }
                                    break;
                            }
                        } else {
                            continue;
                        }
                    } else if ((loc.getCol() + 1) < cols
                            && (grid[loc.getRow()][loc.getCol() + 1].isEmpty())) {

                        for (i = 1; i < s.getLength(); i++) {
                            if (((loc.getCol() + i) < cols)
                                    && (grid[loc.getRow()][loc.getCol() + i].isEmpty())) {
                                counter++;
                            }
                        }

                        if (counter == s.getLength()) {

                            s.setStart(loc);
                            s.setDir(ShipDirection.HORIZONTAL);
                            grid[loc.getRow()][loc.getCol()] = loc;
                            loc.setShip(s);
                            loc.mark();
                            s.getShipPosition()[0] = loc;

                            switch (s.getLetter()) {
                                case "A":
                                    for (i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow()][loc.getCol() + i].setContent("A");
                                        grid[loc.getRow()][loc.getCol() + i].setShip(s);
                                        grid[loc.getRow()][loc.getCol() + i].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                                    }
                                    break;
                                case "D":
                                    for (i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow()][loc.getCol() + i].setContent("D");
                                        grid[loc.getRow()][loc.getCol() + i].setShip(s);
                                        grid[loc.getRow()][loc.getCol() + i].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                                    }
                                    break;
                                case "S":
                                    for (i = 0; i < s.getLength(); i++) {
                                        grid[loc.getRow()][loc.getCol() + i].setContent("S");
                                        grid[loc.getRow()][loc.getCol() + i].setShip(s);
                                        grid[loc.getRow()][loc.getCol() + i].mark();
                                        s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                                    }
                                    break;
                            }
                            return true;

                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }

            return false;

        }


    }

    /**
     *
     * @param s
     * @param checkMarked
     * @return
     */
    public boolean placeShip(Ship s, boolean checkMarked) {

        Location loc = new Location();
        if (checkMarked == true) {

            do {
                counter = 1;
                int colNumber;
                int rowNumber;

                do {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("\nPlease enter valid location for the "
                            + "prow of a " + s.getLetter() + ": (π.χ. B10) ");
                    char ch = scan.findInLine(".").charAt(0);
                    colNumber = scan.nextInt();

                    switch (ch) {
                        case 'A':
                            rowNumber = 0;
                            break;
                        case 'B':
                            rowNumber = 1;
                            break;
                        case 'C':
                            rowNumber = 2;
                            break;
                        case 'D':
                            rowNumber = 3;
                            break;
                        case 'E':
                            rowNumber = 4;
                            break;
                        case 'F':
                            rowNumber = 5;
                            break;
                        case 'G':
                            rowNumber = 6;
                            break;
                        case 'H':
                            rowNumber = 7;
                            break;
                        case 'I':
                            rowNumber = 8;
                            break;
                        case 'J':
                            rowNumber = 9;
                            break;
                        case 'K':
                            rowNumber = 10;
                            break;
                        case 'L':
                            rowNumber = 11;
                            break;
                        case 'M':
                            rowNumber = 12;
                            break;
                        case 'N':
                            rowNumber = 13;
                            break;
                        case 'O':
                            rowNumber = 14;
                            break;
                        default:
                            rowNumber = -1;
                    }

                } while ((rowNumber > 0 && rowNumber < this.rows)
                        && (colNumber > 0 && colNumber < this.cols)
                        && !(grid[rowNumber][colNumber - 1].isEmpty())
                        && grid[rowNumber][colNumber - 1].isMarked());


                loc.setRow(rowNumber);
                loc.setCol(colNumber - 1);




                do {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("\nPlease give ship direction [v/h]: ");
                    String choice = scan.nextLine();
                    this.input = choice;

                } while (!(input.equals("v"))
                        && !(input.equals("h"))
                        && !(input.equals("V"))
                        && !(input.equals("H")));

                if (input.equals("v") || input.equals("V")) {
                    s.setDir(ShipDirection.VERTICAL);
                } else {
                    s.setDir(ShipDirection.HORIZONTAL);
                }





                if (s.getDir() == ShipDirection.VERTICAL) {
                    for (int i = 1; i < s.getLength(); i++) {
                        if (((loc.getRow() + i) < rows)
                                && (grid[loc.getRow() + i][loc.getCol()].isEmpty())
                                && !(grid[loc.getRow() + i][loc.getCol()].isMarked())) {
                            counter++;
                        }
                    }
                } else {
                    for (int i = 1; i < s.getLength(); i++) {
                        if (((loc.getCol() + i) < cols)
                                && (grid[loc.getRow()][loc.getCol() + i].isEmpty())
                                && !(grid[loc.getRow()][loc.getCol() + i].isMarked())) {
                            counter++;
                        }
                    }
                }

            } while (counter != s.getLength());


            s.setStart(loc);
            grid[loc.getRow()][loc.getCol()] = loc;
            loc.setShip(s);
            loc.mark();
            s.getShipPosition()[0] = loc;


            if (s.getDir() == ShipDirection.VERTICAL) {
                switch (s.getLetter()) {
                    case "A":
                        for (int i = 0; i < s.getLength(); i++) {

                            grid[loc.getRow() - i][loc.getCol()].setContent("A");
                            grid[loc.getRow() - i][loc.getCol()].setShip(s);
                            grid[loc.getRow() - i][loc.getCol()].mark();
                            s.getShipPosition()[i] = grid[loc.getRow() - i][loc.getCol()];
                        }
                        break;
                    case "D":
                        for (int i = 0; i < s.getLength(); i++) {
                            grid[loc.getRow() - i][loc.getCol()].setContent("D");
                            grid[loc.getRow() - i][loc.getCol()].setShip(s);
                            grid[loc.getRow() - i][loc.getCol()].mark();
                            s.getShipPosition()[i] = grid[loc.getRow() - i][loc.getCol()];
                        }
                        break;
                    case "S":
                        for (int i = 0; i < s.getLength(); i++) {
                            grid[loc.getRow() - i][loc.getCol()].setContent("S");
                            grid[loc.getRow() - i][loc.getCol()].setShip(s);
                            grid[loc.getRow() - i][loc.getCol()].mark();
                            s.getShipPosition()[i] = grid[loc.getRow() - i][loc.getCol()];
                        }
                        break;
                }
            } else {
                switch (s.getLetter()) {
                    case "A":
                        for (int i = 0; i < s.getLength(); i++) {
                            grid[loc.getRow()][loc.getCol() + i].setContent("A");
                            grid[loc.getRow()][loc.getCol() + i].setShip(s);
                            grid[loc.getRow()][loc.getCol() + i].mark();
                            s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                        }
                        break;
                    case "D":
                        for (int i = 0; i < s.getLength(); i++) {
                            grid[loc.getRow()][loc.getCol() + i].setContent("D");
                            grid[loc.getRow()][loc.getCol() + i].setShip(s);
                            grid[loc.getRow()][loc.getCol() + i].mark();
                            s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                        }
                        break;
                    case "S":
                        for (int i = 0; i < s.getLength(); i++) {
                            grid[loc.getRow()][loc.getCol() + i].setContent("S");
                            grid[loc.getRow()][loc.getCol() + i].setShip(s);
                            grid[loc.getRow()][loc.getCol() + i].mark();
                            s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                        }
                        break;
                }
            }




            return true;


        } else { // checkMarked == false
            do {
                counter = 1;
                int colNumber;
                int rowNumber;

                do {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("\nPlease enter valid location for the "
                            + "prow of a " + s.getLetter() + ": (π.χ. B10) ");
                    char ch = scan.findInLine(".").charAt(0);
                    System.out.println(ch);
                    colNumber = scan.nextInt();
                    System.out.println(colNumber);

                    switch (ch) {
                        case 'A':
                            rowNumber = 0;
                            break;
                        case 'B':
                            rowNumber = 1;
                            break;
                        case 'C':
                            rowNumber = 2;
                            break;
                        case 'D':
                            rowNumber = 3;
                            break;
                        case 'E':
                            rowNumber = 4;
                            break;
                        case 'F':
                            rowNumber = 5;
                            break;
                        case 'G':
                            rowNumber = 6;
                            break;
                        case 'H':
                            rowNumber = 7;
                            break;
                        case 'I':
                            rowNumber = 8;
                            break;
                        case 'J':
                            rowNumber = 9;
                            break;
                        case 'K':
                            rowNumber = 10;
                            break;
                        case 'L':
                            rowNumber = 11;
                            break;
                        case 'M':
                            rowNumber = 12;
                            break;
                        case 'N':
                            rowNumber = 13;
                            break;
                        case 'O':
                            rowNumber = 14;
                            break;
                        default:
                            rowNumber = -1;
                    }

                } while ((rowNumber > 0 && rowNumber < this.rows)
                        && (colNumber > 0 && colNumber < this.cols)
                        && !(grid[rowNumber][colNumber - 1].isEmpty()));


                loc.setRow(rowNumber);
                loc.setCol(colNumber - 1);




                do {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("\nPlease give ship direction [v/h]: ");
                    String choice = scan.nextLine();
                    this.input = choice;

                } while (!(input.equals("v"))
                        && !(input.equals("h"))
                        && !(input.equals("V"))
                        && !(input.equals("H")));

                if (input.equals("v") || input.equals("V")) {
                    s.setDir(ShipDirection.VERTICAL);
                } else {
                    s.setDir(ShipDirection.HORIZONTAL);
                }





                if (s.getDir() == ShipDirection.VERTICAL) {
                    for (int i = 1; i < s.getLength(); i++) {
                        if (((loc.getRow() + i) < rows)
                                && (grid[loc.getRow() + i][loc.getCol()].isEmpty())) {
                            counter++;
                        }
                    }
                } else {
                    for (int i = 1; i < s.getLength(); i++) {
                        if (((loc.getCol() + i) < cols)
                                && (grid[loc.getRow()][loc.getCol() + i].isEmpty())) {
                            counter++;
                        }
                    }
                }

            } while (counter != s.getLength());


            s.setStart(loc);
            grid[loc.getRow()][loc.getCol()] = loc;
            loc.setShip(s);
            loc.mark();
            s.getShipPosition()[0] = loc;


            if (s.getDir() == ShipDirection.VERTICAL) {
                switch (s.getLetter()) {
                    case "A":
                        for (int i = 0; i < s.getLength(); i++) {
                            grid[loc.getRow() + i][loc.getCol()].setContent("A");
                            grid[loc.getRow() + i][loc.getCol()].setShip(s);
                            grid[loc.getRow() + i][loc.getCol()].mark();
                            s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                        }
                        break;
                    case "D":
                        for (int i = 0; i < s.getLength(); i++) {
                            grid[loc.getRow() + i][loc.getCol()].setContent("D");
                            grid[loc.getRow() + i][loc.getCol()].setShip(s);
                            grid[loc.getRow() + i][loc.getCol()].mark();
                            s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                        }
                        break;
                    case "S":
                        for (int i = 0; i < s.getLength(); i++) {
                            grid[loc.getRow() + i][loc.getCol()].setContent("S");
                            grid[loc.getRow() + i][loc.getCol()].setShip(s);
                            grid[loc.getRow() + i][loc.getCol()].mark();
                            s.getShipPosition()[i] = grid[loc.getRow() + i][loc.getCol()];
                        }
                        break;
                }
            } else {
                switch (s.getLetter()) {
                    case "A":
                        for (int i = 0; i < s.getLength(); i++) {
                            grid[loc.getRow()][loc.getCol() + i].setContent("A");
                            grid[loc.getRow()][loc.getCol() + i].setShip(s);
                            grid[loc.getRow()][loc.getCol() + i].mark();
                            s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                        }
                        break;
                    case "D":
                        for (int i = 0; i < s.getLength(); i++) {
                            grid[loc.getRow()][loc.getCol() + i].setContent("D");
                            grid[loc.getRow()][loc.getCol() + i].setShip(s);
                            grid[loc.getRow()][loc.getCol() + i].mark();
                            s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                        }
                        break;
                    case "S":
                        for (int i = 0; i < s.getLength(); i++) {
                            grid[loc.getRow()][loc.getCol() + i].setContent("S");
                            grid[loc.getRow()][loc.getCol() + i].setShip(s);
                            grid[loc.getRow()][loc.getCol() + i].mark();
                            s.getShipPosition()[i] = grid[loc.getRow()][loc.getCol() + i];
                        }
                        break;
                }
            }
            return true;

        }


    }

    /**
     *
     * @param s
     */
    public void removeShip(Ship s) {
        //
    }

    /**
     *
     * @param moveLoc
     */
    public void processValidMove(Location moveLoc) {
        if (this.player.equals(this.player.game.getPlayer1())) {


            if (this.player.game.getPlayer2().field.grid[moveLoc.getRow()][moveLoc.getCol()].isEmpty()) {
                grid[moveLoc.getRow()][moveLoc.getCol()].setContent("o");
                grid[moveLoc.getRow()][moveLoc.getCol()].mark();

                /* Let's threaten some ships */
                for (Ship s : this.player.game.getPlayer2().fleet) {


                    for (int i = 0; i < 4; i++) {

                        if ((moveLoc.getRow() + i < this.rows)) {
                            s = this.player.game.getPlayer2().field.grid[moveLoc.getRow() + i][moveLoc.getCol()].getShip();

                            if (s != null) {
                                s.threaten();
                            }
                        }
                        if ((moveLoc.getRow() - i > 0)) {
                            s = this.player.game.getPlayer2().field.grid[moveLoc.getRow() - i][moveLoc.getCol()].getShip();

                            if (s != null) {
                                s.threaten();
                            }
                        }
                        if ((moveLoc.getCol() + i < this.cols)) {
                            s = this.player.game.getPlayer2().field.grid[moveLoc.getRow()][moveLoc.getCol() + i].getShip();

                            if (s != null) {
                                s.threaten();
                            }
                        }
                        if ((moveLoc.getCol() - i > 0)) {
                            s = this.player.game.getPlayer2().field.grid[moveLoc.getRow()][moveLoc.getCol() - i].getShip();

                            if (s != null) {
                                s.threaten();
                            }

                        }
                    }
                }
            } else { // not empty loc


                switch (this.player.game.getPlayer2().field.grid[moveLoc.getRow()][moveLoc.getCol()].getShip().getLetter()) {

                    case "A":
                        grid[moveLoc.getRow()][moveLoc.getCol()].setContent("x");
                        grid[moveLoc.getRow()][moveLoc.getCol()].mark();

                        for (int i = 0; i < this.player.game.getPlayer2().field.grid[moveLoc.getRow()][moveLoc.getCol()].getShip().getLength(); i++) {                  
                            this.player.game.getPlayer2().field.grid[moveLoc.getRow()][moveLoc.getCol()].getShip().getShipPosition()[i].hit();                       
                        }

                    case "D":
                        grid[moveLoc.getRow()][moveLoc.getCol()].setContent("x");
                        grid[moveLoc.getRow()][moveLoc.getCol()].mark();

                        for (int i = 0; i < this.player.game.getPlayer2().field.grid[moveLoc.getRow()][moveLoc.getCol()].getShip().getLength(); i++) {                  
                            this.player.game.getPlayer2().field.grid[moveLoc.getRow()][moveLoc.getCol()].getShip().getShipPosition()[i].hit();                       
                        }
                    case "S":
                        grid[moveLoc.getRow()][moveLoc.getCol()].setContent("x");
                        grid[moveLoc.getRow()][moveLoc.getCol()].mark();

                        for (int i = 0; i < this.player.game.getPlayer2().field.grid[moveLoc.getRow()][moveLoc.getCol()].getShip().getLength(); i++) {                  
                            this.player.game.getPlayer2().field.grid[moveLoc.getRow()][moveLoc.getCol()].getShip().getShipPosition()[i].hit();                       
                        }



                }

                /* Let's threaten some ships */
                for (Ship s : this.player.game.getPlayer2().fleet) {


                    for (int i = 0; i < 4; i++) {

                        if ((moveLoc.getRow() + i < this.rows)) {
                            s = this.player.game.getPlayer2().field.grid[moveLoc.getRow() + i][moveLoc.getCol()].getShip();

                            if (s != null) {
                                s.threaten();
                            }
                        }
                        if ((moveLoc.getRow() - i > 0)) {
                            s = this.player.game.getPlayer2().field.grid[moveLoc.getRow() - i][moveLoc.getCol()].getShip();

                            if (s != null) {
                                s.threaten();
                            }
                        }
                        if ((moveLoc.getCol() + i < this.cols)) {
                            s = this.player.game.getPlayer2().field.grid[moveLoc.getRow()][moveLoc.getCol() + i].getShip();

                            if (s != null) {
                                s.threaten();
                            }
                        }
                        if ((moveLoc.getCol() - i > 0)) {
                            s = this.player.game.getPlayer2().field.grid[moveLoc.getRow()][moveLoc.getCol() - i].getShip();

                            if (s != null) {
                                s.threaten();
                            }

                        }
                    }
                }
            }
        } else { // player 2 plays
            
        }
    }

    @Override
    public String toString() {
        return null;
    }

    /**
     *
     * @return
     */
    public String toStringWithShips() {
        return null;
    }

    /**
     *
     * @param rows
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     *
     * @param cols
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

    /**
     *
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     *
     * @return
     */
    public int getRows() {
        return this.rows;
    }

    /**
     *
     * @return
     */
    public int getCols() {
        return this.cols;
    }

    /**
     *
     * @return
     */
    public Player getPlayer() {
        return this.player;
    }
}

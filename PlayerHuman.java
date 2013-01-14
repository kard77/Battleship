/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Scanner;

/**
 *
 * @author ak
 */
public class PlayerHuman extends Player {

    /**
     *
     * @param r
     * @param c
     */
    @Override
    public void initField(int r, int c) {
        this.field = new Field(this, r, c);
        this.otherField = new Field(this, r, c);

        System.out.println("What " + name + " sees:");
        printField();

    }

    /**
     *
     * @return
     */
    @Override
    public Location selectMove() throws InvalidLocationException {
        Location loc = new Location();
        int colNumber, rowNumber;
        String input;




        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease target a valid location (e.g. B10): ");
        input = scan.nextLine();

        if (input.equals("help")
                || input.equals("exit")
                || input.equals("save")
                || input.equals("load")) {

            switch (input) {
                case "help":
                    throw new MoveIsCommandException(Command.HELP);

                case "exit":
                    throw new MoveIsCommandException(Command.EXIT);

                case "save":
                    throw new MoveIsCommandException(Command.SAVE);

                case "load":
                    throw new MoveIsCommandException(Command.LOAD);

            }
            return null;

        } else {
            char ch = input.charAt(0);
            Scanner sc = new Scanner(input.substring(1));


            colNumber = sc.nextInt();

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
                    throw new InvalidLocationException("Invalid move");
            }

            if (rowNumber > 0 && rowNumber < otherField.getRows()
                    && colNumber > 0 && colNumber < otherField.getCols()
                    && !(otherField.getLocation(rowNumber, colNumber - 1).isMarked())) {

                loc.setRow(rowNumber);
                loc.setCol(colNumber - 1);

                return loc;

            } else {
                throw new InvalidLocationException("Invalid move.");
            }

        }




    }

    /**
     *
     * @param otherField
     */
    @Override
    public void placeShips(Field otherField) {
        String input;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n" + name + " do you want to place the ships yourself? [y/n]: ");
            input = scan.nextLine();

        } while (!(input.equals("y"))
                && !(input.equals("n"))
                && !(input.equals("Y"))
                && !(input.equals("N")));

        if (input.equals("y") || input.equals("Y")) {
            for (Ship s : fleet) {
                otherField.placeShip(s, false);
                field.printGrid();
            }
            System.out.println("All the ships are in place.");
        } else {
            for (Ship s : fleet) {
                otherField.placeShipRandomly(s, 0, false);

            }
            field.printGrid();
            System.out.println("All the ships are in place.");
        }

    }
}

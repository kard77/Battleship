/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ak
 */
public class Game {

    private String input;
    private int rows;
    private int cols;
    private int maxRounds;
    private Player player1;
    private Player player2;
    Random generator = new Random(System.currentTimeMillis());

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
     * @return
     */
    public int getRows() {
        return this.rows;
    }

    /**
     *
     * @return
     */
    public boolean isPlayer1() {
        return true;
    }

    /**
     *
     * @return
     */
    public Player getPlayer1() {
        return this.player1;
    }

    /**
     *
     * @return
     */
    public Player getPlayer2() {
        return this.player2;
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
    public boolean init() {
        do {
            System.out.println("\n**************\n");
            System.out.println("* BATTLESHIP *\n");
            System.out.println("**************\n");
            System.out.println("\nBy Apostolis Kardiasmenos (2013)\n");

            Scanner scan = new Scanner(System.in);
            System.out.println("\nDo you want to play? [y/n]: ");
            String choice = scan.nextLine();
            this.input = choice;
        } while (!(input.equals("y"))
                && !(input.equals("n"))
                && !(input.equals("Y"))
                && !(input.equals("N")));

        if (input.equals("y") || input.equals("Y")) {
            do {
                Scanner scan = new Scanner(System.in);
                System.out.println("\nPlease enter number of field rows [10-15]: ");
                this.setRows(scan.nextInt());
            } while (this.getRows() < 10
                    || this.getRows() > 15);

            do {
                Scanner scan = new Scanner(System.in);
                System.out.println("\nPlease enter number of field columns [10-15]: ");
                this.setCols(scan.nextInt());
            } while (this.getCols() < 10
                    || this.getCols() > 15);

            do {
                Scanner scan = new Scanner(System.in);
                System.out.println("\nWill the first player be human? [y/n]: ");
                String choice = scan.nextLine();
                this.input = choice;
            } while (!(input.equals("y"))
                    && !(input.equals("n"))
                    && !(input.equals("Y"))
                    && !(input.equals("N")));

            if (input.equals("y") || input.equals("Y")) {
                this.player1 = new PlayerHuman();
                this.player1.setGame(this);
            } else {
                this.player1 = new PlayerComputer();
                this.player1.setGame(this);
            }

            Scanner scan = new Scanner(System.in);
            System.out.println("\nPlease enter the name of the first player: ");
            player1.setName(scan.nextLine());
            player1.initField(rows, cols);


            do {
                System.out.println("\nWill the second player be human? [y/n]: ");
                String choice = scan.nextLine();
                this.input = choice;
            } while (!(input.equals("y"))
                    && !(input.equals("n"))
                    && !(input.equals("Y"))
                    && !(input.equals("N")));

            if (input.equals("y") || input.equals("Y")) {
                this.player2 = new PlayerHuman();
                this.player2.setGame(this);
            } else {
                this.player2 = new PlayerComputer();
                this.player2.setGame(this);
            }

            System.out.println("\nPlease enter the name of the second player: ");
            player2.setName(scan.nextLine());
            player2.initField(rows, cols);

            do {
                System.out.println("\nPlease enter number of maximum game rounds. "
                        + "Enter '0' for no limit in game rounds: ");
                int choice = scan.nextInt();
                this.maxRounds = choice;
            } while (maxRounds < 0);

            return false;
        } else {
            return true;
        }
    }

    /**
     *
     */
    public void placeShips() {
        player1.placeShips(player1.field);
        player2.placeShips(player2.field);
    }

    /**
     *
     */
    public boolean play(int turn) {


        if (turn == 0) {


            player1.printField();
            try {
                player1.field.processValidMove(player1.selectMove());
                
            } catch (MoveIsCommandException e) {
                switch (e.getCommand().getCommandString()) {
                    case "help":
                        System.out.println(e.getCommand().getHelpText());
                        break;
                    case "exit":
                        System.out.println(e.getCommand().getHelpText());
                        System.exit(0);
                    case "save":
                        System.out.println(e.getCommand().getHelpText());
                        System.exit(0);
                    case "load":
                        System.out.println(e.getCommand().getHelpText());
                        System.exit(0);
                }

            } catch (InvalidLocationException ex) {
                System.out.println("Invalid location.");
                return false;
            }

            if (player1.hasWon() == true) {
//                System.out.println("Congrats " + player1.getName() + "! You have won the game!");
                return true;
            } 

            player2.printField();
            try {
                player2.field.processValidMove(player2.selectMove());
            } catch (MoveIsCommandException e) {
                switch (e.getCommand().getCommandString()) {
                    case "help":
                        System.out.println(e.getCommand().getHelpText());
                        break;
                    case "exit":
                        System.out.println(e.getCommand().getHelpText());
                        System.exit(0);
                    case "save":
                        System.out.println(e.getCommand().getHelpText());
                        System.exit(0);
                    case "load":
                        System.out.println(e.getCommand().getHelpText());
                        System.exit(0);
                }
            } catch (InvalidLocationException ex) {
                System.out.println("Invalid location.");
                return false;
            }

            if (player2.hasWon() == true) {
//                System.out.println("Congrats " + player2.getName() + "! You have won the game!");
                return true;
            } 


        } else {

            player2.printField();
            try {
                player2.field.processValidMove(player2.selectMove());
            } catch (MoveIsCommandException e) {
                switch (e.getCommand().getCommandString()) {
                    case "help":
                        System.out.println(e.getCommand().getHelpText());
                        break;
                    case "exit":
                        System.out.println(e.getCommand().getHelpText());
                        System.exit(0);
                    case "save":
                        System.out.println(e.getCommand().getHelpText());
                        System.exit(0);
                    case "load":
                        System.out.println(e.getCommand().getHelpText());
                        System.exit(0);
                }
            } catch (InvalidLocationException ex) {
                System.out.println("Invalid location.");
                return false;
            }

            if (player2.hasWon() == true) {
//                System.out.println("Congrats " + player1.getName() + "! You have won the game!");
                return true;
            }

            player1.printField();
            try {
                player1.field.processValidMove(player1.selectMove());
            } catch (MoveIsCommandException e) {


                switch (e.getCommand().getCommandString()) {
                    case "help":
                        System.out.println(e.getCommand().getHelpText());
                        break;
                    case "exit":
                        System.out.println(e.getCommand().getHelpText());
                        System.exit(0);
                    case "save":
                        System.out.println(e.getCommand().getHelpText());
                        System.exit(0);
                    case "load":
                        System.out.println(e.getCommand().getHelpText());
                        System.exit(0);
                }
            } catch (InvalidLocationException ex) {
                System.out.println("Invalid location.");
                return false;
            }

            if (player1.hasWon() == true) {
//                System.out.println("Congrats " + player2.getName() + "! You have won the game!");
                return true;
            }
        }
        return false;
    }

    /**
     *
     */
    public void showResult() {
    }
}

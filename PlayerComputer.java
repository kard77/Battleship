package battleship;

import java.util.Random;

/**
 *
 * @author ak
 */
public class PlayerComputer extends Player {

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
    public Location selectMove() {
        Random generator = new Random(System.currentTimeMillis());
        Location loc = new Location();
        int colNumber, rowNumber;
        do {


            rowNumber = generator.nextInt(otherField.getRows() - 1);
            colNumber = generator.nextInt(otherField.getCols() - 1);



        } while ((rowNumber > 0 && rowNumber < otherField.getRows())
                && (colNumber > 0 && colNumber < otherField.getCols())
                && !(otherField.getLocation(rowNumber, colNumber - 1).isEmpty())
                && otherField.getLocation(rowNumber, colNumber - 1).isMarked());


        loc.setRow(rowNumber);
        loc.setCol(colNumber);


        return loc;


    }

    /**
     *
     * @param otherField
     */
    @Override
    public void placeShips(Field otherField) {
        for (Ship s : fleet) {
            otherField.placeShipRandomly(s, 0, false);
        }
        field.printGrid();
        System.out.println("All the ships are in place.");
    }
}

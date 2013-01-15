package battleship;

/**
 *
 * @author ak
 */
public class Destroyer extends Ship {

    /**
     *
     * @param length
     * @param points
     * @param letter
     * @param field
     */
    public Destroyer(int length, int points, String letter, Field field) {
        super(length, points, letter, field);
    }
    private Location[] shipPosition = new Location[3];

    /**
     *
     */
    @Override
    public Location[] getShipPosition() {
        return this.shipPosition;
    }

    /**
     *
     */
    @Override
    public void hit(Location loc) {
        for (int i = 0; i < 3; i++) {
            if (loc == shipPosition[i]) {
                this.shipPosition[i].hit();
                getHitMessage();
            }
        }
    }

    /**
     *
     */
    @Override
    public boolean isHit() {
        for (int i = 0; i < 3; i++) {
            if (this.shipPosition[i].isHit()) {
                return true;
            }
        }
        return false;


    }

    /**
     *
     */
    @Override
    public boolean isSinking() {
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            if (this.shipPosition[i].isHit()) {
                counter++;
            } 
        }

        if (counter == 3) {
            getSinkMessage();
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     */
    @Override
    public void getHitMessage() {
        System.out.println("Destroyer is hit!");
    }

    /**
     *
     */
    @Override
    public void getSinkMessage() {
        System.out.println("Destroyer is sinking!");
    }

    /**
     *
     */
    @Override
    public void threaten() {
    }
}

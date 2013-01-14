package battleship;

/**
 *
 * @author ak
 */
public class AircraftCarrier extends Ship {

    /**
     *
     * @param length
     * @param points
     * @param letter
     * @param field
     */
    public AircraftCarrier(int length, int points, String letter, Field field) {
        super(length, points, letter, field);
    }

    
    
    
    
    
    private Location[] shipPosition = new Location[5];

    
    
    
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
        for (int i = 0; i < 5; i++) {
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
        for (int i = 0; i < 5; i++) {
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
    public void getHitMessage() {
    }

    /**
     *
     */
    @Override
    public void getSinkMessage() {
    }

    /**
     *
     */
    @Override
    public void threaten() {
    }
}

package battleship;

/**
 *
 * @author ak
 */
public class Submarine extends Ship {

    /**
     *
     * @param length
     * @param points
     * @param letter
     * @param field
     */
    public Submarine(int length, int points, String letter, Field field) {
        super(length, points, letter, field);
    }
    
    private Location[] shipPosition = new Location[1];
    
    
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
        if (loc == shipPosition[0]) {
            this.shipPosition[0].hit();
            getHitMessage();
        }
    }
    
    
    /**
     *
     */
    @Override
    public boolean isHit() {
        if (this.shipPosition[0].isHit()) {
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
        System.out.println("Submarine is hit!");
    }
    
    /**
     *
     */
    @Override
    public void getSinkMessage() {
        System.out.println("Submarine is sinking!");
    }
    
    /**
     *
     */
    @Override
    public void threaten() {
        
    }    
       
}

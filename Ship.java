/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author ak
 */
public abstract class Ship {

    /**
     *
     * @param length
     * @param points
     * @param letter
     * @param field
     */
    public Ship(int length, int points, String letter, Field field) {
        this.length = length;
        this.points = points;
        this.letter = letter;
        this.field = field;
    }
    private final int length;
    private final int points;
    private final String letter;
    private final Field field;
    private Location start;
    private ShipDirection dir;
    
    /**
     *
     */
    public abstract void hit(Location loc);
    
    
     /**
     *
     * @return
     */
    public abstract Location[] getShipPosition();

    /**
     *
     */
    public abstract boolean isHit();

    /**
     *
     */
    public void isSinking() {
        
    }    
    
    /**
     *
     */
    public abstract void getHitMessage();
    
    /**
     *
     */
    public abstract void getSinkMessage();
    
    /**
     *
     */
    public abstract void threaten();
    
   
    /**
     *
     * @return
     */
    public int getLength() {
        return this.length;
    }

    /**
     *
     * @return
     */
    public int getPoints() {
        return this.points;
    }

    /**
     *
     * @return
     */
    public String getLetter() {
        return this.letter;
    }
        /**
     *
     * @param start
     */
    public void setStart (Location start) {
        this.start = start;
    }

    /**
     *
     * @param dir
     */
    public void setDir(ShipDirection dir) {
        this.dir = dir;
    }

    /**
     *
     * @return
     */
    public Location getStart () {
        return this.start;
    }

    /**
     *
     * @return
     */
    public ShipDirection getDir() {
        return this.dir;
    }
    
    
}
